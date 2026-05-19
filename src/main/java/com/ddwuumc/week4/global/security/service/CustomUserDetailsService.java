package com.ddwuumc.week4.global.security.service;

import com.ddwuumc.week4.global.code.error.UserErrorCode;
import com.ddwuumc.week4.global.exception.ProjectException;
import com.ddwuumc.week4.global.security.entity.AuthMember;
import com.ddwuumc.week4.user.entity.User;
import com.ddwuumc.week4.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(username)
                .orElseThrow(() -> new ProjectException(UserErrorCode.USER_NOT_FOUND));
        return new AuthMember(user);
    }
}
