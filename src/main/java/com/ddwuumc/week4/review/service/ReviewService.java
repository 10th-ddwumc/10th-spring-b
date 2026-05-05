package com.ddwuumc.week4.review.service;

import com.ddwuumc.week4.global.code.GeneralCode;
import com.ddwuumc.week4.global.exception.ProjectException;
import com.ddwuumc.week4.review.dto.ReviewRequestDto;
import com.ddwuumc.week4.review.entity.Review;
import com.ddwuumc.week4.review.repository.ReviewRepository;
import com.ddwuumc.week4.store.entity.Store;
import com.ddwuumc.week4.store.repository.StoreRepository;
import com.ddwuumc.week4.user.entity.User;
import com.ddwuumc.week4.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ReviewService {

    private final ReviewRepository reviewRepository;
    private final UserRepository userRepository;
    private final StoreRepository storeRepository;

    public Long createReview(ReviewRequestDto.Review reviewDto) {
        // TODO: user id는 하드코딩함
        // TODO: 구체적인 예외를 두지 않고 공통 예외로 대체
        User user = userRepository.findById(0L).orElseThrow(() -> new ProjectException(GeneralCode.NOT_FOUND));
        Store store = storeRepository.findById(reviewDto.storeId()).orElseThrow(() -> new ProjectException(GeneralCode.NOT_FOUND));

        Review review = Review.create(reviewDto.content(), reviewDto.rate(), user, store);

        return reviewRepository.save(review).getId();
    }
}
