package com.example.myfragmentapp.ui.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myfragmentapp.R;
import com.example.myfragmentapp.prezenter.AuchPrezenterAddRegistr;
import com.example.myfragmentapp.ui.fragment.interfaces.AutchInterface;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import moxy.MvpAppCompatFragment;
import moxy.presenter.InjectPresenter;


public class Aut_Fragment extends MvpAppCompatFragment implements AutchInterface {
    private EditText tvEmail, tvPassword;
    private Button btEnter;
    private TextView tvRegistr;
    private ProgressBar progressBar;
    public AddStartFragment startFragment;




    @InjectPresenter(presenterId = "", tag = "")
    AuchPrezenterAddRegistr prezenterAddRegistr;
    private String APP_PREFERENCES="myPreferences";

    public static Aut_Fragment newInstance() {
        Aut_Fragment fragment = new Aut_Fragment();
        return fragment;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        startFragment = (AddStartFragment) context;
    }



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.autoris_fragment, null, false);
        btEnter = view.findViewById(R.id.bt_enter);
        tvEmail = view.findViewById(R.id.et_email);
        tvPassword = view.findViewById(R.id.et_password);
        tvRegistr = view.findViewById(R.id.tv_registr);
        progressBar = view.findViewById(R.id.progress_bar);
        progressBar.setVisibility(View.GONE);

        return view;
    }



    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        btEnter.setOnClickListener(v ->
                prezenterAddRegistr.startEnter(tvRegistr.getText().toString(), tvPassword.getText().toString()));


    }


    @Override
    public void schowMessageError(String message) {
        Toast.makeText(getActivity(), message, Toast.LENGTH_SHORT).show();
        tvRegistr.setText(message);
    }

    @Override
    public void schowProgressBar() {
        if (startFragment != null) {
            startFragment.addFragment();
            progressBar.setVisibility(View.VISIBLE);

        }

    }

    @Override
    public void stopSchowProgressBar() {

    }

    @Override
    public void schowErrorEnterText() {


    }

    public interface AddStartFragment {
        void addFragment();
    }
}
