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


//    =========empty constructor ==========//
    public User() {}

    public Manga<Mangas> addMangaToList (Mangas manga) {
        if(mangas == null)
            mangas = new ArrayList<>();
        mangas.add(manga);

        return mangas;
    }

    public List<Mangas> deleteMangasFromList (Manga manga) {
        try {
            manga.remove(manga);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return mangas;
    }

    public List<Mangas> getMangas() {return mangas;}

    public void setMangas(List<Mangas> mangas) {this.mangas = mangas;}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
