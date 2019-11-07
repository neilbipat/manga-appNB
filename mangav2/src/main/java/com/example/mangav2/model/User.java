package com.example.mangav2.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
public class User {
    @Id
    @Column
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String username;

    @Column(unique = true, nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;


    @ManyToMany(fetch = FetchType.LAZY,
        cascade = {CascadeType.DETACH,
        CascadeType.MERGE, CascadeType.REFRESH})
    @JoinTable(name = "user_mangalist",
                joinColumns = {@JoinColumn(name = "user_id")},
                inverseJoinColumns = @JoinColumn(name = "manga_id"))
    private List<Manga> mangas;



    public User() {}

    /**
     *
     * @param manga
     * @return
     */

    public Manga<Mangas> addMangaToList (Mangas manga) {
        if(mangas == null)
            mangas = new ArrayList<>();
        mangas.add(manga);

        return mangas;
    }

    /**
     *
     * @param manga
     * @return
     */


    public List<Mangas> deleteMangasFromList (Manga manga) {
        try {
            manga.remove(manga);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return mangas;
    }

    /**
     *
     * @return
     */


    public List<Mangas> getMangas() {return mangas;}

    /**
     *
     * @param mangas
     */

    public void setMangas(List<Mangas> mangas) {this.mangas = mangas;}


    /**
     *
     * @return
     */

    public Long getId() {
        return id;
    }

    /**
     *
     * @param id
     */

    public void setId(Long id) {
        this.id = id;
    }

    /**
     *
     * @return
     */

    public String getUsername() {
        return username;
    }

    /**
     *
     * @param username
     */

    public void setUsername(String username) {
        this.username = username;
    }

    /**
     *
     * @return
     */

    public String getEmail() {
        return email;
    }

    /**
     *
     * @param email
     */

    public void setEmail(String email) {
        this.email = email;
    }

    /**
     *
     * @return
     */

    public String getPassword() {
        return password;
    }

    /**
     *
     * @param password
     */

    public void setPassword(String password) {
        this.password = password;
    }



}
