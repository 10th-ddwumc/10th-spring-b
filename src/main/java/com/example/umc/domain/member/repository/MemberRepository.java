package com.example.umc.domain.member.repository;

import com.example.umc.domain.member.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> {
    void deleteById(Long memberId);

    //로그인한 회원 찾는 용도
    Optional<Member> findByEmail(String email);

    // ㅈㅗㄴ재하는 이메일
    boolean existsByEmail(String email);

}
