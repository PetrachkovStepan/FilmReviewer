package org.example.dto;

import lombok.Data;

@Data
public class GeneralRatingDTO {

    private Long film;
    private double userRating;
    private double criticRating;
}
