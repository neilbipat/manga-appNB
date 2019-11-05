package com.example.api.controller;

import com.example.api.model.Manga;
import com.example.api.repository.UserRepository;
import com.example.api.service.MangaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/manga")

public class MangaController {

    @Autowired
    MangaService mangaService;

    @Autowired
    UserRepository userRepository;

    @GetMapping("/listUserMangaTitle")
    public List<Manga>   listUserMangaTitle() {return mangaService.listUserMangaTitle(); }

    @GetMapping("/listUserMangaChapter")
    public List<Manga> listUserMangaChapter() {return mangaService.listUserMangaChapter(); }

}
