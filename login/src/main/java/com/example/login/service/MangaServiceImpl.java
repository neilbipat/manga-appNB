package com.example.login.service;

import com.example.login.controller.SecurityController;
import com.example.login.model.Manga;
import com.example.login.model.User;
import com.example.login.repository.MangaRepository;
import com.example.login.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MangaServiceImpl implements MangaService {

    @Autowired
    MangaRepository mangaRepository;

    @Autowired
    MangaService mangaService;

    @Autowired
    UserRepository userRepository;

    @Autowired
    SecurityController securityController;

    @Override
    public List<Manga> listUserMangaTitle() {
        String username = securityController.getCurrentUserName();
        User user = userRepository.findByUsername(username);
        return mangaRepository.findMangaByManga_chapter(user);
    }

    @Override
    public List<Manga> listUserMangaChapter() {
        String username = securityController.getCurrentUserName();
        User user = userRepository.findByUsername(username);
        return mangaRepository.findMangaByManga_chapter(user);

    }

}
