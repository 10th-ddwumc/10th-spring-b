package com.example.umcdongdong2.domain.mission.dto;

import lombok.Builder;

import java.util.List;

public class UserMissionsResDTO {

    @Builder
    public record Mission(
            Long missionId,
            Integer minOrderAmount,
            Integer reward,
            String restaurantName
    ) {}

    @Builder
    public record UserMissionsResponse(
            List<Mission> missions,
            Integer page,
            Integer size,
            Long totalElements,
            Integer totalPages,
            Boolean hasNext
    ) {}
}
