package com.example.api.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "manga")
public class Manga {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "manga_title")
    private String manga_title;

    @Column(name = "manga_chapter")
    String manga_chapter;

    @Column(name = "manga_page")
    String manga_page;

    @ManyToMany( fetch = FetchType.LAZY,
            cascade = {CascadeType.DETACH,
                    CascadeType.MERGE,
                    CascadeType.REFRESH})
    @JoinColumn(name = "manga_id")
    private
    List<User> manga_read = new ArrayList<>();

//    public List<User> getStoryName() {
//        return storyName;
//    }

//========================================================
    public Manga() {}

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

    public User getUser() {
        return manga_read.stream()
                .filter(user -> "James".equals(user.getUsername()))
                .findAny()
                .orElse(null);
    }

    public void setUser(User user) {
        manga_read.add(user);
    }
}
