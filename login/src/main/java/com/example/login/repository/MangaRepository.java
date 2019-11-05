package com.example.login.repository;

import com.example.login.model.Manga;
import com.example.login.model.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MangaRepository extends CrudRepository<Manga, Long> {

    /**
     *
     * @param user
     * @return
     */

    @Query("From Manga m Where m.manga_title = ?1 And m.manga_chapter")


    public List<Manga> findMangasByUser(User user;


}
