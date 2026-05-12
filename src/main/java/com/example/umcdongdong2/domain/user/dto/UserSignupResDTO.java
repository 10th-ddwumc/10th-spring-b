package com.example.umcdongdong2.domain.user.dto;

import lombok.Builder;

public class UserSignupResDTO {

    @Builder
    public record UserSignupResponse(String userId){}

}
