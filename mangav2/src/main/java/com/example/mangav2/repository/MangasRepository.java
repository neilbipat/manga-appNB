package com.example.mangav2.repository;

import com.example.mangav2.model.Mangas;
import com.example.mangav2.model.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MangasRepository extends CrudRepository<Mangas, Long> {
    @Query("From Mangas m WHERE m.title = ?1")
    public Mangas findMangasByTitle(String title);

}
