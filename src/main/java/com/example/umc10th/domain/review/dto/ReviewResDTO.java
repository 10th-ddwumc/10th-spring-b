package com.example.umc10th.domain.review.dto;

import lombok.Builder;

import java.time.LocalDateTime;
import java.util.List;

public class ReviewResDTO {
    @Builder
    public record reviewRes(
        String nickname,
        Integer star,
        String content,
        List<Photo> photos,
        LocalDateTime createAt
    ){}

    public record Photo(
      String photoUri
    ){}
}
