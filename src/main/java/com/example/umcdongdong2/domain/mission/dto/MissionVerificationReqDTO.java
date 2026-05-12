package com.example.umcdongdong2.domain.mission.dto;

import lombok.Builder;

public class MissionVerificationReqDTO {

    @Builder
    public record MissionVerificationRequest(
            String code
    ) {}
}
