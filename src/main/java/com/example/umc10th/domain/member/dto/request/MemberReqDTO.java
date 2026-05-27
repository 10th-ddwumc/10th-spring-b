package com.example.umc10th.domain.member.dto.request;

import com.example.umc10th.domain.member.enums.Address;
import com.example.umc10th.domain.member.enums.Gender;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

public class MemberReqDTO {
    @Getter
    @NoArgsConstructor
    public static class SignUpReqDTO{
        @NotBlank(message = "이메일은 필수입니다.")
        @Email(message = "이메일 형식이 올바르지 않습니다.")
        private String email;

        @NotBlank(message = "비밀번호는 필수입니다.")
        private String password;

        @NotBlank(message = "이름은 필수입니다.")
        private String name;

        @NotNull(message = "성별은 필수입니다.")
        private Gender gender;

        @NotNull(message = "생년월일은 필수입니다.")
        private LocalDate birthDate;

        @NotBlank(message = "주소는 필수입니다.")
        private Address address;

        @NotNull(message = "14세 이상 동의는 필수입니다.")
        private Boolean agreeAge;

        @NotNull(message = "서비스 이용 약관 동의는 필수입니다.")
        private Boolean agreeTerms;

        @NotNull(message = "개인정보 처리 방침 동의는 필수입니다.")
        private Boolean agreePrivacy;

        private Boolean agreeLocation;

        private Boolean agreeMarketing;

        @NotNull(message = "선호 음식은 필수입니다.")
        private List<String> favoriteFoods;
    }

    @Getter
    @NoArgsConstructor
    public static class MemberIdReqDTO {
        @NotNull(message = "memberId는 필수입니다.")
        private Long memberId;
    }

    @Getter
    @NoArgsConstructor
    public static class LoginReqDTO {
        @NotBlank(message = "이메일은 필수입니다.")
        @Email(message = "이메일 형식이 올바르지 않습니다.")
        private String email;

        @NotBlank(message = "비밀번호는 필수입니다.")
        private String password;
    }
}
