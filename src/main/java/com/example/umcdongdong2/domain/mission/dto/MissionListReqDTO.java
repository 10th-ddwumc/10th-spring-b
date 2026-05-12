package com.example.umcdongdong2.domain.mission.dto;

import lombok.Builder;

public class MissionListReqDTO {
    @Builder
    public record MissionListRequest(
            Long regionId,
            Long page,
            Long size
    ) {}
}
