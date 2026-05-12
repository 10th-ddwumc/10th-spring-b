package com.example.umcdongdong2.domain.user.entity;

import com.example.umcdongdong2.domain.mission.entity.mapping.UserMission;
import com.example.umcdongdong2.domain.review.entity.Review;
import com.example.umcdongdong2.domain.user.entity.mapping.FoodTaste;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private int gender;

    @Column(nullable = false)
    private String birth;

    @Column(nullable = false)
    private String address;

    @Column(nullable = false)
    private LocalDateTime created_at;

    @Column(nullable = false)
    private LocalDateTime updated_at;

    @Column(nullable = true)
    private LocalDateTime deleted_at;

    @Column(nullable = false)
    private Boolean notice_marketing;

    @Column(nullable = false)
    private Boolean notice_reply_review;

    @Column(nullable = false)
    private Boolean notice_reply_qna;

    @OneToMany(mappedBy = "user")
    private List<Review> reviewList = new ArrayList<>();

    @OneToMany(mappedBy = "user")
    private List<FoodTaste> foodTasteList = new ArrayList<>();

    @OneToMany(mappedBy = "user")
    private List<UserMission> userMissionList = new ArrayList<>();

}
