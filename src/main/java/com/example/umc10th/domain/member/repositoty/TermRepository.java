package com.example.umc10th.domain.member.repositoty;

import com.example.umc10th.domain.member.entity.Term;
import com.example.umc10th.domain.member.enums.TermName;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;
import java.util.List;

public interface TermRepository extends JpaRepository<Term, Long> {
    List<Term> findAllByNameIn(Collection<TermName> names);
}
