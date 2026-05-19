package com.ddwuumc.week4.user.repository;

import com.ddwuumc.week4.user.entity.food.UserFood;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserFoodRepository extends JpaRepository<UserFood, Long> {
}
