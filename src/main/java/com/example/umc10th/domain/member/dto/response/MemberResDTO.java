package com.example.umc10th.domain.member.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.Page;

import java.time.LocalDateTime;

public class MemberResDTO {

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class HomeResDTO {
        private String region;
        private int totalPoint;

        private int completedMission;
        private int goalMission;

        private int regionTotalMission;
        private int regionCompletedMission;

        private Page<MissionDTO> missions;
    }

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class MissionDTO {
        private Long missionId;
        private String missionName;
        private String storeName;
        private String storeType;
        private int point;
        private int daysLeft;
        private LocalDateTime endAt;
    }

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class MyPageResDTO {
        private String nickname;
        private String profileImageUrl;
        private String email;
        private String phoneNumber;
        private boolean phoneVerified;
        private Integer point;
    }

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class SignUpResDTO {
        private Long memberId;
        private String email;
        private String name;
        private LocalDateTime createdAt;
    }

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class LoginResDTO {
        private Long memberId;
        private String email;
        private String accessToken;
    }
}
