package com.example.interaction_service.controller;

import com.example.interaction_service.dto.CommentDto;
import com.example.interaction_service.dto.UPIDDto;
import com.example.interaction_service.dto.UUIDDto;
import com.example.interaction_service.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

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
    public ResponseEntity<?> countAllByPostId(@RequestBody UPIDDto UPID) {
        return ResponseEntity.ok(commentService.countAllByPostId(UPID.getUPID()));
    }

    @GetMapping("/countAllByUserId")
    public ResponseEntity<?> countAllByUserId(@RequestBody UUIDDto UUID) {
        return ResponseEntity.ok(commentService.countAllByUserId(UUID.getUUID()));
    }

    @GetMapping("/findAllByUserId")
    public ResponseEntity<?> findAllByUserId(@RequestBody UUIDDto UUID) {
        return ResponseEntity.ok(commentService.findAllByUserId(UUID.getUUID()));
    }

    @GetMapping("/findAllByPostId")
    public ResponseEntity<?> findAllByPostId(@RequestBody UPIDDto UPID) {
        return ResponseEntity.ok(commentService.findAllByPostId(UPID.getUPID()));
    }

    @GetMapping("/findAll")
    public ResponseEntity<?> findAll() {
        return ResponseEntity.ok(commentService.findAll());
    }
}
