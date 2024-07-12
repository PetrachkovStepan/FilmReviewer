package org.example.service;

import lombok.AllArgsConstructor;
import org.example.dto.ToWatchDTO;
import org.example.entity.CurrentRating;
import org.example.entity.ToWatch;
import org.example.repository.ToWatchRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
@AllArgsConstructor
public class ToWatchServise {
    private final ToWatchRepository toWatchRepository;

    public ToWatch create(ToWatchDTO dto){
        return toWatchRepository.save(ToWatch.builder()
                .film_id(dto.getFilm_id())
                .user_id(dto.getUser_id())
                .build());
    }
    public ToWatch findToWatchByFilm_id(Long film, Long user){
        List<ToWatch> toWatches = toWatchRepository.findAll();
        for(ToWatch cur : toWatches){
            if(cur.getFilm_id() == film.intValue() &&
                    cur.getUser_id() == user.intValue()){
                return cur;
            }
        }
        return null;
    }
    public List<ToWatch> readAll(Long id){
        List<ToWatch> toWatches = toWatchRepository.findAll();
        List<ToWatch> resp = new ArrayList<>();
        for(ToWatch cur : toWatches){
            if(cur.getUser_id() == id.intValue()){
                resp.add(cur);
            }
        }
        return resp;
    }
    public void delete(Long id, Long user){
        List<ToWatch> toWatches = toWatchRepository.findAll();
        for(ToWatch cur : toWatches){
            if(cur.getFilm_id() == id.intValue() &&
                    cur.getUser_id() == user.intValue()){
                toWatchRepository.deleteById(cur.getId());
            }
        }
    }
}
