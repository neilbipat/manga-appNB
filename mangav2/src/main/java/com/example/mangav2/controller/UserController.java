package com.example.mangav2.controller;

import com.example.mangav2.model.JwtResponse;
import com.example.mangav2.model.Mangas;
import com.example.mangav2.model.User;
import com.example.mangav2.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {
    @Autowired
    UserService userService;


    @PostMapping("/signup")
    public ResponseEntity<?> createUser(@RequestBody User newUser) {
        return ResponseEntity.ok(new JwtResponse(userService.createUser(newUser)));
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody User user) {
        return ResponseEntity.ok(new JwtResponse(userService.login(user)));
    }

    @PutMapping("add/{username}/{manga_id}/")
    public Iterable<Mangas> addManga(@PathVariable String username, @PathVariable int manga_id){
        return userService.addMangasToUserList(username, manga_id);
    }

    @DeleteMapping("/delete/{username}/{manga_id}/")
    public Iterable<Mangas> deleteMangasFromUserList(@PathVariable String username, @PathVariable int manga_id) {
        return userService.deleteMangasFromUserList(username, manga_id);
    }



}


