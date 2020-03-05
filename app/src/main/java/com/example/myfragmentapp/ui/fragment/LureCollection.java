package com.example.myfragmentapp.ui.fragment;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toolbar;

import com.example.myfragmentapp.R;
import com.example.myfragmentapp.adapter.ViewPageAdapter;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;
import moxy.MvpAppCompatFragment;

public class LureCollection extends MvpAppCompatFragment {
    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager2 viewPager;

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
        viewPager = view.findViewById(R.id.lure_pager);
        ViewPageAdapter adapter = new ViewPageAdapter(getActivity());
        tabLayout = view.findViewById(R.id.lure_tab_layout);
        seturViewPager(viewPager,adapter,tabLayout);
        return view;
    }

    private void seturViewPager(ViewPager2 viewPager,ViewPageAdapter adapter,TabLayout tabLayout) {
         adapter.addfragment(MyVobblerList.newInstance());
         adapter.addfragment(MySilikon.newInstance());
         adapter.addfragment(MySpoon.newInstance());
         viewPager.setAdapter(adapter);
         new TabLayoutMediator(tabLayout, viewPager, new TabLayoutMediator.TabConfigurationStrategy() {
             @Override
             public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {

                 tab.setText("Приманки "+(position+1));

             }
         }).attach();
    }

    @SuppressLint("ResourceAsColor")
    private void initTollbar(View view) {
        toolbar = view.findViewById(R.id.toolbar_lure);
        toolbar.setTitle("Мої приманки");
        toolbar.setTitleTextColor(R.color.colorToolbarText);
        toolbar.inflateMenu(R.menu.luremenu);
        toolbar.setOnMenuItemClickListener(item -> {
            switch (item.getItemId()){
                case R.id.mn_add_lure:
                    break;
            }
            return true;
        });

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }
}
