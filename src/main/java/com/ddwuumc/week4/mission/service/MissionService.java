package com.ddwuumc.week4.mission.service;

import com.ddwuumc.week4.mission.dto.MissionResponseDto;
import com.ddwuumc.week4.mission.entity.MissionStatus;
import com.ddwuumc.week4.mission.repository.MissionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@RequiredArgsConstructor
public class MissionService {

    private final MissionRepository missionRepository;

    public MissionResponseDto.MissionList getMissions(MissionStatus status, Integer page) {
        return new MissionResponseDto.MissionList(new ArrayList<>(), 0);
    }

    public Long successMission(Long id) {
        // 별도의 body를 받지 않고 MissionStatus를 SUCCESS로 변경

        return 100L; // 수정한 미션 번호
    }
}
