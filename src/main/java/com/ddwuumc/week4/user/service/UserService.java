package com.ddwuumc.week4.user.service;

import com.ddwuumc.week4.global.code.error.GeneralErrorCode;
import com.ddwuumc.week4.global.common.PageDto.Offset;
import com.ddwuumc.week4.global.exception.ProjectException;
import com.ddwuumc.week4.global.security.entity.AuthMember;
import com.ddwuumc.week4.global.security.service.CustomUserDetailsService;
import com.ddwuumc.week4.mission.dto.MissionResponseDto.MissionItem;
import com.ddwuumc.week4.mission.dto.UserMissionConverter;
import com.ddwuumc.week4.mission.entity.UserMission;
import com.ddwuumc.week4.mission.repository.UserMissionRepository;
import com.ddwuumc.week4.user.dto.UserConverter;
import com.ddwuumc.week4.user.dto.UserRequestDto.LoginUser;
import com.ddwuumc.week4.user.dto.UserRequestDto.SignupUser;
import com.ddwuumc.week4.user.dto.UserResponseDto;
import com.ddwuumc.week4.user.dto.UserResponseDto.LoginResponse;
import com.ddwuumc.week4.user.dto.UserResponseDto.MyPage;
import com.ddwuumc.week4.user.entity.User;
import com.ddwuumc.week4.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final UserMissionRepository userMissionRepository;
    private final PasswordEncoder passwordEncoder;
    private final CustomUserDetailsService customUserDetailsService;


    public Long signup(SignupUser signupUser) {
        User user = User.builder()
                .name(signupUser.name())
                .gender(signupUser.gender())
                .birth(LocalDate.parse(signupUser.birth()))
                .address(signupUser.address())
                .detailAddress(signupUser.detailAddress().orElse(""))
                .email(signupUser.email())
                .password(passwordEncoder.encode(signupUser.password()))
                .build();

        return userRepository.save(user).getId();
    }

    public Offset<MissionItem> getUserHome(Integer pageNumber, Integer pageSize) {
        User user = userRepository.findById(0L).orElseThrow(() -> new ProjectException(GeneralErrorCode.NOT_FOUND));
        Pageable pageable = PageRequest.of(pageNumber, pageSize);
        Page<UserMission> userMissionPage = userMissionRepository.findHomePage(0L, user.getDetailAddress(), pageable);

        List<MissionItem> missions = UserMissionConverter.convert(userMissionPage);

        return new Offset<>(
                missions,
                pageNumber,
                pageSize,
                userMissionPage.getTotalElements(),
                userMissionPage.getTotalPages());
    }

    public MyPage getUserMyPage(AuthMember authMember) {
        return UserConverter.convert(authMember.getUser());
    }

    public LoginResponse login(LoginUser user) {
        return customUserDetailsService.loginResponse(user);
    }
}
