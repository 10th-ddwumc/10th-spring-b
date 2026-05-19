package com.example.umc10th.domain.member.repositoty;

import com.example.umc10th.domain.member.entity.Food;
import com.example.umc10th.domain.member.enums.FoodType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;
import java.util.List;

public interface FoodRepository extends JpaRepository<Food, Long> {
    List<Food> findAllByTypeIn(Collection<FoodType> types);
}
