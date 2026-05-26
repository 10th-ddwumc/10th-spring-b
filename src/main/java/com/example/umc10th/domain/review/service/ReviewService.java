package com.example.umc10th.domain.review.service;

import com.example.umc10th.domain.member.entity.User;
import com.example.umc10th.domain.member.exception.MemberException;
import com.example.umc10th.domain.member.exception.code.UserErrorCode;
import com.example.umc10th.domain.member.repositoty.UserRepository;
import com.example.umc10th.domain.mission.entity.Store;
import com.example.umc10th.domain.mission.exception.StoreException;
import com.example.umc10th.domain.mission.exception.code.StoreErrorCode;
import com.example.umc10th.domain.mission.repository.StoreRepository;
import com.example.umc10th.domain.review.converter.ReviewConverter;
import com.example.umc10th.domain.review.dto.ReviewReqDTO;
import com.example.umc10th.domain.review.dto.ReviewResDTO;
import com.example.umc10th.domain.review.entity.Photo;
import com.example.umc10th.domain.review.entity.Review;
import com.example.umc10th.domain.review.repository.PhotoRepository;
import com.example.umc10th.domain.review.repository.ReviewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReviewService {
    private static final String RATING_QUERY = "rating";
    private static final String STAR_QUERY = "star";

    private final ReviewRepository reviewRepository;
    private final PhotoRepository photoRepository;
    private final UserRepository userRepository;
    private final StoreRepository storeRepository;

    @Transactional
    public ReviewResDTO.Review review(ReviewReqDTO.reviewReq request) {
        User user = userRepository.findById(request.userId())
                .orElseThrow(() -> new MemberException(UserErrorCode.USER_NOT_FOUND));
        Store store = storeRepository.findById(request.storeId())
                .orElseThrow(() -> new StoreException(StoreErrorCode.NOT_FOUND));

        Review review = ReviewConverter.toReview(request, user, store);
        Review savedReview = reviewRepository.save(review);

        List<Photo> photos = request.photos() == null ? List.of() : request.photos().stream()
                .map(photo -> ReviewConverter.toPhoto(photo, savedReview))
                .toList();
        List<Photo> savedPhotos = photoRepository.saveAll(photos);

        return ReviewConverter.toReviewRes(savedReview, savedPhotos);
    }

    @Transactional(readOnly = true)
    public ReviewResDTO.Pagination<ReviewResDTO.Review> getReview(
            Long userId,
            Integer pageSize,
            String cursor,
            String query
    ) {
        int limit = Math.max(pageSize, 1);
        PageRequest pageRequest = PageRequest.of(0, limit + 1);
        List<Review> reviews = isRatingQuery(query)
                ? getReviewsByRating(userId, cursor, pageRequest)
                : getReviewsById(userId, cursor, pageRequest);

        boolean hasNext = reviews.size() > limit;
        List<Review> pageContent = reviews.stream()
                .limit(limit)
                .toList();
        String nextCursor = hasNext ? createNextCursor(pageContent.getLast(), query) : null;

        return ReviewConverter.toPagination(
                pageContent.stream()
                        .map(ReviewConverter::toReviewRes)
                        .toList(),
                hasNext,
                nextCursor,
                limit
        );
    }

    private List<Review> getReviewsById(Long userId, String cursor, PageRequest pageRequest) {
        Long cursorId = isFirstPage(cursor) ? null : Long.valueOf(cursor);
        return reviewRepository.findMyReviewsOrderByIdDesc(userId, cursorId, pageRequest);
    }

    private List<Review> getReviewsByRating(Long userId, String cursor, PageRequest pageRequest) {
        RatingCursor ratingCursor = parseRatingCursor(cursor);
        return reviewRepository.findMyReviewsOrderByRatingDesc(
                userId,
                ratingCursor.rating(),
                ratingCursor.id(),
                pageRequest
        );
    }

    private RatingCursor parseRatingCursor(String cursor) {
        if (isFirstPage(cursor)) {
            return new RatingCursor(null, null);
        }

        String[] tokens = cursor.split(",");
        return new RatingCursor(Double.valueOf(tokens[0]), Long.valueOf(tokens[1]));
    }

    private String createNextCursor(Review review, String query) {
        if (isRatingQuery(query)) {
            return review.getRating() + "," + review.getId();
        }

        return String.valueOf(review.getId());
    }

    private boolean isFirstPage(String cursor) {
        return cursor == null || cursor.isBlank() || cursor.equals("-1");
    }

    private boolean isRatingQuery(String query) {
        if (query == null) {
            return false;
        }

        return RATING_QUERY.equalsIgnoreCase(query) || STAR_QUERY.equalsIgnoreCase(query);
    }

    private record RatingCursor(
            Double rating,
            Long id
    ) {
    }
}
