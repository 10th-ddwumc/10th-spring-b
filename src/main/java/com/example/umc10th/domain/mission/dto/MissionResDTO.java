package com.example.umc10th.domain.mission.dto;

import com.example.umc10th.domain.mission.entity.mapping.UserMission;
import lombok.Builder;

import java.time.LocalDateTime;
import java.util.List;

public class MissionResDTO {
    @Builder
    public record missionRes (
        List<UserMission> missions
    ){};

    @Builder
    public record missionCompleteRes (
        Long missionId,
        String status,
        LocalDateTime completedAt
    ){};
}
