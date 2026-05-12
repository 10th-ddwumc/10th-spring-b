package com.example.umcdongdong2.domain.user.dto;

import lombok.Builder;

public class UserSignupReqDTO {

    @Builder
    public record UserSignupRequest(
            String name,
            Integer gender,
            String birth,
            String address,
            String userId,
            String userpw
    ){}
}
