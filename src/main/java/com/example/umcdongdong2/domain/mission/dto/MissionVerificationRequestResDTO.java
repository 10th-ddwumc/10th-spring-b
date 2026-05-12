package com.example.umcdongdong2.domain.mission.dto;

import lombok.Builder;

public class MissionVerificationRequestResDTO {

    @Builder
    public record MissionVerificationRequestResponse(
            Long missionId,
            String verificationCode
    ) {}
}
