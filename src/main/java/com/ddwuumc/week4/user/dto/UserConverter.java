package com.ddwuumc.week4.user.dto;

import com.ddwuumc.week4.user.dto.UserResponseDto.MyPage;
import com.ddwuumc.week4.user.entity.User;

public class UserConverter {
    public static MyPage convert(User user) {
        return new MyPage(user.getName(), user.getEmail(), user.getPhone(), user.getPoint());
    }
}
