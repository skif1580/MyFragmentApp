package com.example.myfragmentapp.model;


import com.orm.SugarRecord;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Fish extends SugarRecord<Fish> {
    private String name;
    private String data;
    private long key;
    private int image;
    private double length;
    private double weight;

    public Fish() {
    }

    public Fish(String name, int image, double length, double weight) {
        this.name = name;
        this.data=new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(new Date());
        this.image = image;
        this.length = length;
        this.weight = weight;
        this.key=System.currentTimeMillis();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }
}
