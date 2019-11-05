package com.example.login.service;

import com.example.login.controller.SecurityController;
import com.example.login.model.Manga;
import com.example.login.model.User;
import com.example.login.repository.MangaRepository;
import com.example.login.repository.UserRepository;
import com.example.login.controller.SecurityController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class MangaServiceImpl implements MangaService {

    @Autowired
    private MangaRepository mangaRepository;

    @Autowired
    MangaService mangaService;

    @Autowired
    UserRepository userRepository;

    @Autowired
    SecurityController securityController;

    @Override
    public Iterable<Manga> listUserMangas() {
        String username = securityController.getCurrentUserName();
        User user = userRepository.findByUsername(username);
        return mangaRepository.find

        return mangaRepository.findAll();
    }

    @Override
    public Manga getUserManga_titles(String manga_title) {
        String username = securityController.getCurrentUserName();
        User user = userRepository.findByUsername(username);
        return mangaRepository.findByManga_title(manga_title);
    }

}
