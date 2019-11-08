package com.example.mangav2.repository;

import com.example.mangav2.model.Mangas;
import com.example.mangav2.model.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MangasRepository extends CrudRepository<Mangas, Integer> {

}
