package com.example.umc10th.domain.member.converter;

import com.example.umc10th.domain.member.dto.UserReqDTO;
import com.example.umc10th.domain.member.dto.UserResDTO;
import com.example.umc10th.domain.member.entity.User;
import com.example.umc10th.domain.mission.dto.MissionResDTO;
import com.example.umc10th.domain.mission.entity.mapping.UserMission;
import org.springframework.data.domain.Page;

import java.util.List;


public class UserConverter {
    public static UserResDTO.signUpRes toSignUpRes(UserReqDTO.signUpReq request) {
        return UserResDTO.signUpRes.builder()
                .memberId(12345L)
                .name(request.name())
                .build();
    }
    public static UserResDTO.homeRes toHomeRes(String name, String region, List<UserResDTO.UserMission> missions){
        return UserResDTO.homeRes.builder()
                .name(name)
                .region(region)
                .missions(missions)
                .build();
    }
    public static UserResDTO.userRes toUserRes(){
        return UserResDTO.userRes.builder()
                .name("홍길동")
                .nickname("길동이")
                .email("1234@gmail.com")
                .phone("010-1234-5678")
                .point(2000)
                .build();

    }

    public static <T> UserResDTO.PageResDTO<T> toPageRes(Page<T> page) {
        return UserResDTO.PageResDTO.<T>builder()
                .content(page.getContent())
                .page(page.getNumber())
                .size(page.getSize())
                .totalElements(page.getTotalElements())
                .totalPages(page.getTotalPages())
                .isLast(page.isLast())
                .build();
    }
}
