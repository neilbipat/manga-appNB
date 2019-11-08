package com.example.mangav2.service;

import com.example.mangav2.model.Mangas;

public interface MangaService {

    public Mangas addMangaToDB(Mangas newManga);

    public Iterable<Mangas> listMangas();



}
