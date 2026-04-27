package com.example.umc10th.domain.review.service;

import com.example.umc10th.domain.review.dto.ReviewReqDTO;
import com.example.umc10th.domain.review.dto.ReviewResDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReviewService {

    public ReviewResDTO.newReview addReview(Long memberId, Long storeId, ReviewReqDTO.newReview dto) {
        return null;
    }

    public List<ReviewResDTO.getReview> getReviews(Long storeId) {
        return null;
    }

    public ReviewResDTO.getReview getReview(Long reviewId) {
        return null;
    }

    public ReviewResDTO.newReview updateReview(Long memberId, Long reviewId, ReviewReqDTO.newReview dto) {
        return null;
    }

    public void deleteReview(Long memberId, Long reviewId) {
    }
}
