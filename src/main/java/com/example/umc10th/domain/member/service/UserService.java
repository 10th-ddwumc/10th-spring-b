package com.example.umc10th.domain.member.service;

import com.example.umc10th.domain.member.converter.UserConverter;
import com.example.umc10th.domain.member.dto.UserReqDTO;
import com.example.umc10th.domain.member.dto.UserResDTO;
import com.example.umc10th.domain.member.entity.Food;
import com.example.umc10th.domain.member.entity.Term;
import com.example.umc10th.domain.member.entity.User;
import com.example.umc10th.domain.member.entity.mapping.UserFood;
import com.example.umc10th.domain.member.entity.mapping.UserTerm;
import com.example.umc10th.domain.member.enums.FoodType;
import com.example.umc10th.domain.member.enums.TermName;
import com.example.umc10th.domain.member.exception.MemberException;
import com.example.umc10th.domain.member.exception.code.UserErrorCode;
import com.example.umc10th.domain.member.repositoty.FoodRepository;
import com.example.umc10th.domain.member.repositoty.TermRepository;
import com.example.umc10th.domain.member.repositoty.UserFoodRepository;
import com.example.umc10th.domain.member.repositoty.UserRepository;
import com.example.umc10th.domain.member.repositoty.UserTermRepository;
import com.example.umc10th.global.security.entity.AuthMember;
import com.example.umc10th.global.security.util.JwtUtil;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.EnumSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final UserTermRepository userTermRepository;
    private final UserFoodRepository userFoodRepository;
    private final TermRepository termRepository;
    private final FoodRepository foodRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;

    private static final Set<TermName> REQUIRED_TERMS = EnumSet.of(
            TermName.AGE,
            TermName.SERVICE,
            TermName.PRIVACY,
            TermName.LOCATION,
            TermName.MARKETING
    );

    @Transactional
    public UserResDTO.signUpRes signUp(UserReqDTO.signUpReq dto) {
        if (userRepository.existsByEmail(dto.email())) {
            throw new MemberException(UserErrorCode.USER_ALREADY_EXISTS);
        }
        validateRequiredTerms(dto.terms());

        User user = UserConverter.toUser(dto, passwordEncoder.encode(dto.password()));
        User savedUser = userRepository.save(user);

        List<Food> foods = findFoods(dto.foods());
        List<UserFood> userFoods = foods.stream()
                .map(food -> UserFood.builder()
                        .user(savedUser)
                        .food(food)
                        .build())
                .toList();
        userFoodRepository.saveAll(userFoods);

        List<Term> terms = findTerms(dto.terms());
        List<UserTerm> userTerms = terms.stream()
                .map(term -> UserTerm.builder()
                        .user(savedUser)
                        .term(term)
                        .build())
                .toList();
        userTermRepository.saveAll(userTerms);

        return UserConverter.toSignUpRes(savedUser);
    }

    @Transactional
    public UserResDTO.loginRes login(UserReqDTO.loginReq dto) {
        User user = userRepository.findByEmail(dto.email())
                .orElseThrow(() -> new MemberException(UserErrorCode.INVALID_LOGIN_INFO));

        if (!passwordEncoder.matches(dto.password(), user.getPassword())) {
            throw new MemberException(UserErrorCode.INVALID_LOGIN_INFO);
        }

        String accessToken = jwtUtil.createAccessToken(new AuthMember(user));
        return UserConverter.toLoginRes(user, accessToken);
    }

    public UserResDTO.PageResDTO<UserResDTO.homeRes> home(String region, Pageable pageable) {
        Page<UserResDTO.homeRes> page = new PageImpl<>(List.of(), pageable, 0);
        return UserConverter.toPageRes(page);
    }

    public UserResDTO.userRes user(AuthMember member) {

        return UserConverter.user(member.getUser());
    }

    private void validateRequiredTerms(List<TermName> terms) {
        Set<TermName> agreedTerms = terms == null
                ? EnumSet.noneOf(TermName.class)
                : terms.stream()
                .filter(term -> term != null && term != TermName.NONE)
                .collect(Collectors.toCollection(() -> EnumSet.noneOf(TermName.class)));

        if (!agreedTerms.containsAll(REQUIRED_TERMS)) {
            throw new MemberException(UserErrorCode.REQUIRED_TERMS_NOT_AGREED);
        }
    }

    private List<Term> findTerms(List<TermName> names) {
        if (names == null || names.isEmpty()) {
            return List.of();
        }

        List<TermName> filteredNames = names.stream()
                .filter(name -> name != null && name != TermName.NONE)
                .distinct()
                .toList();
        Map<TermName, Term> termsByName = termRepository.findAllByNameIn(filteredNames).stream()
                .collect(Collectors.toMap(Term::getName, Function.identity(), (first, second) -> first));

        return filteredNames.stream()
                .map(termsByName::get)
                .filter(term -> term != null)
                .toList();
    }

    private List<Food> findFoods(List<FoodType> types) {
        if (types == null || types.isEmpty()) {
            return List.of();
        }

        List<FoodType> filteredTypes = types.stream()
                .filter(type -> type != null && type != FoodType.NONE)
                .distinct()
                .toList();
        Map<FoodType, Food> foodsByType = foodRepository.findAllByTypeIn(filteredTypes).stream()
                .collect(Collectors.toMap(Food::getType, Function.identity(), (first, second) -> first));

        return filteredTypes.stream()
                .map(foodsByType::get)
                .filter(food -> food != null)
                .toList();
    }
}
