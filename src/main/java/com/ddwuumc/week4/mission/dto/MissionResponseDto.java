package com.ddwuumc.week4.mission.dto;

import com.ddwuumc.week4.mission.entity.MissionStatus;

public class MissionResponseDto {
    public record MissionItem(
            MissionStatus status,
            MissionInfo mission,
            StoreInfo store
    ) {}

    public record MissionInfo(
            Long id,
            Integer period,
            Integer price,
            Integer point
    ) {}

    public record StoreInfo(
            Long id,
            String name,
            String food
    ) {}
}
