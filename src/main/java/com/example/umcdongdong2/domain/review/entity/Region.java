package com.example.umcdongdong2.domain.review.entity;

import com.example.umcdongdong2.domain.mission.entity.Mission;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Region {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @OneToMany(mappedBy = "region")
    private List<Restaurant> restaurantList = new ArrayList<>();

    @Builder
    public Region(String name) {
        this.name = name;
    }
}
