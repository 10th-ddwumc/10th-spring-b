package com.example.umc10th.domain.home.service;

import com.example.umc10th.domain.member.repository.MemberMissionRepository;
import com.example.umc10th.domain.mission.dto.response.MissionResDTO;
import com.example.umc10th.domain.mission.entity.Mission;
import com.example.umc10th.domain.mission.repository.MissionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class HomeService {

    private final MissionRepository missionRepository;
    private final MemberMissionRepository memberMissionRepository;

    /**
     * 홈 화면 - 현재 선택된 지역에서 도전 가능한 미션 목록
     */
    public MissionResDTO.MissionListResDTO getAvailableMissions(String address, Pageable pageable) {
        Page<Mission> missions = missionRepository.findByStoreAddress(address, pageable);

        Page<MissionResDTO.MissionDTO> missionDTOs = missions.map(mission -> {
            long daysLeft = mission.getEndAt() != null
                    ? ChronoUnit.DAYS.between(LocalDateTime.now(), mission.getEndAt())
                    : 0;

            return MissionResDTO.MissionDTO.builder()
                    .memberMissionId(null)
                    .status(null)
                    .missionName(mission.getMissionName())
                    .storeName(mission.getStore().getStoreName())
                    .storeType(mission.getStore().getStoreType())
                    .point(mission.getPoint())
                    .daysLeft((int) daysLeft)
                    .endAt(mission.getEndAt())
                    .build();
        });

        return MissionResDTO.MissionListResDTO.builder()
                .missions(missionDTOs)
                .build();
    }

    /**
     * 홈 화면 - 내 미션 달성 현황
     */
    public long getCompletedMissionCount(Long memberId) {
        return memberMissionRepository.countByMemberIdAndStatus(memberId, "COMPLETED");
    }
}