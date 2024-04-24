package com.example.interaction_service.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UPIDDto {
    private String UPID;

    public UPIDDto() {
    }

    public UPIDDto(String UPID) {
        this.UPID = UPID;
    }
}
