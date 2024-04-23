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
        System.out.println(like.getUUID());
        System.out.println(like.getUPID());
        if(likeRepository.findByUserIdAndPostId(like.getUUID(), like.getUPID()) != null) {
            deleteLike(like.getUUID(), like.getUPID());
            return null;
        }
        Like saved = likeRepository.save(like);
        System.out.println(saved.getUUID());
        System.out.println(saved.getUPID());
        return LikeMapper.INSTANCE.toDto(saved);
    }

    @Override
    public LikeDto findLike(String userId, String postId) {
        Like like = likeRepository.findByUserIdAndPostId(userId, postId);
        return LikeMapper.INSTANCE.toDto(like);
    }

    @Override
    public void deleteLike(String userId, String postId) {
        likeRepository.deleteByUserIdAndPostId(userId, postId);
    }

    @Override
    public Long countAllByPostId(String postId) {
        return likeRepository.countAllByPostId(postId);
    }

    @Override
    public Long countAllByUserId(String userId) {
        return likeRepository.countAllByUserId(userId);
    }

    @Override
    public List<LikeDto> findAll() {
        List<Like> likes = likeRepository.findAll();
        return likes.stream().map(LikeMapper.INSTANCE::toDto).collect(Collectors.toList());
    }

    @Override
    public List<LikeDto> findAllByUserId(String userId) {
        List<Like> likes = likeRepository.findAllByUserId(userId);
        return likes.stream().map(LikeMapper.INSTANCE::toDto).collect(Collectors.toList());
    }
}
