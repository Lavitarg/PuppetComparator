package com.example.demo.Entities;

import javax.persistence.*;

@Entity
@Table(name = "Puppy")
public class Puppy {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private Integer score;
    private String linkToImage;
    private String name;

    protected Puppy(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public String getLinkToImage() {
        return linkToImage;
    }

    public void setLinkToImage(String linkToImage) {
        this.linkToImage = linkToImage;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
