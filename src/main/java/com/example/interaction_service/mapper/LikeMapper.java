package com.example.interaction_service.mapper;

import com.example.interaction_service.dto.LikeDto;
import com.example.interaction_service.entity.Like;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface LikeMapper {
    LikeMapper INSTANCE = Mappers.getMapper(LikeMapper.class);

    // LikeDto to Like
    @Mapping(target = "UPID", source = "UPID")
    @Mapping(target = "UUID", source = "UUID")
    Like toEntity(LikeDto likeDto);

    @Mapping(target = "UPID", source = "UPID")
    @Mapping(target = "UUID", source = "UUID")
    LikeDto toDto(Like like);

    List<Like> toEntities(List<LikeDto> likeDtos);
}
