package com.example.umcdongdong2.domain.review.converter;

import com.example.umcdongdong2.domain.review.dto.RestaurantReviewListResDTO;
import com.example.umcdongdong2.domain.review.entity.Review;

import java.util.List;

public class ReviewConverter {
    public ReviewConverter() {}


    public static RestaurantReviewListResDTO.Review toRestaurantReview(Review review) {
        return RestaurantReviewListResDTO.Review.builder()
                .reviewId(review.getId())
                .star(review.getStar())
                .content(review.getContent())
                .build();
    }



    public static <T> RestaurantReviewListResDTO.Pagination<T> toPagination(
            List<T> data,
            Boolean hasNext,
            String nextCursor,
            Integer pageSize
    ){
        return RestaurantReviewListResDTO.Pagination.<T>builder()
                .data(data)
                .hasNext(hasNext)
                .nextCursor(nextCursor)
                .pageSize(pageSize)
                .build();
    }
}
