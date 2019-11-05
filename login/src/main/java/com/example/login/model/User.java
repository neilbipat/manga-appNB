package com.example.login.model;

import javax.persistence.*;
import java.util.ArrayList;
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

    @ManyToMany( fetch = FetchType.LAZY,
            cascade = {CascadeType.DETACH,
                    CascadeType.MERGE,
                    CascadeType.REFRESH})
    @JoinTable(name = "user_manga",
            joinColumns = {@JoinColumn(name = "user_id")},
            inverseJoinColumns = @JoinColumn(name = "manga_id"))
    private List<Manga> mangas;

//    Default Constructor

    public User() {}



    public List<Manga> addMangasToUser (Manga manga){
        if(mangas == null)
            mangas = new ArrayList<>();
        mangas.add(manga);

        return mangas;
    }


    /**
     *
     * @return manga
     */

    public List<Manga> getManga() {return mangas;}

    /**
     *
     * @return id
     */

    public void setManga(List<Manga> mangas) {this.mangas = mangas;}

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
