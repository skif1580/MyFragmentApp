package com.example.myfragmentapp.ui.fragment.interfaces;

import moxy.MvpView;
import moxy.viewstate.strategy.SingleStateStrategy;
import moxy.viewstate.strategy.StateStrategyType;

public interface LureView extends MvpView {
     @StateStrategyType(SingleStateStrategy.class)
     void schowMessage();
}
