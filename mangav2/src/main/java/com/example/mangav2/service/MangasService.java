package com.example.mangav2.service;

import com.example.mangav2.model.Mangas;

public interface MangasService {

    public Mangas addMangaToDB(Mangas newManga);

    public Iterable<Mangas> listMangas();



}
