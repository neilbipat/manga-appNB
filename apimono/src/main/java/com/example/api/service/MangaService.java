package com.example.api.service;
import com.example.api.model.Manga;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface MangaService {




    /**
     *
     * @return
     */

    public Iterable<Manga> listAllMangaTitles();

    /**
     *
     * @return
     */

    public List<Manga> listUserMangaTitles();

    public List<Manga> listUserMangaChapters();

}
