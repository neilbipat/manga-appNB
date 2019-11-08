package com.example.mangav2.repository;

import com.example.mangav2.model.Mangas;
import org.springframework.data.repository.CrudRepository;


public interface MangasRepository extends CrudRepository<Mangas, Integer> {
}
