package com.example.login.service;

import com.example.login.model.Manga;
import com.example.login.model.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService {

    public Iterable<Manga> addMangasToUser (String username, int manga_id);

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

}
