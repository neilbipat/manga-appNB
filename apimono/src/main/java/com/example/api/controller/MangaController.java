package com.example.api.controller;

import com.example.api.model.Manga;
import com.example.api.repository.UserRepository;
import com.example.api.service.MangaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/manga")

public class MangaController {

    @Autowired
    MangaService mangaService;

    @Autowired
    UserRepository userRepository;

    @PostMapping("/add")
    public Manga addManga(@RequestBody Manga newManga) {return mangaService.addManga(newManga);}

    @GetMapping("/listAllMangas")
    public Iterable<Manga> listAllMangas() {return mangaService.listAllMangaTitles();}

    @GetMapping("/listUserMangaTitles")
    public Iterable<Manga> listUserMangaTitles() {return mangaService.listUserMangaTitles();}

    @GetMapping("/listUserMangaChapters")
    public Iterable<Manga> listUserMangaChapters() {return mangaService.listUserMangaChapters();}


}
