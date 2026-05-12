package com.example.umcdongdong2.domain.review.entity;


import com.example.umcdongdong2.domain.user.entity.User;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Getter
@NoArgsConstructor
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private Float star;

    @Column(nullable = false)
    private String content;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_restaurant")
    private Restaurant restaurant;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user", nullable = false)
    private User user;

    @OneToMany(mappedBy = "review")
    private List<Reply> replyList;

    @Builder
    public Review(Long id, Float star, String content, Restaurant restaurant, User user) {
        this.id = id;
        this.star = star;
        this.content = content;
        this.restaurant = restaurant;
        this.user = user;
    }
}
