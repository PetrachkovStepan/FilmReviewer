package org.example.controller;

import lombok.AllArgsConstructor;
import org.example.dto.CommentDTO;
import org.example.entity.Comment;
import org.example.service.CommentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class CommentController {

    private final CommentService commentService;

    @PostMapping("/comments/create")
    @CrossOrigin(origins = "http://localhost:3000")
    public ResponseEntity<Comment> create(@ModelAttribute CommentDTO dto){
        return new ResponseEntity<>(commentService.create(dto), HttpStatus.OK);
    }
    @GetMapping("/comments/readbyfilm/{id}")
    @CrossOrigin(origins = "http://localhost:3000")
    public ResponseEntity<List<Comment>> readByFilmId(@PathVariable Long id){
        return new ResponseEntity<>(commentService.findByFilmId(id), HttpStatus.OK);
    }
    @GetMapping("/comments/delete/{id}")
    @CrossOrigin(origins = "http://localhost:3000")
    public HttpStatus delete(@PathVariable Long id){
        commentService.delete(id);
        return HttpStatus.OK;
    }
}
