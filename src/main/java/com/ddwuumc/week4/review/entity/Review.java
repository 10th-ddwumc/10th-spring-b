package com.ddwuumc.week4.review.entity;

import com.ddwuumc.week4.global.common.BaseEntity;
import com.ddwuumc.week4.store.entity.Store;
import com.ddwuumc.week4.user.entity.User;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "review")
public class Review extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    @Column(nullable = false)
    private Integer rate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "store_id")
    private Store store;

    private Review(String content, Integer rate, User user, Store store) {
        this.content = content;
        this.rate = rate;
        this.user = user;
        this.store = store;
    }

    public static Review create(String content, Integer rate, User user, Store store) {
        return new Review(content, rate, user, store);
    }
}
