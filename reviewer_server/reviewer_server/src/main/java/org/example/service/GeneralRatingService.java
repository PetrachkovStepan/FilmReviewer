package org.example.service;

import lombok.AllArgsConstructor;
import org.example.dto.GeneralRatingDTO;
import org.example.entity.CurrentRating;
import org.example.entity.GeneralRating;
import org.example.entity.Users;
import org.example.repository.CurrentRatingRepository;
import org.example.repository.GeneralRatingRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class GeneralRatingService {
    private final GeneralRatingRepository generalRatingRepository;
    private final CurrentRatingRepository currentRatingRepository;

    public GeneralRating create(GeneralRatingDTO dto){
        List<GeneralRating> generalRatingList = generalRatingRepository.findAll();
        for(GeneralRating gen : generalRatingList){
            if(gen.getFilm().equals(dto.getFilm())){
                return gen;
            }
        }
        return generalRatingRepository.save(GeneralRating.builder()
                .film(dto.getFilm())
                .userRating(dto.getUserRating())
                .criticRating(dto.getCriticRating())
                .build());
    }
    public List<GeneralRating> findByFilm(Long id){
        List<GeneralRating> generalRatingList = new ArrayList<>(generalRatingRepository.findByFilm(id));
        if(generalRatingList.isEmpty()){
            GeneralRating gen = generalRatingRepository.save(GeneralRating.builder()
                    .film(id)
                    .userRating(0)
                    .criticRating(0)
                    .build());
            generalRatingList.add(gen);
        }
        return generalRatingList;
    }
    public GeneralRating update(GeneralRatingDTO dto){
        List<CurrentRating> currentRatings = currentRatingRepository.findByFilmId(dto.getFilm());
        double user = 0;
        double critic = 0;
        int criticCount = 0;
        int userCount = 0;
        List<GeneralRating> generalRatingList = generalRatingRepository.findAll();
        for(GeneralRating gen : generalRatingList){
            if(gen.getFilm().equals(dto.getFilm())){
                for(int i = 0 ; i< currentRatings.size(); i++){
                    if (currentRatings.get(i).isCritic()) {
                        critic += currentRatings.get(i).getRating();
                        criticCount++;
                    }else {
                        user += currentRatings.get(i).getRating();
                        userCount++;
                    }
                }
                gen.setUserRating(user/userCount);
                gen.setCriticRating(critic/criticCount);
                return generalRatingRepository.save(gen);
            }
        }
        return null;
    }
}
