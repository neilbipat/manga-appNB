package com.example.api.repository;

import com.example.api.model.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

    /**
     *
     * @param username
     * @return
     */

    @Query("FROM User u WHERE u.username = ?1 AND u.password =?2")

    public User  findByUsername(String username);

}
