package com.example.interaction_service.repository;

import com.example.interaction_service.entity.Like;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LikeRepository extends JpaRepository<Like, Long> {
    Like save(Like like);
    Like findByUUIDAndUPID(String userId, String postId);
    void deleteByUUIDAndUPID(String userId, String postId);
    List<Like> findAllByUUID(String userId);
    List<Like> findAllByUPID(String postId);
    Long countAllByUPID(String postId);
    Long countAllByUUID(String userId);
}
