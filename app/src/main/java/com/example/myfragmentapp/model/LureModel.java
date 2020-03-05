package com.example.myfragmentapp.model;

import com.example.myfragmentapp.ui.TypeLure;

import java.io.Serializable;

public class LureModel implements Serializable {
    private String name;
    private int id;
    private String image;
    private String typeLure;


    public LureModel(String name, TypeLure typeLure) {
        this.name = name;
        this.typeLure= String.valueOf(typeLure);
    }


    public LureModel(String name) {
        this.name = name;
    }

    public LureModel() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getTypeLure() {
        return typeLure;
    }

    public void setTypeLure(String typeLure) {
        this.typeLure = typeLure;
    }
}
