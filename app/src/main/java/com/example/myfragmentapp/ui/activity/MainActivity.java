package com.example.myfragmentapp.ui.activity;


import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;


import android.os.Bundle;

import com.example.myfragmentapp.model.Fishing;
import com.example.myfragmentapp.ui.GetStartFragmentImage;
import com.example.myfragmentapp.ui.fragment.Aut_Fragment;
import com.example.myfragmentapp.ui.fragment.BlankFragment;
import com.example.myfragmentapp.ui.fragment.FragmentNetworkService;
import com.example.myfragmentapp.ui.fragment.FragmentStart;
import com.example.myfragmentapp.R;

public class MainActivity extends AppCompatActivity implements FragmentStart.StfrtFragment2, GetStartFragmentImage, Aut_Fragment.AddStartFragment {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().
                    add(R.id.fl_container, Aut_Fragment.newInstance(), "Panel1")
                    .commit();
        }

    }


    @Override
    public void stertFrag() {
        getSupportFragmentManager().beginTransaction().setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                .replace(R.id.fl_container, FragmentNetworkService.newInstans(), "Panel4").addToBackStack("cansel")
                .commit();
    }


    @Override
    public void startImageFragment(Fishing fishing) {
        getSupportFragmentManager().beginTransaction().setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                .replace(R.id.fl_container, BlankFragment.newInstance(fishing, "vvv"), "Panel3").addToBackStack("cansel")
                .commit();
    }

    @Override
    public void addFragment() {
        getSupportFragmentManager().beginTransaction().setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                .replace(R.id.fl_container, FragmentStart.newInstans(), "Panel2")
                .commit();
    }
}
