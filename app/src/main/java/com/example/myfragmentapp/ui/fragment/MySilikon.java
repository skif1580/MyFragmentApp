package com.example.myfragmentapp.ui.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;

import com.example.myfragmentapp.R;
import com.example.myfragmentapp.adapter.LureAdapter;
import com.example.myfragmentapp.model.LureModel;
import com.example.myfragmentapp.ui.TypeLure;


import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SimpleItemAnimator;
import androidx.transition.Slide;
import moxy.MvpAppCompatFragment;

public class MySilikon extends MvpAppCompatFragment {
    private RecyclerView recyclerView;
    private LureAdapter adapter;

    public static MySilikon newInstance() {
        Bundle args = new Bundle();

        MySilikon fragment = new MySilikon();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.my_silikon_fragment, container, false);
        List<LureModel> list = new ArrayList<>();
        list.add(new LureModel("Ponton 21", TypeLure.SILIKON));
        list.add(new LureModel("Daiwa", TypeLure.SILIKON));
        list.add(new LureModel("MEREDITH ", TypeLure.SILIKON));
        list.add(new LureModel("Kosadaka", TypeLure.SILIKON));
        adapter = new LureAdapter(list);
        recyclerView = view.findViewById(R.id.rv_list_silikon);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(adapter);
       recyclerView.setItemAnimator(new DefaultItemAnimator());
        return view;
    }
}
