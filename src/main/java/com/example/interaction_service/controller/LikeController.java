package com.example.interaction_service.controller;

import com.example.interaction_service.dto.LikeDto;
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
    public ResponseEntity<?> countAllByPostId(@RequestBody String postId) {
        return ResponseEntity.ok(likeService.countAllByPostId(postId));
    }

    @GetMapping("/countAllByUserId")
    public ResponseEntity<?> countAllByUserId(@RequestBody String userId) {
        return ResponseEntity.ok(likeService.countAllByUserId(userId));
    }

    @GetMapping("/findAllByUserId")
    public ResponseEntity<?> findAllByUserId(@RequestBody String userId) {
        return ResponseEntity.ok(likeService.findAllByUserId(userId));
    }
}
