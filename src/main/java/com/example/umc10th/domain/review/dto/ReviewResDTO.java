package com.example.umc10th.domain.review.dto;

import lombok.Builder;

public class ReviewResDTO {

    // 리뷰 생성 응답
    @Builder
    public record newReview(
            Long id
    ) {}

    // 리뷰 조회 응답 (단건/다건)
    @Builder
    public record getReview(
            Long reviewId,
            Double rating,
            String content,
            String memberName,
            String storeName
    ) {}
}
