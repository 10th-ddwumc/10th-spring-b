package com.example.umc10th.domain.review.controller;

import com.example.umc10th.domain.review.dto.ReviewReqDTO;
import com.example.umc10th.domain.review.dto.ReviewResDTO;
import com.example.umc10th.domain.review.exception.code.ReviewSuccessCode;
import com.example.umc10th.domain.review.service.ReviewService;
import com.example.umc10th.global.apiPayload.ApiResponse;
import com.example.umc10th.global.apiPayload.code.BaseSuccessCode;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class ReviewController {
    private final ReviewService reviewService;

    @PostMapping("/review")
    public ApiResponse<ReviewResDTO.Review> review(
            @RequestBody @Valid
            ReviewReqDTO.reviewReq request
    ){
        BaseSuccessCode code = ReviewSuccessCode.REVIEW_CREATED;
        return ApiResponse.onSuccess(code, reviewService.review(request));
    }

    @GetMapping("/my/review")
    public ApiResponse<ReviewResDTO.Pagination<ReviewResDTO.Review>> getMyReview(
            @RequestParam Long userId,
            @RequestParam Integer pageSize,
            @RequestParam(required = false) String cursor,
            @RequestParam(defaultValue = "id") String query
    ) {
        BaseSuccessCode code = ReviewSuccessCode.REVIEW_FOUND;
        return ApiResponse.onSuccess(code, reviewService.getReview(userId, pageSize, cursor, query));
    }
}
