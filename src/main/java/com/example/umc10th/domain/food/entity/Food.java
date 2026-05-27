package com.example.umc10th.domain.food.entity;

import com.example.umc10th.domain.food.enums.FoodName;
import com.example.umc10th.domain.member.entity.mapping.MemberFood;
import com.example.umc10th.global.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "food")
public class Food extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "name")
    @Enumerated(EnumType.STRING)
    private FoodName name;

    // 연관관계
    @OneToMany(mappedBy = "food")
    private List<MemberFood> memberFoodList = new ArrayList<>();
}
