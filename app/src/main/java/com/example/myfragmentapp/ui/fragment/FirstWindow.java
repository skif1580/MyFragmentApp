package com.example.myfragmentapp.ui.fragment;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import com.example.myfragmentapp.R;
import com.example.myfragmentapp.prezenter.FirstWindowPrezenter;
import com.example.myfragmentapp.ui.fragment.interfaces.FirstView;

import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import moxy.MvpAppCompatFragment;
import moxy.presenter.InjectPresenter;


public class FirstWindow extends MvpAppCompatFragment implements FirstView, View.OnClickListener {
    private OnFragmentInteractionListener mListener;
    private Button btFisching, btLure;
    @InjectPresenter
    FirstWindowPrezenter firstWindowPrezenter;


    public FirstWindow() {

    }

    public static FirstWindow newInstance() {
        FirstWindow fragment = new FirstWindow();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_first_window, container, false);
        btFisching = view.findViewById(R.id.bt_fisching);
        btLure = view.findViewById(R.id.bt_lure);
        btFisching.setOnClickListener(this);
        btLure.setOnClickListener(this);



        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bt_fisching:
                if (mListener != null) {
                    mListener.onFragmentInteraction();
                }
                break;
            case R.id.bt_lure:
                if (mListener!=null){
                    mListener.onFragmentInteractionLure();
                }
                break;
        }


    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }


    public interface OnFragmentInteractionListener {
        void onFragmentInteraction();
        void onFragmentInteractionLure();
    }
}
