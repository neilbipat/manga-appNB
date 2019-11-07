package com.example.api.repository;

import com.example.api.model.Manga;
import com.example.api.model.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

    /**
     *
     * @param username
     * @return
     */

    @Query("FROM User u WHERE u.username = ?1 AND u.password =?2")

    public User  findByUsername(String username);

    @Query("SELECT manga_id, manga_name, manga_chapter FROM user_manga r WHERE r.user_id = ?1")

     public List<Manga> findMangaInfoByUser(User user);
}
