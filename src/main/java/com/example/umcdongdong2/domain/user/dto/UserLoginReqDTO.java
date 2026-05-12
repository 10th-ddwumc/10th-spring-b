package com.example.umcdongdong2.domain.user.dto;

import lombok.Builder;

public class UserLoginReqDTO {

    @Builder
    public record UserLoginRequest(
            String id,
            String pw
    ) {}
}
