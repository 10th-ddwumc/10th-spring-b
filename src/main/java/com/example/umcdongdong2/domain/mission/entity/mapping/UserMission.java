package com.example.umcdongdong2.domain.mission.entity.mapping;

import com.example.umcdongdong2.domain.mission.entity.Mission;
import com.example.umcdongdong2.domain.user.entity.User;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class UserMission {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "mission_id")
    private Mission mission;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @Column(nullable = false)
    private boolean completed;


    @Builder
    public UserMission(Mission mission, User user, boolean completed) {
        this.mission = mission;
        this.user = user;
        this.completed = completed;

    }
}