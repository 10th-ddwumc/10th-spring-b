package com.example.umcdongdong2.domain.review.repository;


import com.example.umcdongdong2.domain.review.entity.Restaurant;
import com.example.umcdongdong2.domain.review.entity.Review;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review, Long> {


    Slice<Review> findAllByRestaurantIdAndIdLessThanOrderByIdDesc(Long restaurantId, long idCursor, PageRequest pageRequest);

    Slice<Review> findAllByRestaurantIdOrderByIdDesc(Long restaurantId, PageRequest pageRequest);

    Slice<Review> findAllByRestaurantIdAndStarLessThanOrderByStarDesc(Long restaurantId, float star, PageRequest pageRequest);

    Slice<Review> findAllByRestaurantIdOrderByStarDesc(Long restaurantId, PageRequest pageRequest);
}
