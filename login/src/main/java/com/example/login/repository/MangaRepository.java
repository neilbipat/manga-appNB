package com.example.login.repository;

import com.example.login.model.Manga;
import com.example.login.model.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface MangaRepository extends CrudRepository<Manga, Long> {

    /**
     *
     * @param user
     * @return
     */

    public List<Manga> findMangasByManga_title(User user);

    public List<Manga> findMangaByManga_chapter(User user;)
}
