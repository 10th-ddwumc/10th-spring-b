package com.ddwuumc.week4.user.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum UserGender {
    NONE("미설정"),
    MALE("남성"),
    FEMALE("여성");

    private final String label;
}
