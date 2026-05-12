package com.example.umc10th.domain.review.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.Page;

import java.time.LocalDateTime;
import java.util.List;

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

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class MyReviewDTO {
        private Long reviewId;
        private String storeName;
        private String nickname;
        private Float rating;
        private String content;
        private LocalDateTime createdAt;
    }

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class MyReviewListResDTO {
        private Page<MyReviewDTO> reviews;
    }

    @Builder @Getter @NoArgsConstructor @AllArgsConstructor
    public static class MyReviewCursorListResDTO {
        private List<MyReviewDTO> reviews;
        private Long nextCursorId;
        private Float nextCursorRating;
        private boolean hasNext;
    }
}
