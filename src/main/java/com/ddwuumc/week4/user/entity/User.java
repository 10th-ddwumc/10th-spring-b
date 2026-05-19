package com.ddwuumc.week4.user.entity;

import com.ddwuumc.week4.global.common.BaseEntity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 30, nullable = false)
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private UserGender gender;

    @Column(nullable = false)
    private LocalDate birth;

    @Column(length = 100, nullable = false)
    private String address;

    @Column(length = 100)
    private String detailAddress;

    @Column(length = 50, nullable = false)
    private String email;

    @Column(length = 11)
    private String phone;

    @Column(length = 500)
    private String photo_url;

    @Column(length = 500)
    private String password;

    @Column(nullable = false)
    private Integer point;

    @Builder
    public User(String name, UserGender gender, LocalDate birth, String address, String detailAddress, String email, String password) {
        this.name = name;
        this.gender = gender;
        this.birth = birth;
        this.address = address;
        this.detailAddress = detailAddress;
        this.email = email;
        this.password = password;
        this.point = 0;
    }
}
