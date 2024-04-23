package com.example.interaction_service.mapper;

import com.example.interaction_service.dto.CommentDto;
import com.example.interaction_service.entity.Comment;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface CommentMapper {
    CommentMapper INSTANCE = Mappers.getMapper(CommentMapper.class);

    Comment toEntity(CommentDto commentDto);

    CommentDto toDto(Comment comment);

    List<Comment> toEntities(List<CommentDto> commentDtos);

    List<CommentDto> toDtos(List<Comment> comments);
}
