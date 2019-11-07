package com.example.api.service;

import com.example.api.controller.SecurityController;
import com.example.api.model.Manga;
import com.example.api.model.User;
import com.example.api.repository.MangaRepository;
import com.example.api.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
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
    public Manga addManga(Manga newManga) {
        String username = securityController.getCurrentUserName();
        User user = userRepository.findByUsername(username);
        newManga.setUser(user);
        return mangaRepository.save(newManga);
    }

    /**
     *
     * @return
     */

   @Override
    public Iterable<Manga>  listAllMangaTitles() {return mangaRepository.findAll();}

    public List<Manga> listUserMangaTitles() {
       String username = securityController.getCurrentUserName();
       User user = userRepository.findByUsername(username);
       return mangaRepository.findMangTitlesByUser(user);
    }

    public List<Manga> listUserMangaChapters() {
       String username = securityController.getCurrentUserName();
       User user = userRepository.findByUsername(username);
       return mangaRepository.findMangaChaptersByUser(user);
    }

}
