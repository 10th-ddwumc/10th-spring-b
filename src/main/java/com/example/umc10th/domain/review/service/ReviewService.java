package com.example.umc10th.domain.review.service;

import com.example.umc10th.domain.member.entity.Member;
import com.example.umc10th.domain.member.repository.MemberRepository;
import com.example.umc10th.domain.review.dto.request.ReviewReqDTO;
import com.example.umc10th.domain.review.dto.response.ReviewResDTO;
import com.example.umc10th.domain.review.entity.Review;
import com.example.umc10th.domain.review.repository.ReviewRepository;
import com.example.umc10th.domain.store.entity.Store;
import com.example.umc10th.domain.store.repository.StoreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ReviewService {
    private final ReviewRepository reviewRepository;
    private final MemberRepository memberRepository;
    private final StoreRepository storeRepository;

    /**
     * 리뷰 작성
     */
    @Transactional
    public ReviewResDTO.CreateReviewResDTO createReview(Long memberId, ReviewReqDTO dto) {
        Member member = memberRepository.findById(memberId)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 회원입니다."));

        Store store = storeRepository.findByStoreName(dto.getStoreName())
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 가게입니다."));

        Review review = Review.builder()
                .member(member)
                .store(store)
                .rating(dto.getRating().floatValue())
                .content(dto.getContent())
                .build();

        Review saved = reviewRepository.save(review);

        return ReviewResDTO.CreateReviewResDTO.builder()
                .reviewId(saved.getId())
                .rating(dto.getRating())
                .content(saved.getContent())
                .storeName(store.getStoreName())
                .createdAt(saved.getCreatedAt())
                .build();
    }
}
