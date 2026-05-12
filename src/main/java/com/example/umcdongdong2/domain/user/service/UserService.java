package com.example.umcdongdong2.domain.user.service;

import com.example.umcdongdong2.domain.user.dto.UserMypageReqDTO;
import com.example.umcdongdong2.domain.user.dto.UserMypageResDTO;
import com.example.umcdongdong2.domain.user.entity.User;
import com.example.umcdongdong2.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public UserMypageResDTO.UserMypageResponse getMyPage(UserMypageReqDTO.UserMypageRequest dto){
        Long id = 10L; //placeholder
        User user =  userRepository.findById(id).get();


        return UserMypageResDTO.UserMypageResponse.builder()
                        .userId(user.getId())
                        .name(user.getName())
                        .email(user.getEmail())
                        .gender(user.getGender())
                        .birth(user.getBirth())
                        .address(user.getAddress())
                        .noticeMarketing(user.getNotice_marketing())
                        .noticeReplyReview(user.getNotice_reply_review())
                        .noticeReplyQna(user.getNotice_reply_qna())
                        .build();

    }
}
