package com.example.umc10th.domain.review.converter;

import com.example.umc10th.domain.review.dto.ReviewReqDTO;
import com.example.umc10th.domain.review.dto.ReviewResDTO;
import com.example.umc10th.domain.review.entity.Review;

import java.time.LocalDateTime;
import java.util.List;

public class ReviewConverter {
    public static ReviewResDTO.Review toReviewRes(ReviewReqDTO.reviewReq request) {
        return ReviewResDTO.Review.builder()
                .nickname("홍길동")
                .content("리뷰")
                .star(request.star())
                .createAt(LocalDateTime.now())
                .build();
    }

    public static ReviewResDTO.Review toReviewRes(Review review) {
        return ReviewResDTO.Review.builder()
                .nickname(review.getUser().getNickname())
                .star(review.getRating().intValue())
                .content(review.getContent())
                .photos(review.getPhotoList().stream()
                        .map(photo -> new ReviewResDTO.Photo(photo.getUrl()))
                        .toList())
                .createAt(review.getCreatedAt())
                .build();
    }

    public static <T> ReviewResDTO.Pagination<T> toPagination(
            List<T> data,
            Boolean hasNext,
            String nextCursor,
            Integer pageSize
    ){
        return ReviewResDTO.Pagination.<T>builder()
                .data(data)
                .hasNext(hasNext)
                .nextCursor(nextCursor)
                .pageSize(pageSize)
                .build();
    }
}
