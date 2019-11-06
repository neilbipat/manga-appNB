package com.example.api.service;

import com.example.api.model.Manga;
import com.example.api.model.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService extends UserDetailsService {


    /**
     *
     * @return listUsers
     */
    public Iterable<User> listUsers();

    /**
     *
     * @param newUser
     * @return
     */

    public String createUser (User newUser);

    /**
     *
     * @param user
     * @return
     */

    public String login(User user);

    /**
     *
     * @param username
     * @return
     */

    public User getUser (String username);

    public Iterable<Manga> addMangasToList(String username, long manga_id);

}


