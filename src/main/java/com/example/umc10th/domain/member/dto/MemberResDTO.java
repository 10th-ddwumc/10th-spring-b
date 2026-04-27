package com.example.umc10th.domain.member.dto;

import com.example.umc10th.domain.mission.dto.MissionResDTO;
import lombok.Builder;

import java.util.List;

public class MemberResDTO {
    // 회원 기본 정보 조회 응답 DTO
    @Builder
    public record GetInfo(
            String name,         // 회원 이름
            String profileUrl,   // 프로필 이미지 URL
            String email,        // 이메일
            String phoneNumber,  // 전화번호
            Integer point        // 보유 포인트
    ) {}

    // 회원가입 응답 DTO
    @Builder
    public record signUp(
            Long id  // 생성된 회원 ID
    ) {}

    // 홈 화면 정보 응답 DTO
    @Builder
    public record home(
            String location,                    // 현재 위치 (예: 지역명)
            Integer allMissionsCount,           // 전체 미션 수
            Integer successMissionsCount,       // 완료된 미션 수
            List<MissionResDTO.HomeMission> missions  // 홈에 표시할 미션 목록
    ) {}
}
