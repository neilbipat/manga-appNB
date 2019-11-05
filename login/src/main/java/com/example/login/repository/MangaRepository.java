package com.example.login.repository;

import com.example.login.model.Manga;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MangaRepository extends CrudRepository<Manga, Long> {

    /**
     *
     * @param manga_title
     * @return
     */

    @Query("From Manga m Where m.manga_title = ?1")

    public Manga findByManga_title(String manga_title);

}
