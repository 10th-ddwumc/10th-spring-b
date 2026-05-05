package com.example.umc10th.domain.member.service;

import com.example.umc10th.domain.member.converter.UserConverter;
import com.example.umc10th.domain.member.dto.UserReqDTO;
import com.example.umc10th.domain.member.dto.UserResDTO;
import com.example.umc10th.domain.mission.dto.MissionResDTO;
import com.example.umc10th.domain.mission.entity.mapping.UserMission;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    public UserResDTO.signUpRes signUp(
            UserReqDTO.signUpReq dto
    ) {
        return UserConverter.toSignUpRes(dto);
    }

    public UserResDTO.PageResDTO<UserResDTO.homeRes> home(String region, Pageable pageable) {
        Page<UserResDTO.homeRes> page = new PageImpl<>(List.of(), pageable, 0);
        return UserConverter.toPageRes(page);
    }

    public UserResDTO.userRes user(Long userId) {
        return UserConverter.toUserRes();
    }
}
