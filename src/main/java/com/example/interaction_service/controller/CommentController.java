package com.example.interaction_service.controller;

import com.example.interaction_service.dto.CommentDto;
import com.example.interaction_service.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/comment")
@RequiredArgsConstructor
public class CommentController {
    private final CommentService commentService;

    @PostMapping("/save")
    public ResponseEntity<?> saveComment(@RequestBody CommentDto commentDto) {
        return ResponseEntity.ok(commentService.save(commentDto));
    }

    @GetMapping("/find")
    public ResponseEntity<?> findComment(@RequestBody CommentDto commentDto) {
        return ResponseEntity.ok(commentService.findComment(commentDto.getUUID(), commentDto.getUPID()));
    }

    @DeleteMapping("/delete")
    public ResponseEntity<?> deleteComment(@RequestBody CommentDto commentDto) {
        commentService.deleteComment(commentDto.getUUID(), commentDto.getUPID());
        return ResponseEntity.ok("Comment deleted successfully");
    }

    @GetMapping("/countAllByPostId")
    public ResponseEntity<?> countAllByPostId(@RequestBody String postId) {
        return ResponseEntity.ok(commentService.countAllByPostId(postId));
    }

    @GetMapping("/countAllByUserId")
    public ResponseEntity<?> countAllByUserId(@RequestBody String userId) {
        return ResponseEntity.ok(commentService.countAllByUserId(userId));
    }

    @GetMapping("/findAllByUserId")
    public ResponseEntity<?> findAllByUserId(@RequestBody String userId) {
        return ResponseEntity.ok(commentService.findAllByUserId(userId));
    }

    @GetMapping("/findAllByPostId")
    public ResponseEntity<?> findAllByPostId(@RequestBody String postId) {
        return ResponseEntity.ok(commentService.findAllByPostId(postId));
    }

    @GetMapping("/findAll")
    public ResponseEntity<?> findAll() {
        return ResponseEntity.ok(commentService.findAll());
    }
}
