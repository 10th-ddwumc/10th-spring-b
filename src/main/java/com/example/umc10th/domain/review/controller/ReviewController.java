package com.example.umc10th.domain.review.controller;

import com.example.umc10th.domain.review.dto.request.ReviewReqDTO;
import com.example.umc10th.domain.review.dto.response.ReviewResDTO;
import com.example.umc10th.domain.review.service.ReviewService;
import com.example.umc10th.global.apiPayload.ApiResponse;
import com.example.umc10th.global.apiPayload.code.BaseSuccessCode;
import com.example.umc10th.global.apiPayload.code.GeneralSuccessCode;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class ReviewController {

    private final ReviewService reviewService;

    @PostMapping("/reviews")
    public ApiResponse<ReviewResDTO.CreateReviewResDTO> createReview(
            @RequestParam Long memberId,
            @RequestBody @Valid ReviewReqDTO dto
    ) {
        return ApiResponse.onSuccess(GeneralSuccessCode.OK, reviewService.createReview(memberId, dto));
    }

}
