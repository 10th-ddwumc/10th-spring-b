package com.example.umcdongdong2.domain.mission.repository;

import com.example.umcdongdong2.domain.mission.dto.MissionListResDTO;
import com.example.umcdongdong2.domain.mission.dto.UserMissionsResDTO;
import com.example.umcdongdong2.domain.mission.entity.mapping.UserMission;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface MissionRepository extends JpaRepository<UserMission, Long> {

    //아래는 gpt가 짠 쿼리문입니다.. 페이징은 더 공부해 보겠습니다..
    @Query(
            value = """
                    select new com.example.umcdongdong2.domain.mission.dto.UserMissionsResDTO$Mission(
                        m.id,
                        m.minOrderAmount,
                        m.reward,
                        r.name
                    )
                    from UserMission um
                    join um.mission m
                    join m.restaurant r
                    where um.user.id = :userId
                    and (:restaurantId is null or r.id = :restaurantId)
                    and (
                        :filter is null
                        or (:filter = 'completed' and um.completed = true)
                        or (:filter = 'incomplete' and um.completed = false)
                    )
                    """,
            countQuery = """
                    select count(um)
                    from UserMission um
                    join um.mission m
                    join m.restaurant r
                    where um.user.id = :userId
                    and (:restaurantId is null or r.id = :restaurantId)
                    and (
                        :filter is null
                        or (:filter = 'completed' and um.completed = true)
                        or (:filter = 'incomplete' and um.completed = false)
                    )
                    """
    )
    Page<UserMissionsResDTO.Mission> findMissionsByUserIdAndRestaurantId(
            @Param("userId") Long userId,
            @Param("restaurantId") Long restaurantId,
            @Param("filter") String filter,
            Pageable pageable
    );

    @Query(
            value = """
                    select new com.example.umcdongdong2.domain.mission.dto.MissionListResDTO$Mission(
                        m.id,
                        m.minOrderAmount,
                        m.reward,
                        r.name
                    )
                    from Mission m
                    join m.restaurant r
                    join r.region rg
                    where (:regionId is null or rg.id = :regionId)
                    """,
            countQuery = """
                    select count(m)
                    from Mission m
                    join m.restaurant r
                    join r.region rg
                    where (:regionId is null or rg.id = :regionId)
                    """
    )
    Page<MissionListResDTO.Mission> findMissionListByRegionId(
            @Param("regionId") Long regionId,
            Pageable pageable
    );
}
