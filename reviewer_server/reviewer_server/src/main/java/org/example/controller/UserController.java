package org.example.controller;

import lombok.AllArgsConstructor;
import org.example.dto.UserDTO;
import org.example.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.example.entity.Users;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping("/users/create")
    @CrossOrigin(origins = "http://localhost:3000")
   
    public ResponseEntity<Users> create(@ModelAttribute UserDTO dto){
        return new ResponseEntity<>(userService.create(dto), HttpStatus.OK);
    }
    @PostMapping("/users/login/{name}/{password}")
    @CrossOrigin(origins = "http://localhost:3000")
    public ResponseEntity<Users> login(@PathVariable String name, @PathVariable String password){
        return new ResponseEntity<>(userService.login(name, password), HttpStatus.OK);
    }
    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/users/readall")
    public ResponseEntity<List<Users>> readAll(){
        return new ResponseEntity<>(userService.readAll(), HttpStatus.OK);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/users/update")
    public ResponseEntity<Users> update(@ModelAttribute UserDTO dto){
        return new ResponseEntity<>(userService.update(dto), HttpStatus.OK);
    }
    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/users/delete/{id}")
    public HttpStatus delete(@PathVariable Long id){
        userService.delete(id);
        return HttpStatus.OK;
    }
}
