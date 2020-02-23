package com.example.myfragmentapp.ui.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.myfragmentapp.R;
import com.example.myfragmentapp.model.Fishing;
import com.example.myfragmentapp.prezenter.DetailFischingPrezenter;
import com.example.myfragmentapp.ui.fragment.interfaces.DetailFischingView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import moxy.MvpAppCompatFragment;
import moxy.presenter.InjectPresenter;

public class DetailOfFisching extends MvpAppCompatFragment implements DetailFischingView {



    @InjectPresenter
    DetailFischingPrezenter prezenter;

    public static DetailOfFisching newInstance(Fishing fishing){
        DetailOfFisching fragment=new DetailOfFisching();
        Bundle args=new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.detail_of_fisching_fragment,null,false);
        return view;
    }


}
