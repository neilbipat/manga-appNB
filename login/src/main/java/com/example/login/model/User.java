package com.example.login.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "users")
public class User {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String username;

    @Column(unique = true, nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "manga_id")
    @JsonBackReference
    private Manga manga;


    public User() {}

    /**
     *
     * @return manga
     */

    public Manga getManga() {return manga;}

    /**
     *
     * @return id
     */

    public Long getId() {return id;}

    /**
     *
     * @param id
     */

    public void setId(Long id) {this.id = id;}

    /**
     *
     * @return username
     */

    public String getUsername() {return username;}

    /**
     *
     * @param username
     */

    public void setUsername(String username) {this.username = username;}

    /**
     *
     * @return email
     */

    public String getEmail() {return email;}

    /**
     *
     * @param email
     */

    public void setEmail(String email) {this.email = email;}

    /**
     *
     * @return password
     */

    public String getPassword() {return password;}

    /**
     *
     * @param password
     */

    public void setPassword(String password) {this.password = password;}



}
