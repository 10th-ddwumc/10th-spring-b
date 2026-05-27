package com.example.umc10th.domain.review.dto;

import jakarta.validation.constraints.*;

import java.util.List;

public class ReviewReqDTO {
    public record reviewReq(
            @NotNull
            Long storeId,
            @NotNull
            Long userId,
            @NotBlank(message = "리뷰 내용은 빈칸일 수 없습니다.")
            String content,
            List<Photo> photos,
            @NotNull(message = "리뷰 별점은 필수입니다.")
            @Min(0)
            @Max(5)
            Integer star
    ){}

    public record Photo(
            String photoUri
    ){}
}
