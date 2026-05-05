package com.example.umc10th.domain.review.converter;

import com.example.umc10th.domain.review.dto.ReviewReqDTO;
import com.example.umc10th.domain.review.dto.ReviewResDTO;

import java.time.LocalDateTime;

public class ReviewConverter {
    public static ReviewResDTO.reviewRes toReviewRes(ReviewReqDTO.reviewReq request) {
        return ReviewResDTO.reviewRes.builder()
                .nickname("홍길동")
                .content("리뷰")
                .star(request.star())
                .createAt(LocalDateTime.now())
                .build();
    }
}
