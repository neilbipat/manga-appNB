package com.example.mangav2.service;

import org.springframework.beans.factory.annotation.Autowired;
import com.example.mangav2.model.Mangas;
import com.example.mangav2.repository.MangasRepository;

public class MangasServiceImpl {

    @Autowired
    MangasRepository mangasRepository;

    @Autowired
    MangasService mangasService;

    @Override
    public Mangas addMangaToDB(Mangas newManga) {
        return mangasRepository.save(newManga);
    }

    @Override
    public Iterable<Mangas> listMangas() {
        return mangasRepository.findAll();
    }

}
