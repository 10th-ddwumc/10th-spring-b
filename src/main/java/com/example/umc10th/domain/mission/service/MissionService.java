package com.example.umc10th.domain.mission.service;

import com.example.umc10th.domain.mission.dto.request.MissionReqDTO;
import com.example.umc10th.domain.mission.dto.response.MissionResDTO;
import com.example.umc10th.domain.mission.enums.MissionStatus;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;

@Service
public class MissionService {
    public Object updateMissionStatus(Long missionId, MissionReqDTO.@Valid MissionStatusReqDTO request) {
    }

    public MissionResDTO getMission(String region, MissionStatus status, int page, int size) {
    }
}
