package com.example.mangav2.service;

import com.example.mangav2.config.JwtUtil;
import com.example.mangav2.controller.SecurityController;
import com.example.mangav2.model.Mangas;
import com.example.mangav2.model.User;
import com.example.mangav2.repository.MangasRepository;
import com.example.mangav2.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    MangasRepository mangasRepository;

    @Autowired
    MangasService mangasService;

    @Autowired
    JwtUtil jwtUtil;

    @Autowired
    SecurityController securityController;

    @Autowired
    @Qualifier("encoder")
    PasswordEncoder bCryptPasswordEncoder;

    @Override
    public User getUser(String username) {
        return userRepository.findByUsername(username);
    }

    private List<GrantedAuthority> getGrantedAuthorities(User user){
        List<GrantedAuthority> authorities = new ArrayList<>();

        authorities.add(new SimpleGrantedAuthority(user.getUsername()));

        return authorities;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = getUser(username);

        if(user==null)
            throw new UsernameNotFoundException("User null");

        return new org.springframework.security.core.userdetails.User (user.getUsername(), bCryptPasswordEncoder.encode(user.getPassword()),
                true, true, true, true, getGrantedAuthorities(user));

    }

    @Override
    public String login(User user){
        User returningUser = userRepository.findByUsername(user.getUsername());
        if(returningUser != null && bCryptPasswordEncoder.matches(user.getPassword(), returningUser.getPassword())){
            UserDetails userDetails = loadUserByUsername(returningUser.getUsername());
            return jwtUtil.generateToken(userDetails);
        }
        return null;
    }

    @Override
    public String createUser(User newUser) {
        newUser.setPassword(bCryptPasswordEncoder.encode(newUser.getPassword()));
        if(userRepository.save(newUser) != null){
            UserDetails userDetails = loadUserByUsername(newUser.getUsername());
            return jwtUtil.generateToken(userDetails);
        }
        return null;
    }

    @Override
    public Iterable<Mangas> addMangasToUserList(String username, int manga_id) {
        Mangas manga = mangasRepository.findById(manga_id).get();
        User user = getUser(username);
        user.addMangaToList(manga);

        mangasRepository.save(manga);
        return user.getMangas();
    }

    public Iterable<Mangas> deleteMangasFromUserList(String username, int manga_id) {
        Mangas manga = mangasRepository.findById(manga_id).get();
        User user = getUser(username);
        user.deleteMangasFromList(manga);

        userRepository.save(user);
        return user.getMangas();
    }

    @Override
    public List<Mangas> listUserMangaList() {
        String username = securityController.getCurrentUserName();
        User user = userRepository.findByUsername(username);
        return mangasRepository.findAllByUserId(user);
    }

}
