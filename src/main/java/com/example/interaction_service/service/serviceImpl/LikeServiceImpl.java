package com.example.interaction_service.service.serviceImpl;

import com.example.interaction_service.config.KafkaMessageSender;
import com.example.interaction_service.dto.LikeDto;
import com.example.interaction_service.entity.Like;
import com.example.interaction_service.mapper.LikeMapper;
import com.example.interaction_service.repository.LikeRepository;
import com.example.interaction_service.service.LikeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LikeServiceImpl implements LikeService {
    private final LikeRepository likeRepository;
    private final KafkaMessageSender kafkaMessageSender;

    @Override
    public LikeDto save(LikeDto likeDto) {
        Like like = LikeMapper.INSTANCE.toEntity(likeDto);
        if (likeRepository.findByUUIDAndUPID(like.getUUID(), like.getUPID()) != null) {
            deleteLike(like.getUUID(), like.getUPID());
            return null;
        }
        Like saved = likeRepository.save(like);
        kafkaMessageSender.sendMessage("notification-service", "{\"action\":\"like\",\"uuid\":\"" + likeDto.getPUUID() + "\"}");
        return LikeMapper.INSTANCE.toDto(saved);
    }

    @Override
    public LikeDto findLike(String userId, String postId) {
        Like like = likeRepository.findByUUIDAndUPID(userId, postId);
        return LikeMapper.INSTANCE.toDto(like);
    }

    @Override
    public void deleteLike(String userId, String postId) {
        likeRepository.delete(likeRepository.findByUUIDAndUPID(userId, postId));
    }

    @Override
    public Long countAllByPostId(String postId) {
        return (long) findAllByPostId(postId).size();
    }

    @Override
    public Long countAllByUserId(String userId) {
        return (long) findAllByUserId(userId).size();
    }

    @Override
    public List<LikeDto> findAll() {
        List<Like> likes = likeRepository.findAll();
        return LikeMapper.INSTANCE.toDtos(likes);
    }

    @Override
    public List<LikeDto> findAllByUserId(String userId) {
        List<Like> likes = likeRepository.findAllByUUID(userId);
        return LikeMapper.INSTANCE.toDtos(likes);
    }

    @Override
    public List<LikeDto> findAllByPostId(String postId) {
        List<Like> likes = likeRepository.findAllByUPID(postId);
        return LikeMapper.INSTANCE.toDtos(likes);
    }
}
