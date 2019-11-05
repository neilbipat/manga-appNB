package com.example.login.service;
import com.example.login.model.Manga;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface MangaService {




    /**
     *
     * @return
     */

    public List<Manga> listUserMangaTitle();

    /**
     *
     * @return
     */

    public List<Manga> listUserMangaChapter();

}
