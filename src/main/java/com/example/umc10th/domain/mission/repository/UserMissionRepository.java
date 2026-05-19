package com.example.umc10th.domain.mission.repository;

import com.example.umc10th.domain.mission.entity.mapping.UserMission;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserMissionRepository extends JpaRepository<UserMission, Long> {
    @EntityGraph(attributePaths = {"mission", "mission.store"})

    @Query(
            value = """
                SELECT um
                FROM UserMission um
                JOIN FETCH um.mission m
                JOIN FETCH m.store s
                WHERE um.user.id = :userId
                AND um.isComplete = :completed
                """
    )
    Page<UserMission> findAllByUserId(
            @Param("userId") Long userId,
            @Param("completed") Boolean completed,
            Pageable pageable
    );
}
