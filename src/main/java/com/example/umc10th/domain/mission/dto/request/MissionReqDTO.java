package com.example.umc10th.domain.mission.dto.request;

import com.example.umc10th.domain.mission.enums.MissionStatus;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class MissionReqDTO {
    @Getter
    @NoArgsConstructor
    public static class MissionStatusReqDTO {

        @NotNull(message = "status는 필수입니다.")
        private MissionStatus status;
    }

    @Getter
    @NoArgsConstructor
    public static class MyMissionReqDTO {
        @NotNull(message = "memberId는 필수입니다.")
        private Long memberId;
    }
}
