package com.example.umc10th.domain.review.repository;

import com.example.umc10th.domain.review.entity.Review;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ReviewRepository extends JpaRepository<Review, Long> {
    @Query("""
            SELECT r
            FROM Review r
            JOIN FETCH r.user u
            WHERE u.id = :userId
            AND (:cursorId IS NULL OR r.id < :cursorId)
            ORDER BY r.id DESC
            """)
    List<Review> findMyReviewsOrderByIdDesc(
            @Param("userId") Long userId,
            @Param("cursorId") Long cursorId,
            Pageable pageable
    );

    @Query("""
            SELECT r
            FROM Review r
            JOIN FETCH r.user u
            WHERE u.id = :userId
            AND (
                :cursorRating IS NULL
                OR r.rating < :cursorRating
                OR (r.rating = :cursorRating AND r.id < :cursorId)
            )
            ORDER BY r.rating DESC, r.id DESC
            """)
    List<Review> findMyReviewsOrderByRatingDesc(
            @Param("userId") Long userId,
            @Param("cursorRating") Double cursorRating,
            @Param("cursorId") Long cursorId,
            Pageable pageable
    );
}
