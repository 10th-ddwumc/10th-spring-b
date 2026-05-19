package com.example.umc10th.domain.member.service;

import com.example.umc10th.domain.member.dto.request.MemberReqDTO;
import com.example.umc10th.domain.member.dto.response.MemberResDTO;
import com.example.umc10th.domain.member.entity.Member;
import com.example.umc10th.domain.member.enums.Provider;
import com.example.umc10th.domain.member.exception.MemberException;
import com.example.umc10th.domain.member.exception.code.MemberErrorCode;
import com.example.umc10th.domain.member.repository.MemberRepository;
import com.example.umc10th.domain.review.dto.response.ReviewResDTO;
import com.example.umc10th.domain.review.entity.Review;
import com.example.umc10th.domain.review.repository.ReviewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MemberService {

    private final MemberRepository memberRepository;
    private final ReviewRepository reviewRepository;
    private final PasswordEncoder passwordEncoder;

    public MemberResDTO.SignUpResDTO signup(MemberReqDTO.SignUpReqDTO request) {
        if (memberRepository.findByEmail(request.getEmail()).isPresent()) {
            throw new MemberException(MemberErrorCode.EMAIL_ALREADY_EXISTS);
        }

        Member member = Member.builder()
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .name(request.getName())
                .gender(request.getGender())
                .birth(request.getBirthDate())
                .address(request.getAddress())
                .provider(Provider.TEST)
                .providerId("Test")
                .build();

        Member saved = memberRepository.save(member);

        return MemberResDTO.SignUpResDTO.builder()
                .memberId(saved.getId())
                .email(saved.getEmail())
                .name(saved.getName())
                .createdAt(saved.getCreatedAt())
                .build();
    }

    public MemberResDTO.MyPageResDTO getMyPage(Long memberId) {
        Member member = memberRepository.findById(memberId)
                .orElseThrow(() -> new MemberException(MemberErrorCode.MEMBER_NOT_FOUND));

        return MemberResDTO.MyPageResDTO.builder()
                .nickname(member.getName())
                .profileImageUrl(member.getProfileImageUrl())
                .email(member.getProviderId())
                .phoneNumber(member.getPhoneNumber())
                .phoneVerified(member.getPhoneNumber() != null)
                .point(member.getPoint() != null ? member.getPoint() : 0)
                .build();
    }

    public ReviewResDTO.MyReviewCursorListResDTO getMyReviews(
            Long memberId, String sort, int size, Long cursorId, Float cursorRating) {

        memberRepository.findById(memberId)
                .orElseThrow(() -> new MemberException(MemberErrorCode.MEMBER_NOT_FOUND));

        Pageable pageable = PageRequest.of(0, size + 1);
        List<Review> reviews;

        if ("RATING".equalsIgnoreCase(sort)) {
            reviews = reviewRepository.findByMemberIdOrderByRating(memberId, cursorRating, cursorId, pageable);
        } else {
            reviews = reviewRepository.findByMemberIdOrderById(memberId, cursorId, pageable);
        }

        boolean hasNext = reviews.size() > size;
        if (hasNext) reviews = reviews.subList(0, size);

        List<ReviewResDTO.MyReviewDTO> dtos = reviews.stream()
                .map(r -> ReviewResDTO.MyReviewDTO.builder()
                        .reviewId(r.getId())
                        .storeName(r.getStore().getStoreName())
                        .nickname(r.getMember().getName())
                        .rating(r.getRating())
                        .content(r.getContent())
                        .createdAt(r.getCreatedAt())
                        .build())
                .toList();

        Review last = reviews.isEmpty() ? null : reviews.get(reviews.size() - 1);

        return ReviewResDTO.MyReviewCursorListResDTO.builder()
                .reviews(dtos)
                .nextCursorId(hasNext && last != null ? last.getId() : null)
                .nextCursorRating(hasNext && last != null ? last.getRating() : null)
                .hasNext(hasNext)
                .build();
    }
}
