package com.ddwuumc.week4.user.dto;

import com.ddwuumc.week4.user.entity.UserGender;

import java.util.Optional;

public class UserRequestDto {
    public record SignupUser(
            String email,
            String password,
            String name,
            UserGender gender,
            String birth,
            String address,
            Optional<String> detailAddress,
            Integer[] food,
            Integer[] term
    ) {}
}
