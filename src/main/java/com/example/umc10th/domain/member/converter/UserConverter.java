package com.example.umc10th.domain.member.converter;

import com.example.umc10th.domain.member.dto.UserReqDTO;
import com.example.umc10th.domain.member.dto.UserResDTO;
import com.example.umc10th.domain.member.entity.User;
import com.example.umc10th.domain.member.enums.Gender;
import com.example.umc10th.domain.member.enums.SocialProvider;
import com.example.umc10th.domain.mission.dto.MissionResDTO;
import com.example.umc10th.domain.mission.entity.mapping.UserMission;
import org.springframework.data.domain.Page;

import java.time.LocalDate;
import java.util.List;


public class UserConverter {
    public static User toUser(UserReqDTO.signUpReq request, String encodedPassword) {
        return User.builder()
                .name(request.name())
                .nickname(request.nickname())
                .phone(request.phone())
                .gender(request.gender() == null ? Gender.NONE : request.gender())
                .birth(request.birth())
                .address(request.address())
                .email(request.email())
                .password(encodedPassword)
                .socialProvider(SocialProvider.NONE)
                .build();
    }

    public static UserResDTO.signUpRes toSignUpRes(User user) {
        LocalDate createdAt = user.getCreatedAt() == null ? LocalDate.now() : user.getCreatedAt().toLocalDate();
        return UserResDTO.signUpRes.builder()
                .memberId(user.getId())
                .name(user.getName())
                .createAt(createdAt)
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
