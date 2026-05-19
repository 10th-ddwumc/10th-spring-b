package com.example.umc10th.domain.member.service;

import com.example.umc10th.domain.member.converter.UserConverter;
import com.example.umc10th.domain.member.dto.UserReqDTO;
import com.example.umc10th.domain.member.dto.UserResDTO;
import com.example.umc10th.domain.member.entity.Food;
import com.example.umc10th.domain.member.entity.Term;
import com.example.umc10th.domain.member.entity.User;
import com.example.umc10th.domain.member.entity.mapping.UserFood;
import com.example.umc10th.domain.member.entity.mapping.UserTerm;
import com.example.umc10th.domain.member.exception.MemberException;
import com.example.umc10th.domain.member.exception.code.UserErrorCode;
import com.example.umc10th.domain.member.repositoty.FoodRepository;
import com.example.umc10th.domain.member.repositoty.TermRepository;
import com.example.umc10th.domain.member.repositoty.UserFoodRepository;
import com.example.umc10th.domain.member.repositoty.UserRepository;
import com.example.umc10th.domain.member.repositoty.UserTermRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final UserTermRepository userTermRepository;
    private final UserFoodRepository userFoodRepository;
    private final TermRepository termRepository;
    private final FoodRepository foodRepository;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    public UserResDTO.signUpRes signUp(UserReqDTO.signUpReq dto) {
        if (userRepository.existsByEmail(dto.email())) {
            throw new MemberException(UserErrorCode.USER_ALREADY_EXISTS);
        }

        User user = UserConverter.toUser(dto, passwordEncoder.encode(dto.password()));
        User savedUser = userRepository.save(user);

        List<Food> foods = dto.foods() == null ? List.of() : foodRepository.findAllByTypeIn(dto.foods());
        List<UserFood> userFoods = foods.stream()
                .map(food -> UserFood.builder()
                        .user(savedUser)
                        .food(food)
                        .build())
                .toList();
        userFoodRepository.saveAll(userFoods);

        List<Term> terms = dto.terms() == null ? List.of() : termRepository.findAllByNameIn(dto.terms());
        List<UserTerm> userTerms = terms.stream()
                .map(term -> UserTerm.builder()
                        .user(savedUser)
                        .term(term)
                        .build())
                .toList();
        userTermRepository.saveAll(userTerms);

        return UserConverter.toSignUpRes(savedUser);
    }

    public UserResDTO.PageResDTO<UserResDTO.homeRes> home(String region, Pageable pageable) {
        Page<UserResDTO.homeRes> page = new PageImpl<>(List.of(), pageable, 0);
        return UserConverter.toPageRes(page);
    }

    public UserResDTO.userRes user(Long userId) {
        return UserConverter.toUserRes();
    }
}
