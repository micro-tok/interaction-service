package com.example.interaction_service.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LikeDto {
    private Long id;
    private String UUID;
    private String UPID;

    public LikeDto() {
    }

    public LikeDto(Long id, String UUID, String UPID) {
        this.id = id;
        this.UUID = UUID;
        this.UPID = UPID;
    }
}
