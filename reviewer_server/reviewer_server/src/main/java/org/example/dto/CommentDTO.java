package org.example.dto;

import lombok.Data;

@Data
public class CommentDTO {

    private Long filmId;
    private String text;
    private String name;
    private boolean isCritic;
    private Long user_id;
}
