package com.example.umcdongdong2.domain.mission.service;


import com.example.umcdongdong2.domain.mission.dto.MissionListReqDTO;
import com.example.umcdongdong2.domain.mission.dto.MissionListResDTO;
import com.example.umcdongdong2.domain.mission.dto.UserMissionsReqDTO;
import com.example.umcdongdong2.domain.mission.dto.UserMissionsResDTO;
import com.example.umcdongdong2.domain.mission.repository.MissionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MissionService {


    private final MissionRepository missionRepository;

    public UserMissionsResDTO.UserMissionsResponse getUserMissions(
            String authorization, UserMissionsReqDTO.UserMissionsRequest dto
    ){


        PageRequest pageRequest = PageRequest.of(dto.page().intValue(),
                                                dto.size().intValue(),
                                                Sort.by("id").descending());

        Page<UserMissionsResDTO.Mission> missionsPage = missionRepository.findMissionsByUserIdAndRestaurantId(
                dto.userId(), dto.restaurantId(), dto.filter(), pageRequest);





        // 오프셋 기반 페이지네이션
        return UserMissionsResDTO.UserMissionsResponse.builder()
                .missions(missionsPage.getContent())
                .page(missionsPage.getNumber())
                .size(missionsPage.getSize())
                .totalPages(missionsPage.getTotalPages())
                .totalElements(missionsPage.getTotalElements())
                .build();

    }

    public MissionListResDTO.MissionListResponse getMissionList(
            MissionListReqDTO.MissionListRequest dto
    ){
        Pageable pageable = PageRequest.of(dto.page().intValue(), dto.size().intValue());
        Page<MissionListResDTO.Mission> missionPage =
                missionRepository.findMissionListByRegionId(dto.regionId(), pageable);

        //
        return MissionListResDTO.MissionListResponse.builder()
                .missions(missionPage.getContent())
                .page(missionPage.getNumber())
                .size(missionPage.getSize())
                .totalElements(missionPage.getTotalElements())
                .totalPages(missionPage.getTotalPages())
                .hasNext(missionPage.hasNext())
                .build();
    }

}
