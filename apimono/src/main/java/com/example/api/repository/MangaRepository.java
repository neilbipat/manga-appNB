package com.example.api.repository;

import com.example.api.model.Manga;
import com.example.api.model.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MangaRepository extends CrudRepository<Manga, Long> {

    @Query("FROM Manga m WHERE m.manga_title = ?1")

    /**
     *
     * @param user
     * @return
     */

    public List<Manga> findMangaByMangaTitle(User user);
    
    // @Query("SELECT manga_id, manga_name, manga_chapter FROM user_manga m WHERE m.title = ?1 AND user_id = ?2

}
