package com.ddwuumc.week4.user.entity;

import com.ddwuumc.week4.global.common.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class User extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    @Column(length = 30)
    private String name;

    @Enumerated(EnumType.STRING)
    private UserGender gender;

    private LocalDate birth;

    @Column(length = 100)
    private String address;

    @Column(length = 100)
    private String detailAddress;

    @Column(length = 50)
    private String email;

    @Column(length = 11)
    private String phone;

    @Column(length = 500)
    private String photo_url;

    @Builder.Default
    private Integer point = 0;
}
