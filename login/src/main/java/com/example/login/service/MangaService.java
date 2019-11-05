package com.example.login.service;

import com.example.login.model.Manga;

public interface MangaService {

    /**
     *
     * @return listMangas (Users)
     */

    public Iterable<Manga> listUserMangas();

    /**
     *
     * @param manga_title
     * @return
     */

    public Manga getUserManga_titles (String manga_title);

    /**
     *
     * @param manga_chapter
     * @return
     */

    public Manga getUserManga_chapters (String manga_chapter);

}
