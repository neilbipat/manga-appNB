package com.example.api.controller;

import com.example.api.model.Manga;
import com.example.api.model.User;
import com.example.api.service.UserService;
import com.example.api.model.JwtResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    /**
     *
     * @return
     */

    @GetMapping("/listUsers")
    public Iterable<User> listUsers() {return userService.listUsers(); }


    /**
     *
     * @return
     */

    @GetMapping("/hello")
    public String helloWorld() {return "Hello World!";}

    /**
     *
     * @param newUser
     * @return
     */

    @PostMapping("/signup")
    public ResponseEntity<?> createUser(@RequestBody User newUser) {
        return ResponseEntity.ok(new JwtResponse(userService.createUser(newUser)));
    }

    /**
     *
     * @param user
     * @return
     */

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody User user) {
        return ResponseEntity.ok(new JwtResponse(userService.login(user)));
    }

    @PutMapping("{username}/add{manga_id}")
    public Iterable<Manga> addManga(@PathVariable String username, @PathVariable long manga_id) {
        return userService.addMangasToList(username, manga_id);
    }


}
