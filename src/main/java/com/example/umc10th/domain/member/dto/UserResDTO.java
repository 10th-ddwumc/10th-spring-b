package com.example.umc10th.domain.member.dto;

import com.example.umc10th.domain.member.enums.FoodType;
import com.example.umc10th.domain.mission.entity.mapping.UserMission;
import lombok.Builder;

import java.time.LocalDate;
import java.util.List;

public class UserResDTO {
    @Builder
    public record homeRes(
        String name,
        String region,
        List<UserMission> missions,
        Integer isCompleted,
        Integer inProgress
    ){}

    public record UserMission(
            String storeName,
            FoodType type,
            Integer dday,
            String mission,
            Integer point
    ){}

    @Builder
    public record userRes(
            String name,
            String nickname,
            String email,
            String phone,
            Integer point
    ){}

    @Builder
    public record signUpRes(
        Long memberId,
        String name,
        LocalDate createAt
    ){}

    @Builder
    public record PageResDTO<T>(
            List<T> content,
            int page,
            int size,
            long totalElements,
            int totalPages,
            boolean isLast
    ) {
    }
}
