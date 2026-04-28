package com.example.umc10th.domain.member.dto;

import com.example.umc10th.domain.mission.entity.Mission;
import com.example.umc10th.domain.mission.entity.mapping.UserMission;
import lombok.Builder;

import java.time.LocalDate;
import java.util.List;

public class MemberResDTO {
    @Builder
    public record homeRes(
        String name,
        String region,
        List<UserMission> missions
    ){}

    @Builder
    public record signUpRes(
        Long memeberId,
        String name,
        LocalDate createAt
    ){}
}
