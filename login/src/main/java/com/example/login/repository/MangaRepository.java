package com.example.login.repository;

import com.example.login.model.Manga;
import com.example.login.model.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface MangaRepository extends CrudRepository<Manga, Long> {

    @Query("FROM Manga m WHERE m.manga_title = ?1")

    /**
     *
     * @param user
     * @return
     */

    public List<Manga> findMangasByManga_title(User user);

    /**
     *
     * @param user
     * @return
     */

    @Query("FROM Manga m WHERE m.manga_chapter = ?1")


    public List<Manga> findMangaByManga_chapter(User user);
}
