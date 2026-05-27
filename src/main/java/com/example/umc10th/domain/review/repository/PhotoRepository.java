package com.example.umc10th.domain.review.repository;

import com.example.umc10th.domain.review.entity.Photo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PhotoRepository extends JpaRepository<Photo, Long> {
}
