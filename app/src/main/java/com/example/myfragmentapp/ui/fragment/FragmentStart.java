package com.example.myfragmentapp.ui.fragment;


import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toolbar;

import com.example.myfragmentapp.R;
import com.example.myfragmentapp.adapter.FishAdapter;
import com.example.myfragmentapp.model.Fishing;
import com.example.myfragmentapp.ui.GetStartFragmentImage;
import com.example.myfragmentapp.ui.activity.MainActivity;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


public class FragmentStart extends Fragment {
    private RecyclerView recyclerView;
    private Button button;
    private List<Fishing> list;
    private FishAdapter fishAdapter;
    private Toolbar toolbar;
    private String name;


    public interface StfrtFragment2 {
        void stertFrag(Fishing fishing);
    }

    StfrtFragment2 stfrtFragment2;


    public static FragmentStart newInstans() {
        FragmentStart fragmentStart = new FragmentStart();
        return fragmentStart;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            stfrtFragment2 = (StfrtFragment2) context;
        } catch (RuntimeException e) {

        }
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable final Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_start_layout, container, false);
        button = view.findViewById(R.id.bt_frg1);
        list = Fishing.listAll(Fishing.class);
        fishAdapter = new FishAdapter(list);
        toolbar = view.findViewById(R.id.toolbar);
        toolbar.setTitle("Записник рибака");
        toolbar.inflateMenu(R.menu.mymenu);
        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.mn_add:
                        addDialogShow(fishAdapter);
                        break;
                    case R.id.mn_galerri:
                         deleteAllListFishing(fishAdapter);
                        break;
                    default:
                }
                return true;
            }

        });
        final FishAdapter.StartFragmentImage startFragmentImage = new FishAdapter.StartFragmentImage() {
            @Override
            public void startFragmentImage(Fishing fishing) {
                ((GetStartFragmentImage) getContext()).startImageFragment(fishing);
            }
        };
        recyclerView = view.findViewById(R.id.rv_list);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(fishAdapter);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });
        fishAdapter.setOnClickImage(startFragmentImage);
        return view;
    }

    private void addDialogShow(final FishAdapter adapter) {
        final View view = getLayoutInflater().inflate(R.layout.aler_dialog, null, false);
        AlertDialog.Builder dialog = new AlertDialog.Builder(getActivity());
        dialog.setTitle("Add fishing")
                .setIcon(android.R.drawable.ic_dialog_alert)
                .setView(view)
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        EditText editText = view.findViewById(R.id.et_alert);
                        name = editText.getText().toString();
                        Fishing fishing = new Fishing();
                        fishing.setName(name);
                        list.add(fishing);
                        fishing.save();
                        adapter.notifyDataSetChanged();

                    }
                })
                .setNegativeButton("Cansel", null);

        dialog.show();
        // ((ViewGroup) editText.getParent()).removeView(editText);


    }

    private void deleteAllListFishing(FishAdapter adapter) {
        AlertDialog.Builder dialogDelet = new AlertDialog.Builder(getActivity());
        dialogDelet.setTitle("Delete List ?")
                .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Fishing.deleteAll(Fishing.class);
                        fishAdapter.notifyDataSetChanged();
                    }
                });
        dialogDelet.show();

    }

}
