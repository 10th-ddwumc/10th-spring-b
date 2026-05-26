package com.ddwuumc.week4.user.dto;

public class UserResponseDto {
    public record LoginResponse (
        String accessToken
    ) {}
    public record MyPage(
            String name,
            String email,
            String phone,
            Integer point
    ) {}
}
