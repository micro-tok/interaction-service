package com.example.interaction_service.service.serviceImpl;

import com.example.interaction_service.dto.LikeDto;
import com.example.interaction_service.entity.Like;
import com.example.interaction_service.mapper.LikeMapper;
import com.example.interaction_service.repository.LikeRepository;
import com.example.interaction_service.service.LikeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class LikeServiceImpl implements LikeService {
    private final LikeRepository likeRepository;

    @Override
    public LikeDto save(LikeDto likeDto) {
        Like like = LikeMapper.INSTANCE.toEntity(likeDto);
        if(likeRepository.findByUUIDAndUPID(like.getUUID(), like.getUPID()) != null) {
            deleteLike(like.getUUID(), like.getUPID());
            return null;
        }
        Like saved = likeRepository.save(like);
        return LikeMapper.INSTANCE.toDto(saved);
    }

    @Override
    public LikeDto findLike(String userId, String postId) {
        Like like = likeRepository.findByUUIDAndUPID(userId, postId);
        return LikeMapper.INSTANCE.toDto(like);
    }

    @Override
    public void deleteLike(String userId, String postId) {
        likeRepository.deleteByUUIDAndUPID(userId, postId);
    }

    @Override
    public Long countAllByPostId(String postId) {
        return likeRepository.countAllByUPID(postId);
    }

    @Override
    public Long countAllByUserId(String userId) {
        return likeRepository.countAllByUUID(userId);
    }

    @Override
    public List<LikeDto> findAll() {
        List<Like> likes = likeRepository.findAll();
        return likes.stream().map(LikeMapper.INSTANCE::toDto).collect(Collectors.toList());
    }

    @Override
    public List<LikeDto> findAllByUserId(String userId) {
        List<Like> likes = likeRepository.findAllByUUID(userId);
        return likes.stream().map(LikeMapper.INSTANCE::toDto).collect(Collectors.toList());
    }
}
