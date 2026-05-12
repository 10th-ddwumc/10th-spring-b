package com.example.umcdongdong2.domain.review.dto;

import lombok.Builder;

public class RestaurantInfoResDTO {

    @Builder
    public record RestaurantInfoResponse(
            Long restaurantId,
            String restaurantName,
            String address
    ) {}
}
