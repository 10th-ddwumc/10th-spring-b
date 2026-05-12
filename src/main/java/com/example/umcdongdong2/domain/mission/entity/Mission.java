package com.example.umcdongdong2.domain.mission.entity;


import com.example.umcdongdong2.domain.mission.entity.mapping.UserMission;
import com.example.umcdongdong2.domain.review.entity.Region;
import com.example.umcdongdong2.domain.review.entity.Restaurant;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Mission {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "min_order_amount", nullable = false)
    private Integer minOrderAmount;

    @Column(nullable = false)
    private Integer reward;

    @OneToMany(mappedBy = "mission")
    private List<UserMission> userMissionList =  new ArrayList<>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_restaurant")
    private Restaurant restaurant;

    @Builder
    public Mission(Integer minOrderAmount, Integer reward, Restaurant restaurant) {
        this.minOrderAmount = minOrderAmount;
        this.reward = reward;
        this.restaurant = restaurant;
    }



}
