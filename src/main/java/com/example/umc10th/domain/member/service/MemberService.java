package com.example.umc10th.domain.member.service;

import com.example.umc10th.domain.member.dto.request.MemberReqDTO;
import com.example.umc10th.domain.member.dto.response.MemberResDTO;
import com.example.umc10th.domain.member.entity.Member;
import com.example.umc10th.domain.member.exception.MemberException;
import com.example.umc10th.domain.member.exception.code.MemberErrorCode;
import com.example.umc10th.domain.member.repository.MemberRepository;
import com.example.umc10th.domain.review.dto.response.ReviewResDTO;
import com.example.umc10th.domain.review.repository.ReviewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MemberService {

    private MemberRepository memberRepository;
    private ReviewRepository reviewRepository;

//    public MemberResDTO.HomeResDTO getHome(String region, int page, int size) {
//    }

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

    public ReviewResDTO.MyReviewListResDTO getMyReviews(Long memberId, int page, int size) {
        Member member = memberRepository.findById(memberId)
                .orElseThrow(() -> new MemberException(MemberErrorCode.MEMBER_NOT_FOUND));

        Page<ReviewResDTO.MyReviewDTO> reviewPage =
                reviewRepository.findByMemberWithDetails(member, PageRequest.of(page, size))
                        .map(review -> ReviewResDTO.MyReviewDTO.builder()
                                .reviewId(review.getId())
                                .storeName(review.getStore().getStoreName())
                                .rating(Double.valueOf(review.getRating()))
                                .content(review.getContent())
                                .photoUrls(review.getReviewPhotoList().stream()
                                        .map(photo -> photo.getPhotoUrl())
                                        .toList())
                                .createdAt(review.getCreatedAt())
                                .build());

        return ReviewResDTO.MyReviewListResDTO.builder()
                .reviews(reviewPage)
                .build();
    }
}
