package com.example.umc10th.domain.mission.dto;

import com.example.umc10th.domain.member.enums.FoodType;

import lombok.Builder;

import java.time.LocalDateTime;
import java.util.List;

public class MissionResDTO {
    @Builder
    public record missionRes(
            List<Mission> missions
    ) {
    }

    public record Mission(
            String storeName,
            FoodType type,
            Integer dday,
            String mission,
            Integer point,
            Boolean completed
    ) {
    }

    @Builder
    public record missionCompleteRes(
            Long missionId,
            String status,
            LocalDateTime completedAt
    ) {
    }



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
