package com.example.login.repository;

import com.example.login.model.Manga;
import com.example.login.model.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface MangaRepository extends CrudRepository<Manga, Long> {
}
