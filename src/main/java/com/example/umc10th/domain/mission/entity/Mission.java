package com.example.umc10th.domain.mission.entity;

import com.example.umc10th.domain.member.entity.mapping.MemberMission;
import com.example.umc10th.domain.store.entity.Store;
import com.example.umc10th.global.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "mission")
public class Mission extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "mission_id")
    private Long id;

    @Column(name = "mission_name", columnDefinition = "TEXT")
    private String missionName;

    @Column(name = "point", nullable = false)
    private Integer point;

    @Column(name = "end_at")
    private LocalDateTime endAt;

    // 연관관계
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "store_id")
    private Store store;

    @OneToMany(mappedBy = "mission")
    private List<MemberMission> memberMissionList = new ArrayList<>();
}
