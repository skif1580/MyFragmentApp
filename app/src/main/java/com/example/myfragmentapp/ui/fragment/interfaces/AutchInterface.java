package com.example.myfragmentapp.ui.fragment.interfaces;


import moxy.MvpView;
import moxy.viewstate.strategy.AddToEndSingleStrategy;
import moxy.viewstate.strategy.StateStrategyType;

@StateStrategyType(AddToEndSingleStrategy.class)
public interface AutchInterface extends MvpView {
    void schowMessageError(String message);
    void schowProgressBar();
    void stopSchowProgressBar();
    void schowErrorEnterText();
}
