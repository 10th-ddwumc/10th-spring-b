package com.example.umc10th.domain.mission.dto.request;

import com.example.umc10th.domain.mission.enums.MissionStatus;
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
}
