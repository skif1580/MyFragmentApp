package com.example.myfragmentapp.network;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class NetworckClass {
    private static NetworckClass networckClass;
    private Retrofit retrofit;
    private static final String BASE_URL = "https://min-api.cryptocompare.com/data/";


    public NetworckClass() {
        System.out.println("dev");
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient.Builder client = new OkHttpClient.Builder().addInterceptor(loggingInterceptor);

        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .client(client.build())
                .build();
    }

    public static NetworckClass getInstance() {
        if (networckClass == null) {
            networckClass = new NetworckClass();
        }

        return networckClass;
    }

    public JSONPlaceHolderApi getJsonApi() {
        return retrofit.create(JSONPlaceHolderApi.class);
    }

}
