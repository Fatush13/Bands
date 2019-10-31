package com.example.Bands.domain;

import javax.persistence.*;

@Entity
public class Band {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String origin;
    private Integer foundation;
    private String genre;
    private String filename;

    public Band(String name, String genre, String origin, Integer foundation) {
        this.name = name;
        this.genre = genre;
        this.origin = origin;
        this.foundation = foundation;
    }

    public Band(String name, String genre, String origin, Integer foundation, String filename) {
        this.name = name;
        this.genre = genre;
        this.origin = origin;
        this.foundation = foundation;
        this.filename = filename;
    }

    public Band() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public Integer getFoundation() {
        return foundation;
    }

    public void setFoundation(Integer foundation) {
        this.foundation = foundation;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }
}
