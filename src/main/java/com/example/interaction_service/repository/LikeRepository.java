package com.example.interaction_service.repository;

import com.example.interaction_service.entity.Like;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LikeRepository extends JpaRepository<Like, Long> {
    Like save(Like like);
    Like findByUserIdAndPostId(String userId, String postId);
    void deleteByUserIdAndPostId(String userId, String postId);
    List<Like> findAllByUserId(String userId);
    List<Like> findAllByPostId(String postId);
    Long countAllByPostId(String postId);
    Long countAllByUserId(String userId);
}
