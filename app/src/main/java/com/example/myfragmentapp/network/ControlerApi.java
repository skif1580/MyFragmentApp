package com.example.myfragmentapp.network;


import com.example.myfragmentapp.network.responce.ModelSymbolPriсe;
import com.example.myfragmentapp.network.responce.MultiPriceModel;
import com.example.myfragmentapp.network.responce.PriceMultiFull;

import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class ControlerApi {
    private String api_key="5cc31edfbb210476bda94c774b408c1fa1e04477e18b94c8ef05615f0b06a040";
    public interface CallBeck{
        void lisnerCallback(PriceMultiFull multiFull);
        void lisnerErrorCallback(Throwable e);
    }
    CallBeck callBeck;

    public void registerCallBack(CallBeck callBeck){
        this.callBeck=callBeck;
    }

    public Single<ModelSymbolPriсe> getPrice(String []cryptoIndex, String[] fiatIndex) {
       return NetworckClass.getInstance().getJsonApi()
               .getSymbolPrice(cryptoIndex, fiatIndex, api_key)
               .subscribeOn(Schedulers.io())
               .observeOn(AndroidSchedulers.mainThread());
   }
public Single<MultiPriceModel> getMultiPrice(String []cryptoIndex,String[] fiatIndex){
       return NetworckClass.getInstance().getJsonApi()
               .getPriceMulti(cryptoIndex,fiatIndex,api_key)
               .subscribeOn(Schedulers.io())
               .observeOn(AndroidSchedulers.mainThread());
}

public void getPriceMultiFull(final String cryptoIndex, String [] fiatIndex){
         NetworckClass.getInstance().getJsonApi().getFullMultiPrice(cryptoIndex,fiatIndex,api_key)
               .subscribeOn(Schedulers.io())
               .observeOn(AndroidSchedulers.mainThread())
               .subscribe(new SingleObserver<PriceMultiFull>() {
                   @Override
                   public void onSubscribe(Disposable d) {

                   }

                   @Override
                   public void onSuccess(PriceMultiFull multiFull) {
                       if (callBeck!=null){
                           callBeck.lisnerCallback(multiFull);
                       }

                   }

                   @Override
                   public void onError(Throwable e) {
                       e.printStackTrace();
                       if (callBeck!=null){
                           callBeck.lisnerErrorCallback(e);
                       }

                   }
               });
}
}
