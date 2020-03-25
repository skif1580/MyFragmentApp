package com.example.myfragmentapp.network;


import com.example.myfragmentapp.network.responce.ModelSymbolPriсe;
import com.example.myfragmentapp.network.responce.MultiPriceModel;
import com.example.myfragmentapp.network.responce.PriceMultiFull;

import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface JSONPlaceHolderApi {
    @GET("price")
    Single<ModelSymbolPriсe> getSymbolPrice(@Query("fsym")String [] namecrypto, @Query("tsyms") String[] namefiat, @Query("api_key") String key);

    @GET("pricemulti")
    Single<MultiPriceModel> getPriceMulti(@Query("fsyms") String[] fsyms, @Query("tsyms") String []tsyms, @Query("api_key")String key);

    @GET("pricemultifull")
    Single<PriceMultiFull> getFullMultiPrice(@Query("fsyms") String fsyms, @Query("tsyms") String[] tsyms, @Query("api_key") String key );

}

