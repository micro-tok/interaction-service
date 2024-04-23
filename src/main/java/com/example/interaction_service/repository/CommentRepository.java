package com.example.interaction_service.repository;

import com.example.interaction_service.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {
    Comment save(Comment comment);
    Comment findByUUIDAndUPID(String UUID, String UPID);
    void deleteByUUIDAndUPID(String UUID, String UPID);
    Long countAllByUPID(String UPID);
    List<Comment> findAllByUPID(String UPID);
    List<Comment> findAll();
    List<Comment> findAllByUUID(String UUID);
}
