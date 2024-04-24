package com.example.interaction_service.service.serviceImpl;

import com.example.interaction_service.dto.CommentDto;
import com.example.interaction_service.entity.Comment;
import com.example.interaction_service.mapper.CommentMapper;
import com.example.interaction_service.repository.CommentRepository;
import com.example.interaction_service.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService {
    private final CommentRepository commentRepository;

    @Override
    public CommentDto save(CommentDto commentDto) {
        Comment toSave = CommentMapper.INSTANCE.toEntity(commentDto);
        Comment saved = commentRepository.save(toSave);
        return CommentMapper.INSTANCE.toDto(saved);
    }

    @Override
    public CommentDto findComment(String userId, String postId) {
        Comment comment = commentRepository.findByUUIDAndUPID(userId, postId);
        return CommentMapper.INSTANCE.toDto(comment);
    }

    @Override
    public void deleteComment(String userId, String postId) {
        commentRepository.delete(commentRepository.findByUUIDAndUPID(userId, postId));
    }

    @Override
    public Long countAllByPostId(String postId) {
        return commentRepository.countAllByUPID(postId);
    }

    @Override
    public Long countAllByUserId(String userId) {
        return commentRepository.countAllByUUID(userId);
    }

    @Override
    public List<CommentDto> findAllByUserId(String userId) {
        List<Comment> comments = commentRepository.findAllByUUID(userId);
        return CommentMapper.INSTANCE.toDtos(comments);
    }

    @Override
    public List<CommentDto> findAllByPostId(String postId) {
        List<Comment> comments = commentRepository.findAllByUPID(postId);
        return CommentMapper.INSTANCE.toDtos(comments);
    }

    @Override
    public List<CommentDto> findAll() {
        List<Comment> comments = commentRepository.findAll();
        return CommentMapper.INSTANCE.toDtos(comments);
    }
}
