package com.example.myfragmentapp.db;

import com.example.myfragmentapp.model.Fishing;

import java.util.List;


public class RepozitoriDB {

    public static Fishing getFishing(Long key) {
        Fishing fishing1 = Fishing.findById(Fishing.class, key);
        return fishing1;
    }

    public static void addFIshingDB(Fishing fishing) {
        fishing.save();
    }

    public static void deleteFishing(Fishing fishing) {
        fishing.delete();

    }
    public  static List<Fishing> getListFishing(){
        List <Fishing>list=Fishing.listAll(Fishing.class);
        return list;
    }

    public static void deleteFishingList(List<Fishing> list) {
        Fishing.deleteAll(Fishing.class);

    }
}
