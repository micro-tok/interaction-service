package com.example.interaction_service.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LikeDto {
    private String UUID;
    private String UPID;
    private String PUUID;

    public LikeDto() {
    }

    public LikeDto(Long id, String UUID, String UPID) {
        this.UUID = UUID;
        this.UPID = UPID;
    }
}
