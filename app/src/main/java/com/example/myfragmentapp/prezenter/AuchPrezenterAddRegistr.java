package com.example.myfragmentapp.prezenter;

import com.example.myfragmentapp.app.App;
import com.example.myfragmentapp.ui.fragment.interfaces.AutchInterface;

import moxy.InjectViewState;
import moxy.MvpPresenter;
import moxy.presenter.InjectPresenter;

@InjectViewState
public class AuchPrezenterAddRegistr extends MvpPresenter<AutchInterface> {


    public AuchPrezenterAddRegistr() {

    }

    public void startEnter(String email, String password) {
        if (email.length() > 0 && password.length() > 0) {
            getViewState().schowProgressBar();
           // App.getPreferences().putString(email,password);
        } else {
            getViewState().schowMessageError("Заповніть всі поля");
        }

    }

}
