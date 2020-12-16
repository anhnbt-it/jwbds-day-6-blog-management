package com.codegym.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Blog implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Lob
    private String title;
    @Column(columnDefinition = "TEXT")
    private String content;
    @Basic(optional = false)
    private String image;
    @Column(columnDefinition = "boolean default false")
    private Boolean locked;

    public Blog() {
    }

    public Blog(String title, String content, String image, Boolean locked) {
        this.title = title;
        this.content = content;
        this.image = image;
        this.locked = locked;
    }

    public Blog(Long id, String title, String content, String image, Boolean locked) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.image = image;
        this.locked = locked;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Boolean getLocked() {
        return locked;
    }

    public void setLocked(Boolean locked) {
        this.locked = locked;
    }
}
