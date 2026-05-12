package com.example.umcdongdong2.domain.review.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;

import java.util.List;

public class RestaurantReviewCreateReqDTO {

    @Builder
    public record RestaurantReviewCreateRequest(
            @NotNull(message = "사용자 id는 필수입니다.")
            Long userId,
            @NotNull(message = "별점은 필수입니다.")
            Float star,
            @NotBlank(message = "리뷰 내용은 필수입니다.")
            String content,
            List<String> imageUrls
    ) {}
}
