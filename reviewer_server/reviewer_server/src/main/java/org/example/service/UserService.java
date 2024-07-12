package org.example.service;


import lombok.AllArgsConstructor;
import org.example.dto.UserDTO;
import org.example.entity.Users;
import org.example.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Logger;

@Service
@AllArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public Users create(UserDTO dto){

        List<Users> usersList = userRepository.findAll();
        for (Users users : usersList) {
            if (users.getName().equals(dto.getName())) {
                return null;
            }
        }
        System.out.println(dto.getName());
        return userRepository.save(Users.builder()
                .name(dto.getName())
                .password(dto.getPassword())
                .role(false)
                .isBlocked(false)
                .isRequested(false)
                .build());
    }
    public Users login(String name, String password){
        List<Users> usersList = userRepository.findAll();
        for (Users users : usersList) {
            if (users.getName().equals(name) &&
                    users.getPassword().equals(password)
                    && !users.isBlocked()) {
                return users;
            }
        }
        return null;
    }
    public List<Users> readAll() {
        return userRepository.findAll();
    }
    public Users update(UserDTO dto){

        Users user = userRepository.getReferenceById(dto.getId());
        user.setRole(dto.isRole());
        user.setBlocked(dto.isBlocked());
        user.setRequested(dto.isRequested());

        return userRepository.save(user);
    }
    public void delete(Long id){
        userRepository.deleteById(id);
    }
}
