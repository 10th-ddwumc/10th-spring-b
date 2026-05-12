package com.example.umcdongdong2.domain.mission.dto;

import lombok.Builder;

import java.util.List;

public class MissionListResDTO {

    @Builder
    public record Mission(
            Long missionId,
            Integer minOrderAmount,
            Integer reward,
            String restaurantName
    ) {}

    @Builder
    public record MissionListResponse(
            List<Mission> missions,
            Integer page,
            Integer size,
            Long totalElements,
            Integer totalPages,
            Boolean hasNext
    ) {}
}
