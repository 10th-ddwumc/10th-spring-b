package com.example.umc10th.domain.review.repository;

import com.example.umc10th.domain.member.entity.Member;
import com.example.umc10th.domain.review.entity.Review;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ReviewRepository extends JpaRepository<Review, Long> {
    @Query("SELECT r FROM Review r " +
            "JOIN FETCH r.store " +
            "LEFT JOIN FETCH r.reviewPhotoList " +
            "WHERE r.member = :member " +
            "ORDER BY r.createdAt DESC")
    Page<Review> findByMemberWithDetails(@Param("member") Member member, Pageable pageable);
}
