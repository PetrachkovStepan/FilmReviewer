package org.example.dto;

import lombok.Data;
import org.example.entity.CurrentRating;
import org.example.entity.ToWatch;

import java.util.List;

@Data
public class UserDTO {

    private Long id;
    private String name;
    private String password;
    private boolean role;
    private boolean isBlocked;
    private boolean isRequested;

    private List<CommentDTO> comments;
    private CurrentRating currentRating;
    private List<ToWatch> toWatches;
}
