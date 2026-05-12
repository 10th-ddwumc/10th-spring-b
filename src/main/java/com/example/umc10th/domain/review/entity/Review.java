package com.example.umc10th.domain.review.entity;

import com.example.umc10th.domain.member.entity.User;
import com.example.umc10th.domain.mission.entity.Store;
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
@Table(name = "review")
public class Review extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // 리뷰가 삭제 시 리뷰 답글도 함께 삭제
    @OneToMany(mappedBy = "review", cascade = CascadeType.REMOVE)
    private List<Comment> commentList = new ArrayList<>();

    // 리뷰 삭제 시 리뷰 사진도 함께 삭제
    @OneToMany(mappedBy = "review", cascade = CascadeType.REMOVE)
    private List<Photo> photoList = new ArrayList<>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "store_id")
    private Store store;

    @Column(name = "rating", nullable = false)
    private Double rating;

    @Column(name = "content", nullable = false)
    private String content;
}
