package com.example.umc10th.global.config;

import com.example.umc10th.domain.member.entity.Food;
import com.example.umc10th.domain.member.entity.Term;
import com.example.umc10th.domain.member.enums.FoodType;
import com.example.umc10th.domain.member.enums.TermName;
import com.example.umc10th.domain.member.repositoty.FoodRepository;
import com.example.umc10th.domain.member.repositoty.TermRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class DataInitializer implements ApplicationRunner {

    private final FoodRepository foodRepository;
    private final TermRepository termRepository;
    private final JdbcTemplate jdbcTemplate;

    @Override
    @Transactional
    public void run(ApplicationArguments args) {
        alignTermNameEnumColumn();
        migrateTypoTermName();
        removeTypoTermNameFromEnumColumn();
        initFoods();
        initTerms();
    }

    private void alignTermNameEnumColumn() {
        jdbcTemplate.execute("""
                alter table term
                modify column name enum('AGE','SERVEICE','SERVICE','PRIVACY','LOCATION','MARKETING','NONE') not null
                """);
    }

    private void migrateTypoTermName() {
        jdbcTemplate.update("update term set name = 'SERVICE' where name = 'SERVEICE'");
    }

    private void removeTypoTermNameFromEnumColumn() {
        jdbcTemplate.execute("""
                alter table term
                modify column name enum('AGE','SERVICE','PRIVACY','LOCATION','MARKETING','NONE') not null
                """);
    }


    private void initFoods() {
        Set<FoodType> existingTypes = foodRepository.findAll().stream()
                .map(Food::getType)
                .collect(Collectors.toSet());

        Arrays.stream(FoodType.values())
                .filter(type -> type != FoodType.NONE)
                .filter(type -> !existingTypes.contains(type))
                .map(type -> Food.builder().type(type).build())
                .forEach(foodRepository::save);
    }

    private void initTerms() {
        Set<TermName> existingNames = termRepository.findAll().stream()
                .map(Term::getName)
                .collect(Collectors.toSet());

        Arrays.stream(TermName.values())
                .filter(name -> name != TermName.NONE)
                .filter(name -> !existingNames.contains(name))
                .map(name -> Term.builder().name(name).build())
                .forEach(termRepository::save);
    }
}
