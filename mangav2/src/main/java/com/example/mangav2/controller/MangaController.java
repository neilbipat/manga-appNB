package com.example.mangav2.controller;

import com.example.mangav2.model.Mangas;
import com.example.mangav2.service.MangasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class MangaController {

    @Autowired
    MangasService mangasService;

    @PostMapping("/manga/add")
    public Mangas addManga(@RequestBody Mangas newManga) {
        return mangasService.addMangaToDB(newManga);
    }

    @GetMapping("/manga/list")
    public Iterable<Mangas> listMangas() {
        return mangasService.listMangas();
    }
}
