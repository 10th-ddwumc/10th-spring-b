package com.ddwuumc.week4.review.controller;

import com.ddwuumc.week4.global.code.error.ReviewSuccessCode;
import com.ddwuumc.week4.global.common.ApiResponse;
import com.ddwuumc.week4.global.common.PageDto.Cursor;
import com.ddwuumc.week4.review.dto.ReviewRequestDto;
import com.ddwuumc.week4.review.dto.ReviewResponseDto.Review;
import com.ddwuumc.week4.review.service.ReviewService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class ReviewController {

    private final ReviewService reviewService;

    @PostMapping("/api/reviews")
    public ResponseEntity<ApiResponse<Long>> createReview(@RequestBody @Valid ReviewRequestDto.Review review) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(ApiResponse.onSuccess(ReviewSuccessCode.REVIEW_CREATED, reviewService.createReview(review)));
    }

    @GetMapping("/api/reviews")
    public ResponseEntity<ApiResponse<Cursor<Review>>> readReview(@RequestParam Long query,
                                                                  @RequestParam Long cursor,
                                                                  @RequestParam Integer pageSize,
                                                                  @RequestParam String sort) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(ApiResponse.onSuccess(ReviewSuccessCode.REVIEW_OK, reviewService.readReview(query, cursor, pageSize, sort)));

    }
}
