package com.example.umc10th.domain.review.converter;

import com.example.umc10th.domain.review.dto.ReviewResDTO;
import com.example.umc10th.domain.review.entity.Review;

public class ReviewConverter {

    // 리뷰 생성 응답 DTO로 변환
    public static ReviewResDTO.newReview toNewReview(Review review) {
        return ReviewResDTO.newReview.builder()
                .id(review.getId())
                .build();
    }

    // 리뷰 조회 응답 DTO로 변환
    public static ReviewResDTO.getReview toGetReview(Review review) {
        return ReviewResDTO.getReview.builder()
                .reviewId(review.getId())
                .rating(review.getRating())
                .content(review.getContent())
                .memberName(review.getMember().getName())
                .storeName(review.getStore().getName())
                .build();
    }
}
