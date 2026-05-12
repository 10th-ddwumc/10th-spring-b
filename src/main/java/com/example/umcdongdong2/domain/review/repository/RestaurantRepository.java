package com.example.umcdongdong2.domain.review.repository;

import com.example.umcdongdong2.domain.review.entity.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {

}
