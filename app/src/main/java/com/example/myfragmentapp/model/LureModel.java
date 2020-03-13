package com.example.myfragmentapp.model;

import com.example.myfragmentapp.ui.TypeLure;
import com.orm.SugarRecord;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class LureModel extends SugarRecord<LureModel>  {
    private String nameModel;
    private String nameProducer;
    private String date;
    private long key;
    private String image;
    private String typeLure;

    public LureModel() {
    }

    public LureModel(String name, TypeLure typeLure) {
        this.date = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(new Date());
        this.nameProducer = name;
        this.typeLure = String.valueOf(typeLure);
    }

    public LureModel(String nameModel, String nameProducer, String image, String typeLure) {
        this.date = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(new Date());
        this.nameModel = nameModel;
        this.nameProducer = nameProducer;
        this.image = image;
        this.typeLure = typeLure;
    }

    public LureModel(String nameModel, String nameProducer, String typeLure) {
        this.date = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(new Date());
        this.nameModel = nameModel;
        this.nameProducer = nameProducer;
        this.typeLure = typeLure;
        this.key = System.currentTimeMillis();
    }

    public String getNameModel() {
        return nameModel;
    }

    public void setNameModel(String nameModel) {
        this.nameModel = nameModel;
    }

    public String getNameProducer() {
        return nameProducer;
    }

    public void setNameProducer(String nameProducer) {
        this.nameProducer = nameProducer;
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
