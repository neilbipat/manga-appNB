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

    public List<Manga> listMangaTitles();

    /**
     *
     * @return
     */

    public List<Manga> listMangaChapters();

}
