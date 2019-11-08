package com.example.mangav2.repository;

import com.example.mangav2.model.Mangas;
import com.example.mangav2.model.User;

import org.hibernate.sql.Select;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    @Query("From User u WHERE u.username = ?1 and u.password = ?2")
    public User login(String username, String password);

    public User findByUsername(String username);

    @Query("SELECT u.user_id from User u inner join u.userList ul where ul.manga_id = :manga_id")
    public User getUserMangaList(Long user_id, Long manga_id);

}
