package com.example.umcdongdong2.domain.review.dto;

import lombok.Builder;

public class RestaurantReviewCreateResDTO {

    @Builder
    public record RestaurantReviewCreateResponse(
            Long reviewId
    ) {}
}
