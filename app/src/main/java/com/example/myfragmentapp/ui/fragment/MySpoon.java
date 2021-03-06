package com.example.myfragmentapp.ui.fragment;

import android.app.AlertDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.myfragmentapp.R;
import com.example.myfragmentapp.adapter.LureAdapter;
import com.example.myfragmentapp.db.RepozitoriDB;
import com.example.myfragmentapp.model.LureModel;
import com.example.myfragmentapp.ui.TypeLure;


import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import moxy.MvpAppCompatFragment;

public class MySpoon extends MvpAppCompatFragment {
    private RecyclerView recyclerView;
    private LureAdapter adapter;
    private LureModel lureModel;
    private List<LureModel> list;

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
        List<LureModel> listLure;
        listLure = RepozitoriDB.getListLureModel();
        list = getListLureModdel(listLure);
        adapter = new LureAdapter(list,getActivity());
        recyclerView = view.findViewById(R.id.rv_list_spoon);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(adapter);
        return view;
    }

    private List<LureModel> getListLureModdel(List<LureModel> list) {
        List<LureModel> lureModels = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            lureModel = list.get(i);
            if (lureModel.getTypeLure().equals("SPOON")) {
                lureModels.add(lureModel);
            } else {

            }
        }
        return lureModels;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
       final LureAdapter.OnClickListenerItem clickListenerItem =new LureAdapter.OnClickListenerItem() {
           @Override
           public void itemClickListener(LureModel lureModel) {
               AlertDialog.Builder dialog = new AlertDialog.Builder(getActivity());
               dialog.setTitle("Видалити приманку з колекції")
                       .setPositiveButton("Видалити", (dialog1, which) -> {
                           list.remove(lureModel);
                           RepozitoriDB.deletLureModel(lureModel);
                          adapter. setList(list);
                       })
                       .setNegativeButton("Відмінна", (dialog13, which) -> {

                       });
               dialog.show();

           }

           @Override
           public void clickImageListener(LureModel lureModel) {

           }
       };
       adapter.setOnClickImage(clickListenerItem);
    }
}
