package com.example.umc10th.domain.member.entity;

import com.example.umc10th.domain.member.entity.mapping.UserTerm;
import com.example.umc10th.domain.member.enums.TermName;
import com.example.umc10th.global.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "term")
public class Term extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "term")
    private List<UserTerm> userTermList = new ArrayList<>();

    @Column(name = "name", nullable = false)
    @Enumerated(EnumType.STRING)
    @Builder.Default
    private TermName name = TermName.NONE;
}
