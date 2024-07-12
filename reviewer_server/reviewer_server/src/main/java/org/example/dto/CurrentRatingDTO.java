package org.example.dto;

import lombok.Data;

@Data
public class CurrentRatingDTO {

    private Long filmId;
    private boolean isCritic;
    private int rating;
    private Long user_id;

}
