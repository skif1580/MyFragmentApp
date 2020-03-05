package com.example.myfragmentapp.ui.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.myfragmentapp.R;
import com.example.myfragmentapp.adapter.LureAdapter;
import com.example.myfragmentapp.model.LureModel;
import com.example.myfragmentapp.ui.TypeLure;


import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import moxy.MvpAppCompatFragment;

public class MySpoon extends MvpAppCompatFragment   {
    private RecyclerView recyclerView;
    private LureAdapter adapter;

    public static MySpoon newInstance() {

        Bundle args = new Bundle();
        MySpoon fragment = new MySpoon();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.my_spoon_fragment, container, false);
        List<LureModel>list=new ArrayList<>();
        list.add(new LureModel("Meps", TypeLure.SPOON));
        list.add(new LureModel("Condor", TypeLure.SPOON));
        list.add(new LureModel("Ponton 21", TypeLure.SPOON));
        list.add(new LureModel("Straick", TypeLure.SPOON));
        adapter=new LureAdapter(list);
        recyclerView=view.findViewById(R.id.rv_list_spoon);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(adapter);
        return view;
    }
}
