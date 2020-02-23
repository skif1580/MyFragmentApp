package com.example.myfragmentapp.model;

import com.orm.SugarRecord;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Fishing extends SugarRecord<Fishing> {
    private String name;
    private String date;
    private String image;
    private int fish;
    private int fishWeight;
    private long key;

    public Fishing() {
        this.date = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(new Date());
        this.key = System.currentTimeMillis();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }


    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getFish() {
        return fish;
    }

    public void setFish(int fish) {
        this.fish = fish;
    }

    public int getFishWeight() {
        return fishWeight;
    }

    public void setFishWeight(int fishWeight) {
        this.fishWeight = fishWeight;
    }

    public Fishing(String name, String image) {
        this.name = name;
        this.image = image;
        this.date = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(new Date());
        this.key = System.currentTimeMillis();
    }

    public long getKey() {
        return key;
    }
}
