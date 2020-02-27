package com.example.myfragmentapp.prezenter;

import com.example.myfragmentapp.ui.fragment.interfaces.FirstView;
import moxy.InjectViewState;
import moxy.MvpPresenter;

@InjectViewState
public class FirstWindowPrezenter extends MvpPresenter<FirstView> {


    public FirstWindowPrezenter() {
    }
}
