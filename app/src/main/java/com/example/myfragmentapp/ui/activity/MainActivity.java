package com.example.myfragmentapp.ui.activity;


import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;


import android.net.Uri;
import android.os.Bundle;

import com.example.myfragmentapp.model.Fishing;
import com.example.myfragmentapp.ui.GetStartFragmentImage;
import com.example.myfragmentapp.ui.fragment.Aut_Fragment;
import com.example.myfragmentapp.ui.fragment.BlankFragment;
import com.example.myfragmentapp.ui.fragment.FirstWindow;
import com.example.myfragmentapp.ui.fragment.FragmentNetworkService;
import com.example.myfragmentapp.ui.fragment.FragmentStart;
import com.example.myfragmentapp.R;

import com.example.myfragmentapp.ui.fragment.LureCollection;
import com.example.myfragmentapp.ui.fragment.dummy.DummyContent;

public class MainActivity extends AppCompatActivity implements FragmentStart.StfrtFragment2, GetStartFragmentImage, Aut_Fragment.AddStartFragment,
        FirstWindow.OnFragmentInteractionListener {

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
                .replace(R.id.fl_container, BlankFragment.newInstance(fishing, "vvv"), "Panel4").addToBackStack("cansel")
                .commit();
    }

    @Override
    public void addFragment() {
        getSupportFragmentManager().beginTransaction().setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                .replace(R.id.fl_container, FirstWindow.newInstance(),"Panel2")
                .commit();

    }



    @Override
    public void onFragmentInteraction() {
        getSupportFragmentManager().beginTransaction().setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                .replace(R.id.fl_container, FragmentStart.newInstans(), "Panel3").addToBackStack("Cancel")
                .commit();

    }

    @Override
    public void onFragmentInteractionLure() {
        getSupportFragmentManager().beginTransaction().setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                .replace(R.id.fl_container, LureCollection.newInstance(), "Panel4").addToBackStack("Cancel")
                .commit();

    }


}
