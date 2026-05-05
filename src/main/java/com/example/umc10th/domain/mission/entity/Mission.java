package com.example.umc10th.domain.mission.entity;

import com.example.umc10th.domain.mission.entity.mapping.UserMission;
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
@Table(name = "mission")
public class Mission extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // 미션 삭제 시 사용자 미션에서도 삭제 되어야 함
    @OneToMany(mappedBy = "mission", cascade = CascadeType.REMOVE)
    private List<UserMission> userMissionList = new ArrayList<>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "store_id")
    private Store store;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "point", nullable = false)
    private Integer point;

    @Column(name = "dday", nullable = false)
    private Integer dday;


}
