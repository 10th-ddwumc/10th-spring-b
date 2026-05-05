package com.example.umc10th.domain.mission.entity;

import com.example.umc10th.domain.member.entity.User;
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
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "location")
public class Location extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "location")
    private List<Store> storeList = new ArrayList<>();

    @OneToMany(mappedBy = "location")
    private List<User> userList = new ArrayList<>();

    @Column(name = "name", nullable = false)
    private String name;
}
