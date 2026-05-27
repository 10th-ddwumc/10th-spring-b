package com.example.umc10th.domain.mission.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.Page;

import java.time.LocalDateTime;

public class MissionResDTO {
        @Builder
        @Getter
        @NoArgsConstructor
        @AllArgsConstructor
        public static class MissionListResDTO {
            private Page<MissionDTO> missions;
        }

        @Builder
        @Getter
        @NoArgsConstructor
        @AllArgsConstructor
        public static class MissionDTO {
            private Long memberMissionId;
            private String status;
            private String missionName;
            private String storeName;
            private String storeType;
            private int point;
            private int daysLeft;
            private LocalDateTime endAt;
        }
}
