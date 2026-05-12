package com.ddwuumc.week4.review.service;

import com.ddwuumc.week4.global.code.success.StoreErrorCode;
import com.ddwuumc.week4.global.code.success.UserErrorCode;
import com.ddwuumc.week4.global.common.PageDto.Cursor;
import com.ddwuumc.week4.global.exception.ProjectException;
import com.ddwuumc.week4.review.dto.ReviewConverter;
import com.ddwuumc.week4.review.dto.ReviewRequestDto;
import com.ddwuumc.week4.review.dto.ReviewResponseDto;
import com.ddwuumc.week4.review.entity.Review;
import com.ddwuumc.week4.review.repository.ReviewRepository;
import com.ddwuumc.week4.store.entity.Store;
import com.ddwuumc.week4.store.repository.StoreRepository;
import com.ddwuumc.week4.user.entity.User;
import com.ddwuumc.week4.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReviewService {

    private final ReviewRepository reviewRepository;
    private final UserRepository userRepository;
    private final StoreRepository storeRepository;

    public Long createReview(ReviewRequestDto.Review reviewDto) {
        // TODO: user id는 하드코딩함
        // TODO: 구체적인 예외를 두지 않고 공통 예외로 대체
        User user = userRepository.findById(0L).orElseThrow(() -> new ProjectException(UserErrorCode.USER_NOT_FOUND));
        Store store = storeRepository.findById(reviewDto.storeId()).orElseThrow(() -> new ProjectException(StoreErrorCode.STORE_NOT_FOUND));

        Review review = Review.create(reviewDto.content(), reviewDto.rate(), user, store);

        return reviewRepository.save(review).getId();
    }

    public Cursor<ReviewResponseDto.Review> readReview(Long query, Long cursor, Integer pageSize, String sort) {
        Sort sortInfo;
        if (sort.equals("rate")) {
            sortInfo = Sort.by(sort);
        } else {
            sortInfo = Sort.by("userId");
        }

        Pageable pageable = PageRequest.of(0, pageSize, sortInfo);
        Slice<Review> reviewSlice = reviewRepository.findByUserIdAndIdLessThanOrderByIdDesc(query, cursor, pageable);
        List<ReviewResponseDto.Review> reviewList = ReviewConverter.convert(reviewSlice);
        return new Cursor<>(
                reviewList,
                pageSize,
                cursor,
                reviewSlice.hasNext()
        );
    }
}
