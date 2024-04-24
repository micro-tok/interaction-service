package com.example.interaction_service.controller;

import com.example.interaction_service.dto.LikeDto;
import com.example.interaction_service.dto.UPIDDto;
import com.example.interaction_service.dto.UUIDDto;
import com.example.interaction_service.service.LikeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/like")
@RequiredArgsConstructor
public class LikeController {
    private final LikeService likeService;

    @PostMapping("/save")
    public ResponseEntity<?> saveLike(@RequestBody LikeDto likeDto) {
        return ResponseEntity.ok(likeService.save(likeDto));
    }

    @GetMapping("/find")
    public ResponseEntity<?> findLike(@RequestBody LikeDto likeDto) {
        return ResponseEntity.ok(likeService.findLike(likeDto.getUUID(), likeDto.getUPID()));
    }

    @DeleteMapping("/delete")
    public ResponseEntity<?> deleteLike(@RequestBody LikeDto likeDto) {
        likeService.deleteLike(likeDto.getUUID(), likeDto.getUPID());
        return ResponseEntity.ok("Like deleted successfully");
    }

    @GetMapping("/countAllByPostId")
    public ResponseEntity<?> countAllByPostId(@RequestBody UPIDDto UPID) {
        return ResponseEntity.ok(likeService.countAllByPostId(UPID.getUPID()));
    }

    @GetMapping("/countAllByUserId")
    public ResponseEntity<?> countAllByUserId(@RequestBody UUIDDto UUID) {
        return ResponseEntity.ok(likeService.countAllByUserId(UUID.getUUID()));
    }

    @GetMapping("/findAllByUserId")
    public ResponseEntity<?> findAllByUserId(@RequestBody UUIDDto UUID) {
        return ResponseEntity.ok(likeService.findAllByUserId(UUID.getUUID()));
    }

    @GetMapping("/findAllByPostId")
    public ResponseEntity<?> findAllByPostId(@RequestBody UPIDDto UPID) {
        return ResponseEntity.ok(likeService.findAllByPostId(UPID.getUPID()));
    }
}
