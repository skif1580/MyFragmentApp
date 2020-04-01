package com.example.myfragmentapp.ui.fragment;

import android.app.AlertDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.myfragmentapp.R;
import com.example.myfragmentapp.adapter.LureAdapter;
import com.example.myfragmentapp.db.MyConectorDB;
import com.example.myfragmentapp.db.RepozitoriDB;
import com.example.myfragmentapp.model.LureModel;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.LiveData;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import moxy.MvpAppCompatFragment;
import retrofit2.http.Header;

public class MyVobblerList extends MvpAppCompatFragment {
    private RecyclerView recyclerView;
    private List<LureModel> list;
    private LureModel lureModel;
    private MyConectorDB conectorDB;
    private LureAdapter adapter;


    public static MyVobblerList newInstance() {
        Bundle args = new Bundle();
        MyVobblerList fragment = new MyVobblerList();
        fragment.setArguments(args);
        return fragment;
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        conectorDB = new MyConectorDB();
        getLifecycle().addObserver(conectorDB);
        LiveData<List<LureModel>> listLiveData = conectorDB.getLiveData();
        listLiveData.observe(getViewLifecycleOwner(),
                lureModels -> Toast.makeText(getActivity(), lureModels.size() + "ok", Toast.LENGTH_SHORT).show());
        View view = inflater.inflate(R.layout.my_vobbler_list_fragment, null, false);
        List<LureModel> lureModelArrayList;
        lureModelArrayList = RepozitoriDB.getListLureModel();
        recyclerView = view.findViewById(R.id.rv_list_vobbler);
        list = getListLureModdel(lureModelArrayList);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        adapter = new LureAdapter(list, getActivity());
        recyclerView.setAdapter(adapter);
        return view;
    }


    private List<LureModel> getListLureModdel(List<LureModel> list) {
        List<LureModel> lureModels = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            lureModel = list.get(i);
            if (lureModel.getTypeLure().equals("VOBBLER")) {
                lureModels.add(lureModel);
            } else {

            }
        }
        return lureModels;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        final LureAdapter.OnClickListenerItem clickListenerItem = new LureAdapter.OnClickListenerItem() {
            @Override
            public void itemClickListener(LureModel lureModel) {
                AlertDialog.Builder dialog = new AlertDialog.Builder(getActivity());
                dialog.setTitle("Видалити приманку з колекції")
                        .setPositiveButton("Видалити", (dialog1, which) -> {
                            list.remove(lureModel);
                            RepozitoriDB.deletLureModel(lureModel);
                            adapter.setList(list);
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
