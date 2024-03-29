package com.example.mangav2.service;
import com.example.mangav2.model.Mangas;
import com.example.mangav2.model.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;


public interface UserService extends UserDetailsService {

    public String createUser(User newUser);

    public String login(User user);

    public User getUser(String username);

    public Iterable<Mangas> addMangasToUserList(String username, String title);

    public Iterable<Mangas> deleteMangasFromUserList(String username, String title);

    public List<Mangas> listUserMangaList();
}
