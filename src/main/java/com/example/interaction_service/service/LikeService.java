package com.example.interaction_service.service;

import com.example.interaction_service.dto.LikeDto;
import com.example.interaction_service.entity.Like;

import java.util.List;

public interface LikeService {
    LikeDto save(LikeDto likeDto);
    LikeDto findLike(String userId, String postId);
    void deleteLike(String userId, String postId);
    Long countAllByPostId(String postId);
    Long countAllByUserId(String userId);
    List<LikeDto> findAllByUserId(String userId);
    List<LikeDto> findAll();
}
