package com.example.umc10th.domain.member.repositoty;

import com.example.umc10th.domain.member.entity.mapping.UserFood;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserFoodRepository extends JpaRepository<UserFood, Long> {
}
