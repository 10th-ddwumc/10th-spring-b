package com.example.umc10th.domain.review.dto;

import lombok.Builder;

import java.time.LocalDateTime;

public class ReviewResDTO {
    @Builder
    public record reviewRes(
        Long reviewId,
        Integer star,
        LocalDateTime createAt
    ){}
}
