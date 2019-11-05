package com.example.login.service;

import com.example.login.model.Manga;

public interface MangaService {

    /**
     *
     * @return listMangas
     */

    public Iterable<Manga> listMangas();

    /**
     *
     * @param manga_title
     * @return
     */

    public Manga getManga_title (String manga_title);

    /**
     *
     * @param manga_chapter
     * @return
     */

    public Manga getManga_chapter (String manga_chapter);

}
