package org.example.repository;

import org.example.entity.CurrentRating;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CurrentRatingRepository extends JpaRepository<CurrentRating, Long> {
    List<CurrentRating> findByFilmId(Long film_id);
}
