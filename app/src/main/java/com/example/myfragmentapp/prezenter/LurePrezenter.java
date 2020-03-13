package com.example.myfragmentapp.prezenter;

import com.example.myfragmentapp.db.RepozitoriDB;
import com.example.myfragmentapp.model.LureModel;
import com.example.myfragmentapp.ui.fragment.interfaces.LureView;

import moxy.InjectViewState;
import moxy.MvpPresenter;

@InjectViewState
public class LurePrezenter extends MvpPresenter<LureView> {
    private LureModel lureModel;

    public LurePrezenter() {
    }

    public void addNewLureModel(String nameProduser, String nameModelLure, String type) {
        lureModel = new LureModel(nameModelLure, nameProduser, type);
        RepozitoriDB.addLureModel(lureModel);
        getViewState().schowMessage();



    }
}
