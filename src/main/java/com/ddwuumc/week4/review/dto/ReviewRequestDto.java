package com.ddwuumc.week4.review.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class ReviewRequestDto {
    public record Review (
            @NotNull
            Long storeId,
            @NotBlank(message = "내용은 필수입니다.")
            String content,
            @Size(min = 1, max = 5, message = "별점은 최소 1에서 최대 5까지 가능합니다.")
            Integer rate
//            Optional<List<Photo>> photo
    ) {}

    public record Photo (
        String photoUrl,
        Integer orderIndex
    ) {}
}
