package org.example.controller;

import lombok.AllArgsConstructor;
import org.example.dto.CurrentRatingDTO;
import org.example.entity.CurrentRating;
import org.example.service.CurrentRatingService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class CurrentRatingController {
    private final CurrentRatingService currentRatingService;
    @PostMapping("/currentratings/create")
    @CrossOrigin(origins = "http://localhost:3000")
    public ResponseEntity<CurrentRating> create(@ModelAttribute CurrentRatingDTO dto){
        return new ResponseEntity<>(currentRatingService.create(dto), HttpStatus.OK);
    }
    @GetMapping("/currentratings/readbyfilm/{id}")
    @CrossOrigin(origins = "http://localhost:3000")
    public ResponseEntity<List<CurrentRating>> readByFilmId(@PathVariable Long id){
        return new ResponseEntity<>(currentRatingService.findByFilmId(id), HttpStatus.OK);
    }
    @GetMapping("/currentratings/criticcount/{id}")
    @CrossOrigin(origins = "http://localhost:3000")
    public ResponseEntity<Integer> getCriticCount(@PathVariable Long id){
        return new ResponseEntity<>(currentRatingService.getCriticCount(id), HttpStatus.OK);
    }
    @GetMapping("/currentratings/usercount/{id}")
    @CrossOrigin(origins = "http://localhost:3000")
    public ResponseEntity<Integer> getUserCount(@PathVariable Long id){
        return new ResponseEntity<>(currentRatingService.getUserCount(id), HttpStatus.OK);
    }
    @PostMapping("/currentratings/update")
    @CrossOrigin(origins = "http://localhost:3000")
    public ResponseEntity<CurrentRating> update(@ModelAttribute CurrentRatingDTO dto){
        return new ResponseEntity<>(currentRatingService.update(dto), HttpStatus.OK);
    }
}
