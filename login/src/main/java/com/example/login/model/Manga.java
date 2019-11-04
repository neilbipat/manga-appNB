package com.example.login.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "manga")
public class Manga {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String manga_title;

    @Column String manga_chapter;

    @Column String manga_page;

    @ManyToMany( cascade = {CascadeType.DETACH, CascadeType.PERSIST ,
    CascadeType.MERGE, CascadeType.REFRESH})
    @JoinColumn
    private List<User> user;

    public Manga() {}

    /**
     *
     * @return id
     */

    public List<User> getUsers() {return user;}

    public void setUser(User user) {this.user.add(user);}

    public Long getId() {return id;}

    /**
     *
     * @param id
     */

    public void setId(Long id) {this.id = id;}

    /**
     *
     * @return manga_title
     */

    public String getManga_title() {return manga_title; }

    /**
     *
     * @param manga_title
     */

    public void setManga_title(String manga_title) {this.manga_title = manga_title;}

    /**
     *
     * @return manga_title
     */

    public String getManga_chapter() {return manga_chapter;}

    /**
     *
     * @param manga_chapter
     */

    public void setManga_chapter(String manga_chapter) {this.manga_chapter = manga_chapter;}

    /**
     *
     * @return manga_chapter
     */

    public String getManga_page() {return manga_page;}

    /**
     *
     * @param manga_page
     */

    public void setManga_page(String manga_page) {this.manga_page = manga_page;}




}
