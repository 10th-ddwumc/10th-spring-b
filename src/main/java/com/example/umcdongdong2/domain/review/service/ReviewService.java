package com.example.umcdongdong2.domain.review.service;

import com.example.umcdongdong2.domain.review.controller.ReviewController;
import com.example.umcdongdong2.domain.review.converter.ReviewConverter;
import com.example.umcdongdong2.domain.review.dto.RestaurantReviewCreateReqDTO;
import com.example.umcdongdong2.domain.review.dto.RestaurantReviewCreateResDTO;
import com.example.umcdongdong2.domain.review.dto.RestaurantReviewListReqDTO;
import com.example.umcdongdong2.domain.review.dto.RestaurantReviewListResDTO;
import com.example.umcdongdong2.domain.review.entity.Restaurant;
import com.example.umcdongdong2.domain.review.entity.Review;
import com.example.umcdongdong2.domain.review.exception.ReviewException;
import com.example.umcdongdong2.domain.review.exception.code.ReviewErrorCode;
import com.example.umcdongdong2.domain.review.repository.RestaurantRepository;
import com.example.umcdongdong2.domain.review.repository.ReviewRepository;
import com.example.umcdongdong2.domain.user.entity.User;
import com.example.umcdongdong2.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ReviewService {
    private final ReviewRepository reviewRepository;
    private final RestaurantRepository restaurantRepository;
    private final UserRepository userRepository;

    public RestaurantReviewCreateResDTO.RestaurantReviewCreateResponse createReview(
            Long restaurantId,
            RestaurantReviewCreateReqDTO.RestaurantReviewCreateRequest dto
        ){

        Restaurant r = restaurantRepository.findById(restaurantId)
                .orElseThrow(() -> new ReviewException("restaurant이 존재하지 않습니다."));
        User user = userRepository.findById(dto.userId()).orElseThrow(() -> new ReviewException("유저가 존재하지 않습니다"));

        Review review = Review.builder().
                user(user).
                star(dto.star()).
                content(dto.content()).
                restaurant(r).
                build();

        review = reviewRepository.save(review);

        return RestaurantReviewCreateResDTO.RestaurantReviewCreateResponse.builder().reviewId(review.getId()).build();
    }

    public RestaurantReviewListResDTO.Pagination<RestaurantReviewListResDTO.Review> getRestaurantReviews(
            Long restaurantId,
            Integer pageSize,
            String cursor,
            String query
    ){

        // 커서 기반에서는 0으로 시작
        PageRequest pageRequest = PageRequest.of(0, pageSize);

        long idCursor;
        float starCursor;
        Long prevCursor;
        Slice<Review> reviewList;
        String nextCursor;

        // 커서가 있는 경우
        if(!cursor.equals("-1")){
            //커서 분리
            String[] cursorSplit = cursor.split(":");

            switch (query.toLowerCase()) {
                case "id":

                    prevCursor = Long.parseLong(cursorSplit[0]);
                    idCursor = Long.parseLong(cursorSplit[1]);

                    // 리뷰 조회 & where절에 커서값 대입
                    reviewList = reviewRepository.findAllByRestaurantIdAndIdLessThanOrderByIdDesc(
                            restaurantId,
                            idCursor,
                            pageRequest
                    );

                    break;
                case "star":
                    prevCursor = Long.parseLong(cursorSplit[0]);
                    starCursor = Long.parseLong(cursorSplit[1]);

                    // 리뷰 조회 & where절에 커서값 대입
                    reviewList = reviewRepository.findAllByRestaurantIdAndStarLessThanOrderByStarDesc(
                            restaurantId,
                            starCursor,
                            pageRequest
                    );

                    break;
                default:
                    throw new ReviewException(ReviewErrorCode.REVIEW_BAD_REQUEST.getMessage());
            }
        }else { // 커서가 없는 경우
            // 커서 없이 조회


            switch (query.toLowerCase()) {
                case "id":


                    // 리뷰 조회
                    reviewList = reviewRepository.findAllByRestaurantIdOrderByIdDesc(
                            restaurantId,
                            pageRequest
                    );

                    break;
                case "star":


                    // 리뷰 조회
                    reviewList = reviewRepository.findAllByRestaurantIdOrderByStarDesc(
                            restaurantId,
                            pageRequest
                    );

                    break;
                default:
                    throw new ReviewException(ReviewErrorCode.REVIEW_BAD_REQUEST.getMessage());
            }
        }


        //다음 커서 계산
        //원래 : 앞뒤로 서로 다른 컬럼의 커서값 있어야
        nextCursor = reviewList.getContent().getLast().getId().toString() +
                    ":" +
                    reviewList.getContent().getLast().getId().toString();

        return ReviewConverter.toPagination(
                reviewList.map(ReviewConverter::toRestaurantReview).toList(),
                reviewList.hasNext(),
                nextCursor,
                reviewList.getSize()
        );


    }

}
