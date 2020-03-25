package com.example.myfragmentapp.db;

import com.example.myfragmentapp.model.Fishing;
import com.example.myfragmentapp.model.LureModel;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Single;

public interface RxRepositiriDb {
    Observable<List<Fishing>> getFisingList();
    Observable<Fishing> getItemFishing(long key);
    Single<Fishing> getItemFishingInDB(long key);
    Observable<List<LureModel>> getListLureModelDB();
}
