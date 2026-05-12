package com.example.umc10th.domain.mission.service;

import com.example.umc10th.domain.mission.converter.MissionConverter;
import com.example.umc10th.domain.mission.dto.MissionResDTO;
import com.example.umc10th.domain.mission.repository.UserMissionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MissionService {

    private final UserMissionRepository userMissionRepository;

    public MissionResDTO.Pagination<MissionResDTO.Mission> getMissions(
            Long userId,
            Integer pageSize,
            Integer pageNumber,
            String sort,
            Boolean completed
    ) {

        PageRequest pageRequest = PageRequest.of(
                pageNumber, pageSize, resolveSort(sort)
        );
        Page<MissionResDTO.Mission> missionList = userMissionRepository.findAllByUserId(userId, completed, pageRequest)
                .map(MissionConverter::toMission);

        return MissionConverter.toPagination(
                missionList.getContent(),
                missionList.getNumber(),
                missionList.getSize()
        );
    }

    private Sort resolveSort(String sort) {
        if (sort == null || sort.isBlank()) {
            return Sort.by(Sort.Direction.DESC, "mission.createdAt");
        }

        String[] tokens = sort.split(",");
        String property = switch (tokens[0].trim()) {
            case "dday" -> "mission.dday";
            case "point" -> "mission.point";
            case "mission", "name" -> "mission.name";
            case "store", "storeName" -> "mission.store.name";
            case "completed" -> "isComplete";
            default -> "mission.createdAt";
        };
        Sort.Direction direction = tokens.length > 1 && tokens[1].trim().equalsIgnoreCase("asc")
                ? Sort.Direction.ASC
                : Sort.Direction.DESC;

        return Sort.by(direction, property);
    }

    public MissionResDTO.missionCompleteRes completeMission(Long missionId){
        return MissionConverter.toMissionCompleteRes(missionId);
    }
}
