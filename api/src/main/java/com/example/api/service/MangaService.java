package com.example.api.service;
import com.example.api.model.Manga;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
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
