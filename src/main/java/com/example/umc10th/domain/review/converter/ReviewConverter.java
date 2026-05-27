package com.example.umc10th.domain.review.converter;

import com.example.umc10th.domain.member.entity.User;
import com.example.umc10th.domain.mission.entity.Store;
import com.example.umc10th.domain.review.dto.ReviewReqDTO;
import com.example.umc10th.domain.review.dto.ReviewResDTO;
import com.example.umc10th.domain.review.entity.Photo;
import com.example.umc10th.domain.review.entity.Review;

import java.util.List;

public class ReviewConverter {

    public static Review toReview(ReviewReqDTO.reviewReq request, User user, Store store) {
        return Review.builder()
                .user(user)
                .store(store)
                .rating(request.star().doubleValue())
                .content(request.content())
                .build();
    }

    public static Photo toPhoto(ReviewReqDTO.Photo request, Review review) {
        return Photo.builder()
                .review(review)
                .url(request.photoUri())
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

    public static ReviewResDTO.Review toReviewRes(Review review, List<Photo> photos) {
        return ReviewResDTO.Review.builder()
                .nickname(review.getUser().getNickname())
                .star(review.getRating().intValue())
                .content(review.getContent())
                .photos(photos.stream()
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
