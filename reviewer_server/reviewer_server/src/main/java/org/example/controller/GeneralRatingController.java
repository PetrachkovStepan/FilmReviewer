package org.example.controller;

import lombok.AllArgsConstructor;
import org.example.dto.GeneralRatingDTO;
import org.example.entity.GeneralRating;
import org.example.service.GeneralRatingService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class GeneralRatingController {

    private final GeneralRatingService generalRatingService;

    @PostMapping("/generalrating/create")
    @CrossOrigin(origins = "http://localhost:3000")
    public ResponseEntity<GeneralRating> create(@ModelAttribute GeneralRatingDTO dto){
        return new ResponseEntity<>(generalRatingService.create(dto), HttpStatus.OK);
    }
    @GetMapping("/generalrating/readbyfilm/{id}")
    @CrossOrigin(origins = "http://localhost:3000")
    public ResponseEntity<List<GeneralRating>> readByFilm(@PathVariable Long id){
        return new ResponseEntity<>(generalRatingService.findByFilm(id), HttpStatus.OK);
    }
    @PostMapping("/generalrating/update")
    @CrossOrigin(origins = "http://localhost:3000")
    public ResponseEntity<GeneralRating> update(@ModelAttribute GeneralRatingDTO dto){
        return new ResponseEntity<>(generalRatingService.update(dto), HttpStatus.OK);
    }
}
