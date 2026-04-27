package com.example.umc10th.domain.mission.dto;

import com.example.umc10th.domain.mission.enums.Status;
import com.example.umc10th.domain.mission.enums.StoreCategory;
import lombok.Builder;

import java.time.LocalDate;

public class MissionResDTO {

    // 미션 성공/실패 응답 DTO
    @Builder
    public record Success(
            Long id,
            Status status
    ) {}

    // 미션 조회 응답 DTO
    @Builder
    public record GetMissions(
            Long id,
            String title,
            String content,
            Integer point,
            Status status,
            LocalDate deadline,
            StoreCategory category
    ) {}

    @Builder
    public record HomeMission(
            Long id,
            String storeName,
            Integer price,
            Integer point,
            Status status,
            LocalDate deadline,
            StoreCategory category
    ) {}
}
