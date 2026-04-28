package com.ddwuumc.week4.review.dto;

import java.util.List;
import java.util.Optional;

public class ReviewRequestDto {
    public record Review (
            Long storeId,
            String content,
            Integer rate,
            Optional<List<Photo>> photo
    ) {}

    public record Photo (
        String photoUrl,
        Integer orderIndex
    ) {}
}
