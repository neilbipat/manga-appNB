package com.example.mangav2.service;
import com.example.mangav2.model.Mangas;
import com.example.mangav2.model.User;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UserDetailsService;


public interface UserService extends UserDetailsService {

    public String createUser(User newUser);

    public String login(User user);

    public Iterable<Mangas> addMangasToUserList(String username, int manga_id);

    public Iterable<Mangas> deleteMangasFromUserList(String username, int manga_id);

}
