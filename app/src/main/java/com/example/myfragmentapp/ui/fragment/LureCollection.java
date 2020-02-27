package com.example.myfragmentapp.ui.fragment;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toolbar;

import com.example.myfragmentapp.R;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import moxy.MvpAppCompatFragment;

public class LureCollection extends MvpAppCompatFragment {
private Toolbar toolbar;

    public static LureCollection newInstance() {
        Bundle args = new Bundle();
        LureCollection fragment = new LureCollection();
        fragment.setArguments(args);
        return fragment;
    }
    
    
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_lure_collection, container, false);
        initTollbar(view);
        return view;
    }

    @SuppressLint("ResourceAsColor")
    private void initTollbar(View view) {
        toolbar=view.findViewById(R.id.toolbar_lure);
        toolbar.setTitle("Мої приманки");
        toolbar.setTitleTextColor(R.color.colorToolbarText);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }
}
