package com.example.umc10th.domain.member.dto;

import com.example.umc10th.domain.member.enums.FoodType;
import com.example.umc10th.domain.member.enums.Gender;
import com.example.umc10th.domain.member.enums.TermName;

import java.time.LocalDate;
import java.util.List;

public class UserReqDTO {

    public record signUpReq(
            String name,
            String nickname,
            String phone,
            Gender gender,
            LocalDate birth,
            String address,
            String email,
            String password,
            List<FoodType> foods,
            List<TermName> terms
    ){}

    public record loginReq(
            String email,
            String password
    ){}

    public record RequestBody(
            String stringTest,
            Long longTest
    ){}

}
