package com.example.umcdongdong2.domain.mission.dto;

import lombok.Builder;

public class UserMissionsReqDTO {

    @Builder
    public record UserMissionsRequest(
            Long userId,
            Long restaurantId,
            String filter,
            Long page,
            Long size
    ) {}
}
