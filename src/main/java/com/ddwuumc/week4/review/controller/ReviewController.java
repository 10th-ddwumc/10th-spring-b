package com.ddwuumc.week4.review.controller;

import com.ddwuumc.week4.global.code.GeneralCode;
import com.ddwuumc.week4.global.common.ApiResponse;
import com.ddwuumc.week4.review.dto.ReviewRequestDto;
import com.ddwuumc.week4.review.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ReviewController {

    private final ReviewService reviewService;

    @PostMapping("/api/reviews")
    public ResponseEntity<ApiResponse<Long>> createReview(@RequestBody ReviewRequestDto.Review review) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(ApiResponse.onSuccess(GeneralCode.CREATED, reviewService.createReview(review)));
    }
}
