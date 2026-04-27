package com.example.umc10th.domain.review.controller;

import com.example.umc10th.domain.review.dto.ReviewReqDTO;
import com.example.umc10th.domain.review.dto.ReviewResDTO;
import com.example.umc10th.domain.review.exception.code.ReviewSuccessCode;
import com.example.umc10th.domain.review.service.ReviewService;
import com.example.umc10th.global.ApiResponse;
import com.example.umc10th.global.code.BaseSuccessCode;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ReviewController {

    private final ReviewService reviewService;

    //리뷰 작성
    @PostMapping("/api/{memberId}/stores/{storeId}/reviews")
    public ApiResponse<ReviewResDTO.newReview> addReview(
            @PathVariable("memberId") Long memberId,
            @PathVariable("storeId") Long storeId,
            @RequestBody ReviewReqDTO.newReview dto
    ) {
        BaseSuccessCode code = ReviewSuccessCode.ADD_REVIEW_OK;
        return ApiResponse.onSuccess(code, reviewService.addReview(memberId, storeId, dto));

    }

    // 가게 리뷰 목록 조회
    @GetMapping("/api/stores/{storeId}/reviews")
    public ApiResponse<List<ReviewResDTO.getReview>> getReviews(
            @PathVariable("storeId") Long storeId
    ) {
        BaseSuccessCode code = ReviewSuccessCode.GET_REVIEW_OK;
        return ApiResponse.onSuccess(code, reviewService.getReviews(storeId));
    }

    // 리뷰 단건 조회
    @GetMapping("/api/reviews/{reviewId}")
    public ApiResponse<ReviewResDTO.getReview> getReview(
            @PathVariable("reviewId") Long reviewId
    ) {
        BaseSuccessCode code = ReviewSuccessCode.GET_REVIEW_OK;
        return ApiResponse.onSuccess(code, reviewService.getReview(reviewId));
    }

    // 리뷰 수정
    @PatchMapping("/api/{memberId}/reviews/{reviewId}")
    public ApiResponse<ReviewResDTO.newReview> updateReview(
            @PathVariable("memberId") Long memberId,
            @PathVariable("reviewId") Long reviewId,
            @RequestBody ReviewReqDTO.newReview dto
    ) {
        BaseSuccessCode code = ReviewSuccessCode.UPDATE_REVIEW_OK;
        return ApiResponse.onSuccess(code, reviewService.updateReview(memberId, reviewId, dto));
    }

    // 리뷰 삭제
    @DeleteMapping("/api/{memberId}/reviews/{reviewId}")
    public ApiResponse<String> deleteReview(
            @PathVariable("memberId") Long memberId,
            @PathVariable("reviewId") Long reviewId
    ) {
        BaseSuccessCode code = ReviewSuccessCode.DELETE_REVIEW_OK;
        reviewService.deleteReview(memberId, reviewId);
        return ApiResponse.onSuccess(code, "리뷰가 삭제되었습니다.");
    }
}
