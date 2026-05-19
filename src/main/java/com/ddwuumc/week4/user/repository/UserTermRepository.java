package com.ddwuumc.week4.user.repository;

import com.ddwuumc.week4.user.entity.term.UserTerm;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserTermRepository extends JpaRepository<UserTerm, Long> {
}
