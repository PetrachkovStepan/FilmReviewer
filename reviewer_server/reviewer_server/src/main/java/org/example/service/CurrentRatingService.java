package org.example.service;

import lombok.AllArgsConstructor;
import org.example.dto.CurrentRatingDTO;
import org.example.entity.CurrentRating;
import org.example.repository.CurrentRatingRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CurrentRatingService {
    private final CurrentRatingRepository currentRatingRepository;

    public CurrentRating create(CurrentRatingDTO dto){

        List<CurrentRating> currentRatingList = currentRatingRepository.findAll();

        for(CurrentRating cur : currentRatingList){
            if(cur.getUser_id().equals(dto.getUser_id()) &&
                cur.getFilmId().equals(dto.getFilmId())){
                /*CurrentRating currentRating = currentRatingRepository.getReferenceById(dto.getFilmId());
                currentRating.setRating(dto.getRating());
                return currentRatingRepository.save(currentRating);*/
                return cur;
            }
        }
        return currentRatingRepository.save(CurrentRating.builder()
                .filmId(dto.getFilmId())
                .isCritic(dto.isCritic())
                .rating(dto.getRating())
                .user_id(dto.getUser_id())
                .build());
    }
    public List<CurrentRating> findByFilmId(Long id){
        return currentRatingRepository.findByFilmId(id);
    }
    public int getUserCount(Long id){
        List<CurrentRating> currentRatings = currentRatingRepository.findByFilmId(id);
        int userCount = 0;
        for (CurrentRating currentRating : currentRatings) {
            if (!currentRating.isCritic()) {
                userCount++;
            }
        }
        return userCount;
    }
    public int getCriticCount(Long id){
        List<CurrentRating> currentRatings = currentRatingRepository.findByFilmId(id);
        int criticCount = 0;
        for (CurrentRating currentRating : currentRatings) {
            if (currentRating.isCritic()) {
                criticCount++;
            }
        }
        return criticCount;
    }
    public CurrentRating update(CurrentRatingDTO dto){

        List<CurrentRating> currentRatingList = currentRatingRepository.findByFilmId(dto.getFilmId());

        for(CurrentRating cur : currentRatingList){
            if(cur.getUser_id().equals(dto.getUser_id()) &&
                    cur.getFilmId().equals(dto.getFilmId())){
                    cur.setRating(dto.getRating());
                return currentRatingRepository.save(cur);
            }
        }
        return null;
        //return currentRatingRepository.save(currentRating);
    }

}
