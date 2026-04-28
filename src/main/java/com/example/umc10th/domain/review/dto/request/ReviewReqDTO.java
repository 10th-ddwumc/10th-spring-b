package com.example.umc10th.domain.review.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ReviewReqDTO {
    @NotNull
    private Double rating;

    @NotBlank
    private String content;

    @NotBlank
    private String storeName;
}
