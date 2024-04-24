package com.example.interaction_service.service;

import com.example.interaction_service.dto.CommentDto;

import java.util.List;

public interface CommentService {
    CommentDto save(CommentDto commentDto);
    CommentDto findComment(String userId, String postId);
    void deleteComment(String userId, String postId);
    Long countAllByPostId(String postId);
    Long countAllByUserId(String userId);
    List<CommentDto> findAllByUserId(String userId);
    List<CommentDto> findAllByPostId(String postId);
    List<CommentDto> findAll();
}
