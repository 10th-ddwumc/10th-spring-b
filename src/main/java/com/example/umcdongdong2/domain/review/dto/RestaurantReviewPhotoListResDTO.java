package com.example.umcdongdong2.domain.review.dto;

import lombok.Builder;

import java.util.List;

public class RestaurantReviewPhotoListResDTO {

    @Builder
    public record RestaurantReviewPhotoListResponse(
            List<String> imageUrls
    ) {}
}
