package com.ddwuumc.week4.user.service;

import com.ddwuumc.week4.user.dto.UserRequestDto;
import com.ddwuumc.week4.user.dto.UserResponseDto;
import com.ddwuumc.week4.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public Long signup(UserRequestDto.SignupUser user) {
        return 100L; // 생성된 사용자 id
    }

    public UserResponseDto.Home getUserHome() {
        return new UserResponseDto.Home(new ArrayList<>(), 0);
    }
}
