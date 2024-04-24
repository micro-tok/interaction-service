package com.example.interaction_service.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UUIDDto {
    private String UUID;

    public UUIDDto() {
    }

    public UUIDDto(String UUID) {
        this.UUID = UUID;
    }
}
