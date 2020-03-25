package com.example.myfragmentapp.ui.fragment;

import android.location.LocationManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


import com.example.myfragmentapp.R;
import com.example.myfragmentapp.network.ControlerApi;
import com.example.myfragmentapp.network.responce.PriceMultiFull;
import com.example.myfragmentapp.repository.Repository;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import moxy.MvpAppCompatFragment;


public class FragmentNetworkService extends MvpAppCompatFragment implements ControlerApi.CallBeck {
    LocationManager locationManager;
    private Button button;
    private TextView textView;
    private long time = System.currentTimeMillis();
    private ControlerApi api;
    private Repository repository;


    public static Fragment newInstans() {
        FragmentNetworkService fragmentNetworkServis = new FragmentNetworkService();
        return fragmentNetworkServis;
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_network_servis, null, false);
        textView=view.findViewById(R.id.tv_network);
        button = view.findViewById(R.id.bt_net);
        return view;

    }

    @Override
    public void onViewCreated(@NonNull final View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        api = new ControlerApi();
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                String cripto = "BTC";
                String[] fiat = {"USD", "EUR"};
                api.registerCallBack(FragmentNetworkService.this);
                api.getPriceMultiFull(cripto, fiat);


                //  api.getPrice(cripto,fiat)
                //        .subscribe(new Consumer<ModelSymbolPriсe>() {
                //  @Override
                //public void accept(ModelSymbolPriсe modelSymbolPriсe) {
                //   textView.append(modelSymbolPriсe.USD + "\n");
                //  }
                // });

            }
        });


    }


    @Override
    public void lisnerCallback(PriceMultiFull multiFull) {
            this.textView.setText(multiFull.DISPLAY.BTC.USD.CHANGE24HOUR);

    }

    @Override
    public void lisnerErrorCallback(Throwable e) {
        Toast.makeText(getActivity(),e.getMessage()+"error",Toast.LENGTH_LONG).show();
    }
}
