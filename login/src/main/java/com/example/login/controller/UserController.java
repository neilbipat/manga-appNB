package com.example.login.controller;

import com.example.login.model.User;
import com.example.login.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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
}
