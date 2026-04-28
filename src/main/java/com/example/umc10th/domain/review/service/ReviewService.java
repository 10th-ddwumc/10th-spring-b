package com.example.umc10th.domain.review.service;

import com.example.umc10th.domain.review.converter.ReviewConverter;
import com.example.umc10th.domain.review.dto.ReviewReqDTO;
import com.example.umc10th.domain.review.dto.ReviewResDTO;
import org.springframework.stereotype.Service;

@Service
public class ReviewService {
    public ReviewResDTO.reviewRes review(ReviewReqDTO.reviewReq request) {
        return ReviewConverter.toReviewRes(request);
    }
}
