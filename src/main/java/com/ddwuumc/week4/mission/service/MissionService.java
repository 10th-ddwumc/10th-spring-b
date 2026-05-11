package com.ddwuumc.week4.mission.service;

import com.ddwuumc.week4.global.common.PageDto.Offset;
import com.ddwuumc.week4.mission.dto.MissionRequestDto;
import com.ddwuumc.week4.mission.dto.MissionResponseDto.MissionItem;
import com.ddwuumc.week4.mission.dto.UserMissionConverter;
import com.ddwuumc.week4.mission.entity.MissionStatus;
import com.ddwuumc.week4.mission.entity.UserMission;
import com.ddwuumc.week4.mission.repository.MissionRepository;
import com.ddwuumc.week4.mission.repository.UserMissionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class MissionService {

    private final MissionRepository missionRepository;
    private final UserMissionRepository userMissionRepository;

    public Offset<MissionItem> getMissions(MissionStatus status, Integer pageNumber, Integer pageSize, MissionRequestDto.MissionRequest missionRequest) {
        Pageable pageable = PageRequest.of(pageNumber, pageSize);
        Page<UserMission> userMissionPage = userMissionRepository.findByMissionPage(missionRequest.userId(), status, pageable);

        List<MissionItem> missions = UserMissionConverter.convert(userMissionPage);

        return new Offset<>(
                missions,
                pageNumber,
                pageSize,
                userMissionPage.getTotalElements(),
                userMissionPage.getTotalPages());
    }

    public Long successMission(Long id) {
        // 별도의 body를 받지 않고 MissionStatus를 SUCCESS로 변경

        return 100L; // 수정한 미션 번호
    }
}
