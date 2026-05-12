package com.ddwuumc.week4.user.service;

import com.ddwuumc.week4.global.code.success.GeneralErrorCode;
import com.ddwuumc.week4.global.common.PageDto.Offset;
import com.ddwuumc.week4.global.exception.ProjectException;
import com.ddwuumc.week4.mission.dto.MissionResponseDto.MissionItem;
import com.ddwuumc.week4.mission.dto.UserMissionConverter;
import com.ddwuumc.week4.mission.entity.UserMission;
import com.ddwuumc.week4.mission.repository.UserMissionRepository;
import com.ddwuumc.week4.user.dto.UserRequestDto.SignupUser;
import com.ddwuumc.week4.user.dto.UserResponseDto.MyPage;
import com.ddwuumc.week4.user.entity.User;
import com.ddwuumc.week4.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final UserMissionRepository userMissionRepository;

    public Long signup(SignupUser user) {
        return 100L; // 생성된 사용자 id
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

    public MyPage getUserMyPage() {
        // TODO: user id는 하드코딩함
        User user = userRepository.findById(0L).orElseThrow(() -> new ProjectException(GeneralErrorCode.NOT_FOUND));
        return new MyPage(user.getName(), user.getEmail(), user.getPhone(), user.getPoint());
    }
}
