package com.ddwuumc.week4.review.service;

import com.ddwuumc.week4.review.dto.ReviewRequestDto;
import com.ddwuumc.week4.review.repository.ReviewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ReviewService {
    
    private final ReviewRepository reviewRepository;

    public Long createReview(ReviewRequestDto.Review review) {
        return 100L; // 생성한 리뷰의 review_id
    }
}
