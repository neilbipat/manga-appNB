package com.example.mangav2.controller;

import com.example.mangav2.model.JwtResponse;
import com.example.mangav2.controller.SecurityController;
import com.example.mangav2.model.Mangas;
import com.example.mangav2.model.User;
import com.example.mangav2.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    UserService userService;

    @Autowired
    SecurityController securityController;



    @PostMapping("/signup")
    public ResponseEntity<?> createUser(@RequestBody User newUser) {
        return ResponseEntity.ok(new JwtResponse(userService.createUser(newUser)));
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody User user) {
        return ResponseEntity.ok(new JwtResponse(userService.login(user)));
    }

    @PutMapping("add/{manga_id}/")
    public Iterable<Mangas> addManga(@PathVariable Long manga_id){
        String username = securityController.getCurrentUserName();
        return userService.addMangasToUserList(username, manga_id);
    }

    @DeleteMapping("/delete/{manga_id}/")
    public Iterable<Mangas> deleteMangasFromUserList(@PathVariable Long manga_id) {
        String username = securityController.getCurrentUserName();
        return userService.deleteMangasFromUserList(username, manga_id);
    }

    @GetMapping("get/listUserMangas/")
    public List<Mangas> listUserMangaList() {return userService.listUserMangaList(); }

}


