package com.example.mangav2.service;

import com.example.mangav2.config.JwtUtil;
import com.example.mangav2.model.Mangas;
import com.example.mangav2.model.User;
import com.example.mangav2.repository.MangasRepository;
import com.example.mangav2.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;



public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    MangasRepository mangasRepository;

    @Autowired
    MangasService mangasService;

    @Autowired
    JwtUtil jwtUtil;

    

}
