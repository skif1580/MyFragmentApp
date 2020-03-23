package com.example.myfragmentapp.db;

import com.example.myfragmentapp.model.LureModel;

import java.util.List;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.OnLifecycleEvent;

public class MyConectorDB implements LifecycleObserver {
    MutableLiveData<List<LureModel>> liveData = new MutableLiveData<>();
    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    public void connect() {
        List<LureModel> lureModels;
        lureModels = RepozitoriDB.getListLureModel();
        liveData.postValue(lureModels);


    }

    public MutableLiveData<List<LureModel>> getLiveData() {
        return liveData;
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public void disconnect() {

    }
}
