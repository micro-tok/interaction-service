package com.example.interaction_service.repository;

import com.example.interaction_service.entity.Like;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LikeRepository extends JpaRepository<Like, Long> {
    Like save(Like like);
    Like findByUUIDAndUPID(String UUID, String UPID);
    void deleteByUUIDAndUPID(String UUID, String UPID);
    List<Like> findAllByUUID(String UUID);
    List<Like> findAllByUPID(String UPID);
    Long countAllByUPID(String UPID);
    Long countAllByUUID(String UPID);
}
