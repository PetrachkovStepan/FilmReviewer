package org.example.repository;

import org.example.entity.GeneralRating;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GeneralRatingRepository  extends JpaRepository<GeneralRating, Long> {
    List<GeneralRating> findByFilm(Long film);

}
