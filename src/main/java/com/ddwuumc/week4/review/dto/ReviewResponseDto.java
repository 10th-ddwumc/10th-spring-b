package com.ddwuumc.week4.review.dto;

import java.time.LocalDate;

public class ReviewResponseDto {
    public record Review(
            Long storeId,
            String content,
            Integer rate,
            LocalDate time
//            Optional<List<Photo>> photo
    ) {}

    public record Photo (
        String photoUrl,
        Integer orderIndex
    ) {}
}
