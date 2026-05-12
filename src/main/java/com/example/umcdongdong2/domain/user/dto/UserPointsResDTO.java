package com.example.umcdongdong2.domain.user.dto;

import lombok.Builder;

public class UserPointsResDTO {

    @Builder
    public record UserPointsResponse(
            Integer points
    ) {}
}
