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
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import moxy.MvpAppCompatFragment;

public class MyVobblerList extends MvpAppCompatFragment  {
    private RecyclerView recyclerView;
    private List<LureModel> list;


    public static MyVobblerList newInstance() {
        Bundle args = new Bundle();
        MyVobblerList fragment = new MyVobblerList();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.my_vobbler_list_fragment, null, false);
        list = new ArrayList<>();
        list.add(new LureModel("OSP",TypeLure.VOBBLER));
        list.add(new LureModel("Daiwa",TypeLure.VOBBLER));
        list.add(new LureModel("Youziri",TypeLure.VOBBLER));
        list.add(new LureModel("Kamatzy",TypeLure.VOBBLER));
        recyclerView = view.findViewById(R.id.rv_list_vobbler);
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 2));
        LureAdapter adapter = new LureAdapter(list);
        recyclerView.setAdapter(adapter);
        return view;
    }
}
