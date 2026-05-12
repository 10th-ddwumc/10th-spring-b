package com.example.umcdongdong2.domain.review.dto;

import lombok.Builder;

import java.util.List;

public class RestaurantReviewListResDTO {

    @Builder
    public record Review(
            Long reviewId,
            Float star,
            String content
    ) {}

    // 6주차 구현
    @Builder
    public record RestaurantReviewListResponse(
            List<Review> reviews,
            Integer page,
            Integer size,
            Long totalElements,
            Integer totalPages,
            Boolean hasNext
    ) {}

    // 7주차 변경
    // 페이지네이션 틀
    @Builder
    public record Pagination<T>(
            List<T> data,
            Boolean hasNext,
            String nextCursor,
            Integer pageSize
    ){}
}
