package com.ddwuumc.week4.review.repository;

import com.ddwuumc.week4.review.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review, Long> {
}
