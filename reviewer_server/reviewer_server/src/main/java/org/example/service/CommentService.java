package org.example.service;

import lombok.AllArgsConstructor;
import org.example.dto.CommentDTO;
import org.example.entity.Comment;
import org.example.repository.CommentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CommentService {
    private final CommentRepository commentRepository;

    public Comment create(CommentDTO dto){
        return commentRepository.save(Comment.builder()
                .filmId(dto.getFilmId())
                .text(dto.getText())
                .name(dto.getName())
                .isCritic(dto.isCritic())
                .user_id(dto.getUser_id())
                .build());
    }
    public List<Comment> findByFilmId(Long id){
        return commentRepository.findByFilmId(id);
    }
    public void delete(Long id){
        commentRepository.deleteById(id);
    }
}
