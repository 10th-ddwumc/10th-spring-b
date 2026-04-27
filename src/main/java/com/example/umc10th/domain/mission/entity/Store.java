package com.example.umc10th.domain.mission.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;
import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;
import com.example.umc10th.domain.mission.enums.StoreCategory;
import com.example.umc10th.domain.review.entity.Review;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
@Entity
public class Store {

    // id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // 가게 이름
    @Column(nullable = false, length = 100)
    private String name;

    // 가게 주소
    @Column(nullable = false, length = 255)
    private String address;

    // 가게 카테고리
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private StoreCategory category;

    // 가게 설명
    @Column(length = 500)
    private String description;

    // 해당 가게의 미션 목록
    @OneToMany(mappedBy = "store", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Mission> missions = new ArrayList<>();

    // 해당 가게의 리뷰 목록
    @OneToMany(mappedBy = "store", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Review> reviews = new ArrayList<>();
}
