package org.example.controller;

import lombok.AllArgsConstructor;
import org.example.dto.ToWatchDTO;
import org.example.entity.CurrentRating;
import org.example.entity.ToWatch;
import org.example.service.ToWatchServise;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class ToWatchController {
    private final ToWatchServise toWatchServise;
    @PostMapping("/towatch/create")
    @CrossOrigin(origins = "http://localhost:3000")
    public ResponseEntity<ToWatch> create(@ModelAttribute ToWatchDTO dto){
        return new ResponseEntity<>(toWatchServise.create(dto), HttpStatus.OK);
    }
    @GetMapping("/towatch/readbyfilm/{id}/{user}")
    @CrossOrigin(origins = "http://localhost:3000")
    public ResponseEntity<ToWatch> readByFilmId(@PathVariable Long id, @PathVariable Long user){
        return new ResponseEntity<>(toWatchServise.findToWatchByFilm_id(id, user), HttpStatus.OK);
    }
    @GetMapping("/towatch/readall/{id}")
    @CrossOrigin(origins = "http://localhost:3000")
    public ResponseEntity<List<ToWatch>> readAll(@PathVariable Long id){
        return new ResponseEntity<>(toWatchServise.readAll(id), HttpStatus.OK);
    }
    @DeleteMapping("/towatch/delete/{id}/{user}")
    @CrossOrigin(origins = "http://localhost:3000")
    public HttpStatus delete(@PathVariable Long id, @PathVariable Long user){
        toWatchServise.delete(id, user);
        return HttpStatus.OK;
    }

}
