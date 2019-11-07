package com.example.mangav2.model;

import javax.persistence.*;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import java.util.List;

@Entity
@Table(name = "mangas")
public class Mangas {
    @Id
    @Column
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private int id;

    @Column
    private String title;

    @Column
    private String chapter;

    
}
