package com.ddwuumc.week4.review.dto;



import com.ddwuumc.week4.review.entity.Review;
import org.springframework.data.domain.Slice;

import java.util.List;

public class ReviewConverter {
    public static List<ReviewResponseDto.Review> convert(Slice<Review> reviewSlice) {
        return reviewSlice.stream()
                .map(ReviewConverter::convertToReview)
                .toList();
    }

    public static ReviewResponseDto.Review convertToReview(Review review) {
        return new ReviewResponseDto.Review(
                review.getStore().getId(),
                review.getContent(),
                review.getRate(),
                review.getCreatedAt().toLocalDate()
        );
    }
}
