package com.example.myfragmentapp.network.responce;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class MultiPriceModel {
    @SerializedName("BTC")
    @Expose
    public BTC btc;
    @SerializedName("ETH")
    @Expose
    public ETH eth;
    public class BTC{
        @SerializedName("USD")
        @Expose
        public float USD;
        @SerializedName("EUR")
        @Expose
        public float EUR;
    }
    public class ETH{

        @SerializedName("USD")
        @Expose
        public float USD;
        @SerializedName("EUR")
        @Expose
        public float EUR;
    }

}
