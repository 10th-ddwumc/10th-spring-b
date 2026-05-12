package com.example.umcdongdong2.domain.review.controller;

import com.example.umcdongdong2.domain.review.dto.RestaurantInfoReqDTO;
import com.example.umcdongdong2.domain.review.dto.RestaurantInfoResDTO;
import com.example.umcdongdong2.domain.review.dto.RestaurantReviewCreateReqDTO;
import com.example.umcdongdong2.domain.review.dto.RestaurantReviewCreateResDTO;
import com.example.umcdongdong2.domain.review.dto.RestaurantReviewListReqDTO;
import com.example.umcdongdong2.domain.review.dto.RestaurantReviewListResDTO;
import com.example.umcdongdong2.domain.review.dto.RestaurantReviewPhotoListReqDTO;
import com.example.umcdongdong2.domain.review.dto.RestaurantReviewPhotoListResDTO;
import com.example.umcdongdong2.domain.review.exception.code.ReviewSuccessCode;
import com.example.umcdongdong2.domain.review.service.ReviewService;
import com.example.umcdongdong2.global.apiPayload.ApiResponse;
import com.example.umcdongdong2.global.apiPayload.code.BaseSuccessCode;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class ReviewController {

    private final ReviewService reviewService;

    @GetMapping("/restaurants/{restaurantId}/")
    public ApiResponse<RestaurantInfoResDTO.RestaurantInfoResponse> getRestaurantInfo(
            @RequestHeader("Authorization") String authorization,
            @PathVariable Long restaurantId,
            @ModelAttribute RestaurantInfoReqDTO.RestaurantInfoRequest dto
    ) {
        BaseSuccessCode code = ReviewSuccessCode.OK;

        return null;
//        return ApiResponse.onSuccess(code, reviewService.getRestaurantInfo(authorization, restaurantId, dto));
    }

    @GetMapping("/restaurants/{restaurantId}/reviews/lists-photos")
    public ApiResponse<RestaurantReviewPhotoListResDTO.RestaurantReviewPhotoListResponse> getRestaurantReviewPhotos(
            @RequestHeader("Authorization") String authorization,
            @PathVariable Long restaurantId,
            @ModelAttribute RestaurantReviewPhotoListReqDTO.RestaurantReviewPhotoListRequest dto
    ) {
        BaseSuccessCode code = ReviewSuccessCode.OK;

        return null;
//        return ApiResponse.onSuccess(code, reviewService.getRestaurantReviewPhotos(authorization, restaurantId, dto));
    }

    @GetMapping("/restaurants/{restaurantId}/reviews/")
    public ApiResponse<RestaurantReviewListResDTO.Pagination<RestaurantReviewListResDTO.Review>> getRestaurantReviews(
            @RequestHeader(value = "Authorization", required = false) String authorization,
            @PathVariable Long restaurantId,
            @RequestParam Integer pageSize,
            @RequestParam String cursor, // query:ID 구조
            @RequestParam String query
    ) {
        BaseSuccessCode code = ReviewSuccessCode.OK;

        return ApiResponse.onSuccess(code, reviewService.getRestaurantReviews(restaurantId, pageSize, cursor, query));
    }

    @PostMapping("/restaurants/{restaurantId}/reviews/")
    public ApiResponse<RestaurantReviewCreateResDTO.RestaurantReviewCreateResponse> createRestaurantReview(
            @RequestHeader(value = "Authorization", required = false) String authorization,
            @PathVariable Long restaurantId,
            @RequestBody @Valid RestaurantReviewCreateReqDTO.RestaurantReviewCreateRequest dto
    ) {
        BaseSuccessCode code = ReviewSuccessCode.OK;

        return ApiResponse.onSuccess(code, reviewService.createReview(restaurantId, dto));
    }
}
