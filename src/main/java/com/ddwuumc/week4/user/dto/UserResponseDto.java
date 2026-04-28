package com.ddwuumc.week4.user.dto;

import com.ddwuumc.week4.mission.entity.MissionStatus;

import java.util.List;

public class UserResponseDto {
    public record Home(
            List<MissionItem> missions,
            long successCount
    ) {}

    public record MissionItem(
            MissionStatus status,
            MissionInfo mission,
            StoreInfo store
    ) {}

    public record MissionInfo(
            Long id,
            String period,
            Integer price,
            Integer point
    ) {}

    public record StoreInfo(
            String name,
            String address,
            String type
    ) {}
}
