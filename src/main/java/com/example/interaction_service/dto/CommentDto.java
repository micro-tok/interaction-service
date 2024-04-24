package com.example.interaction_service.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommentDto {
    private String UUID;
    private String UPID;
    private String PUUID;
    private String content;

    public CommentDto() {
    }

    public CommentDto(String UUID, String UPID) {
        this.UUID = UUID;
        this.UPID = UPID;
    }
}
