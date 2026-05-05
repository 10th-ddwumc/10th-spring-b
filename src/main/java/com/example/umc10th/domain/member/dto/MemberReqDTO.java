package com.example.umc10th.domain.member.dto;

import com.example.umc10th.domain.member.entity.Food;
import com.example.umc10th.domain.member.enums.Gender;
import com.example.umc10th.domain.member.enums.TermName;

import java.time.LocalDate;
import java.util.List;

public class MemberReqDTO {

    public record signUpReq(
            String name,
            Gender gender,
            LocalDate birthday,
            String address,
            List<Food> foods,
            List<TermName> terms
    ){}

    public record RequestBody(
            String stringTest,
            Long longTest
    ){}

}
