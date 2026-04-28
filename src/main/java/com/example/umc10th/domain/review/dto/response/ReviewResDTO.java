package com.example.umc10th.domain.review.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

public class ReviewResDTO {
    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class CreateReviewResDTO {
        private Long reviewId;
        private Double rating;
        private String content;
        private String storeName;
        private LocalDateTime createdAt;
    }
}
