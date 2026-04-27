package com.example.umc10th.domain.member.entity;


import com.example.umc10th.domain.member.entity.mapping.MemberFood;
import com.example.umc10th.domain.member.enums.Gender;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
@Entity
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;                // id

    private String name;            // 이름

    private String email;           // 이메일

    private String phoneNumber;     // 전화번호

    private Integer point;          // 보유 포인트

    private String profileUrl;      // 프로필 이미지

    private LocalDate birth;        // 생년월일

    private String address;         // 주소

    private Gender gender;          // 성별

    private List<MemberFood> foods; // 선호 음식

}

