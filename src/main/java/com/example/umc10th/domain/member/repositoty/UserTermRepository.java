package com.example.umc10th.domain.member.repositoty;

import com.example.umc10th.domain.member.entity.mapping.UserTerm;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserTermRepository extends JpaRepository<UserTerm, Long> {
}
