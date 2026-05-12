package com.example.umcdongdong2.domain.mission.dto;

import lombok.Builder;

public class MissionVerificationResDTO {

    @Builder
    public record MissionVerificationResponse(
            Long missionId,
            Boolean verified
    ) {}
}
