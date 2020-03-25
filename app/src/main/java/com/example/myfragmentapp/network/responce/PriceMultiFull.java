package com.example.myfragmentapp.network.responce;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PriceMultiFull {
    @SerializedName("RAW")
    @Expose
    public RAW RAW;
    @SerializedName("DISPLAY")
    @Expose
    public DISPLAY DISPLAY;

    public class RAW {

        @SerializedName("BTC")
        @Expose
        public BTC BTC;
        public class BTC {

            @SerializedName("USD")
            @Expose
            public USD USD;
            @SerializedName("EUR")
            @Expose
            public EUR EUR;
            public class USD {
                @SerializedName("TYPE")
                @Expose
                public String TYPE;
                @SerializedName("MARKET")
                @Expose
                public String MARKET;
                @SerializedName("FROMSYMBOL")
                @Expose
                public String FROMSYMBOL;
                @SerializedName("TOSYMBOL")
                @Expose
                public String TOSYMBOL;
                @SerializedName("FLAGS")
                @Expose
                public String FLAGS;
                @SerializedName("PRICE")
                @Expose
                public float PRICE;
                @SerializedName("LASTUPDATE")
                @Expose
                public int LASTUPDATE;
                @SerializedName("MEDIAN")
                @Expose
                public float MEDIAN;
                @SerializedName("LASTVOLUME")
                @Expose
                public float LASTVOLUME;
                @SerializedName("LASTVOLUMETO")
                @Expose
                public float LASTVOLUMETO;
                @SerializedName("LASTTRADEID")
                @Expose
                public String LASTTRADEID;
                @SerializedName("VOLUMEDAY")
                @Expose
                public float VOLUMEDAY;
                @SerializedName("VOLUMEDAYTO")
                @Expose
                public float VOLUMEDAYTO;
                @SerializedName("VOLUME24HOUR")
                @Expose
                public float VOLUME24HOUR;
                @SerializedName("VOLUME24HOURTO")
                @Expose
                public float VOLUME24HOURTO;
                @SerializedName("OPENDAY")
                @Expose
                public float OPENDAY;
                @SerializedName("HIGHDAY")
                @Expose
                public float HIGHDAY;
                @SerializedName("LOWDAY")
                @Expose
                public float LOWDAY;
                @SerializedName("OPEN24HOUR")
                @Expose
                public float OPEN24HOUR;
                @SerializedName("HIGH24HOUR")
                @Expose
                public float HIGH24HOUR;
                @SerializedName("LOW24HOUR")
                @Expose
                public float LOW24HOUR;
                @SerializedName("LASTMARKET")
                @Expose
                public String LASTMARKET;
                @SerializedName("VOLUMEHOUR")
                @Expose
                public float VOLUMEHOUR;
                @SerializedName("VOLUMEHOURTO")
                @Expose
                public float VOLUMEHOURTO;
                @SerializedName("OPENHOUR")
                @Expose
                public float OPENHOUR;
                @SerializedName("HIGHHOUR")
                @Expose
                public float HIGHHOUR;
                @SerializedName("LOWHOUR")
                @Expose
                public float LOWHOUR;
                @SerializedName("TOPTIERVOLUME24HOUR")
                @Expose
                public float TOPTIERVOLUME24HOUR;
                @SerializedName("TOPTIERVOLUME24HOURTO")
                @Expose
                public float TOPTIERVOLUME24HOURTO;
                @SerializedName("CHANGE24HOUR")
                @Expose
                public float CHANGE24HOUR;
                @SerializedName("CHANGEPCT24HOUR")
                @Expose
                public float CHANGEPCT24HOUR;
                @SerializedName("CHANGEDAY")
                @Expose
                public float CHANGEDAY;
                @SerializedName("CHANGEPCTDAY")
                @Expose
                public float CHANGEPCTDAY;
                @SerializedName("CHANGEHOUR")
                @Expose
                public float CHANGEHOUR;
                @SerializedName("CHANGEPCTHOUR")
                @Expose
                public float CHANGEPCTHOUR;
                @SerializedName("SUPPLY")
                @Expose
                public int SUPPLY;
                @SerializedName("MKTCAP")
                @Expose
                public float MKTCAP;
                @SerializedName("TOTALVOLUME24H")
                @Expose
                public float TOTALVOLUME24H;
                @SerializedName("TOTALVOLUME24HTO")
                @Expose
                public float TOTALVOLUME24HTO;
                @SerializedName("TOTALTOPTIERVOLUME24H")
                @Expose
                public float TOTALTOPTIERVOLUME24H;
                @SerializedName("TOTALTOPTIERVOLUME24HTO")
                @Expose
                public float TOTALTOPTIERVOLUME24HTO;
                @SerializedName("IMAGEURL")
                @Expose
                public String IMAGEURL;
                @SerializedName("CONVERSIONTYPE")
                @Expose
                public String CONVERSIONTYPE;
                @SerializedName("CONVERSIONSYMBOL")
                @Expose
                public String CONVERSIONSYMBOL;

            }
            public class EUR {

                @SerializedName("TYPE")
                @Expose
                public String TYPE;
                @SerializedName("MARKET")
                @Expose
                public String MARKET;
                @SerializedName("FROMSYMBOL")
                @Expose
                public String FROMSYMBOL;
                @SerializedName("TOSYMBOL")
                @Expose
                public String TOSYMBOL;
                @SerializedName("FLAGS")
                @Expose
                public String FLAGS;
                @SerializedName("PRICE")
                @Expose
                public float PRICE;
                @SerializedName("LASTUPDATE")
                @Expose
                public int LASTUPDATE;
                @SerializedName("MEDIAN")
                @Expose
                public float MEDIAN;
                @SerializedName("LASTVOLUME")
                @Expose
                public float LASTVOLUME;
                @SerializedName("LASTVOLUMETO")
                @Expose
                public float LASTVOLUMETO;
                @SerializedName("LASTTRADEID")
                @Expose
                public String LASTTRADEID;
                @SerializedName("VOLUMEDAY")
                @Expose
                public float VOLUMEDAY;
                @SerializedName("VOLUMEDAYTO")
                @Expose
                public float VOLUMEDAYTO;
                @SerializedName("VOLUME24HOUR")
                @Expose
                public float VOLUME24HOUR;
                @SerializedName("VOLUME24HOURTO")
                @Expose
                public float VOLUME24HOURTO;
                @SerializedName("OPENDAY")
                @Expose
                public float OPENDAY;
                @SerializedName("HIGHDAY")
                @Expose
                public float HIGHDAY;
                @SerializedName("LOWDAY")
                @Expose
                public float LOWDAY;
                @SerializedName("OPEN24HOUR")
                @Expose
                public float OPEN24HOUR;
                @SerializedName("HIGH24HOUR")
                @Expose
                public float HIGH24HOUR;
                @SerializedName("LOW24HOUR")
                @Expose
                public float LOW24HOUR;
                @SerializedName("LASTMARKET")
                @Expose
                public String LASTMARKET;
                @SerializedName("VOLUMEHOUR")
                @Expose
                public float VOLUMEHOUR;
                @SerializedName("VOLUMEHOURTO")
                @Expose
                public float VOLUMEHOURTO;
                @SerializedName("OPENHOUR")
                @Expose
                public float OPENHOUR;
                @SerializedName("HIGHHOUR")
                @Expose
                public float HIGHHOUR;
                @SerializedName("LOWHOUR")
                @Expose
                public float LOWHOUR;
                @SerializedName("TOPTIERVOLUME24HOUR")
                @Expose
                public float TOPTIERVOLUME24HOUR;
                @SerializedName("TOPTIERVOLUME24HOURTO")
                @Expose
                public float TOPTIERVOLUME24HOURTO;
                @SerializedName("CHANGE24HOUR")
                @Expose
                public float CHANGE24HOUR;
                @SerializedName("CHANGEPCT24HOUR")
                @Expose
                public float CHANGEPCT24HOUR;
                @SerializedName("CHANGEDAY")
                @Expose
                public float CHANGEDAY;
                @SerializedName("CHANGEPCTDAY")
                @Expose
                public float CHANGEPCTDAY;
                @SerializedName("CHANGEHOUR")
                @Expose
                public float CHANGEHOUR;
                @SerializedName("CHANGEPCTHOUR")
                @Expose
                public float CHANGEPCTHOUR;
                @SerializedName("SUPPLY")
                @Expose
                public int SUPPLY;
                @SerializedName("MKTCAP")
                @Expose
                public float MKTCAP;
                @SerializedName("TOTALVOLUME24H")
                @Expose
                public float TOTALVOLUME24H;
                @SerializedName("TOTALVOLUME24HTO")
                @Expose
                public float TOTALVOLUME24HTO;
                @SerializedName("TOTALTOPTIERVOLUME24H")
                @Expose
                public float TOTALTOPTIERVOLUME24H;
                @SerializedName("TOTALTOPTIERVOLUME24HTO")
                @Expose
                public float TOTALTOPTIERVOLUME24HTO;
                @SerializedName("IMAGEURL")
                @Expose
                public String IMAGEURL;
                @SerializedName("CONVERSIONTYPE")
                @Expose
                public String CONVERSIONTYPE;
                @SerializedName("CONVERSIONSYMBOL")
                @Expose
                public String CONVERSIONSYMBOL;

            }

        }

    }
    public class DISPLAY {

        @SerializedName("BTC")
        @Expose
        public BTC BTC;
        public class BTC {

            @SerializedName("USD")
            @Expose
            public USD USD;
            @SerializedName("EUR")
            @Expose
            public EUR EUR;

            public class USD {

                @SerializedName("FROMSYMBOL")
                @Expose
                public String FROMSYMBOL;
                @SerializedName("TOSYMBOL")
                @Expose
                public String TOSYMBOL;
                @SerializedName("MARKET")
                @Expose
                public String MARKET;
                @SerializedName("PRICE")
                @Expose
                public String PRICE;
                @SerializedName("LASTUPDATE")
                @Expose
                public String LASTUPDATE;
                @SerializedName("LASTVOLUME")
                @Expose
                public String LASTVOLUME;
                @SerializedName("LASTVOLUMETO")
                @Expose
                public String LASTVOLUMETO;
                @SerializedName("LASTTRADEID")
                @Expose
                public String LASTTRADEID;
                @SerializedName("VOLUMEDAY")
                @Expose
                public String VOLUMEDAY;
                @SerializedName("VOLUMEDAYTO")
                @Expose
                public String VOLUMEDAYTO;
                @SerializedName("VOLUME24HOUR")
                @Expose
                public String VOLUME24HOUR;
                @SerializedName("VOLUME24HOURTO")
                @Expose
                public String VOLUME24HOURTO;
                @SerializedName("OPENDAY")
                @Expose
                public String OPENDAY;
                @SerializedName("HIGHDAY")
                @Expose
                public String HIGHDAY;
                @SerializedName("LOWDAY")
                @Expose
                public String LOWDAY;
                @SerializedName("OPEN24HOUR")
                @Expose
                public String OPEN24HOUR;
                @SerializedName("HIGH24HOUR")
                @Expose
                public String HIGH24HOUR;
                @SerializedName("LOW24HOUR")
                @Expose
                public String LOW24HOUR;
                @SerializedName("LASTMARKET")
                @Expose
                public String LASTMARKET;
                @SerializedName("VOLUMEHOUR")
                @Expose
                public String VOLUMEHOUR;
                @SerializedName("VOLUMEHOURTO")
                @Expose
                public String VOLUMEHOURTO;
                @SerializedName("OPENHOUR")
                @Expose
                public String OPENHOUR;
                @SerializedName("HIGHHOUR")
                @Expose
                public String HIGHHOUR;
                @SerializedName("LOWHOUR")
                @Expose
                public String LOWHOUR;
                @SerializedName("TOPTIERVOLUME24HOUR")
                @Expose
                public String TOPTIERVOLUME24HOUR;
                @SerializedName("TOPTIERVOLUME24HOURTO")
                @Expose
                public String TOPTIERVOLUME24HOURTO;
                @SerializedName("CHANGE24HOUR")
                @Expose
                public String CHANGE24HOUR;
                @SerializedName("CHANGEPCT24HOUR")
                @Expose
                public String CHANGEPCT24HOUR;
                @SerializedName("CHANGEDAY")
                @Expose
                public String CHANGEDAY;
                @SerializedName("CHANGEPCTDAY")
                @Expose
                public String CHANGEPCTDAY;
                @SerializedName("CHANGEHOUR")
                @Expose
                public String CHANGEHOUR;
                @SerializedName("CHANGEPCTHOUR")
                @Expose
                public String CHANGEPCTHOUR;
                @SerializedName("SUPPLY")
                @Expose
                public String SUPPLY;
                @SerializedName("MKTCAP")
                @Expose
                public String MKTCAP;
                @SerializedName("TOTALVOLUME24H")
                @Expose
                public String TOTALVOLUME24H;
                @SerializedName("TOTALVOLUME24HTO")
                @Expose
                public String TOTALVOLUME24HTO;
                @SerializedName("TOTALTOPTIERVOLUME24H")
                @Expose
                public String TOTALTOPTIERVOLUME24H;
                @SerializedName("TOTALTOPTIERVOLUME24HTO")
                @Expose
                public String TOTALTOPTIERVOLUME24HTO;
                @SerializedName("IMAGEURL")
                @Expose
                public String IMAGEURL;
                @SerializedName("CONVERSIONTYPE")
                @Expose
                public String CONVERSIONTYPE;
                @SerializedName("CONVERSIONSYMBOL")
                @Expose
                public String CONVERSIONSYMBOL;

            }

            public class EUR {

                @SerializedName("FROMSYMBOL")
                @Expose
                public String FROMSYMBOL;
                @SerializedName("TOSYMBOL")
                @Expose
                public String TOSYMBOL;
                @SerializedName("MARKET")
                @Expose
                public String MARKET;
                @SerializedName("PRICE")
                @Expose
                public String PRICE;
                @SerializedName("LASTUPDATE")
                @Expose
                public String LASTUPDATE;
                @SerializedName("LASTVOLUME")
                @Expose
                public String LASTVOLUME;
                @SerializedName("LASTVOLUMETO")
                @Expose
                public String LASTVOLUMETO;
                @SerializedName("LASTTRADEID")
                @Expose
                public String LASTTRADEID;
                @SerializedName("VOLUMEDAY")
                @Expose
                public String VOLUMEDAY;
                @SerializedName("VOLUMEDAYTO")
                @Expose
                public String VOLUMEDAYTO;
                @SerializedName("VOLUME24HOUR")
                @Expose
                public String VOLUME24HOUR;
                @SerializedName("VOLUME24HOURTO")
                @Expose
                public String VOLUME24HOURTO;
                @SerializedName("OPENDAY")
                @Expose
                public String OPENDAY;
                @SerializedName("HIGHDAY")
                @Expose
                public String HIGHDAY;
                @SerializedName("LOWDAY")
                @Expose
                public String LOWDAY;
                @SerializedName("OPEN24HOUR")
                @Expose
                public String OPEN24HOUR;
                @SerializedName("HIGH24HOUR")
                @Expose
                public String HIGH24HOUR;
                @SerializedName("LOW24HOUR")
                @Expose
                public String LOW24HOUR;
                @SerializedName("LASTMARKET")
                @Expose
                public String LASTMARKET;
                @SerializedName("VOLUMEHOUR")
                @Expose
                public String VOLUMEHOUR;
                @SerializedName("VOLUMEHOURTO")
                @Expose
                public String VOLUMEHOURTO;
                @SerializedName("OPENHOUR")
                @Expose
                public String OPENHOUR;
                @SerializedName("HIGHHOUR")
                @Expose
                public String HIGHHOUR;
                @SerializedName("LOWHOUR")
                @Expose
                public String LOWHOUR;
                @SerializedName("TOPTIERVOLUME24HOUR")
                @Expose
                public String TOPTIERVOLUME24HOUR;
                @SerializedName("TOPTIERVOLUME24HOURTO")
                @Expose
                public String TOPTIERVOLUME24HOURTO;
                @SerializedName("CHANGE24HOUR")
                @Expose
                public String CHANGE24HOUR;
                @SerializedName("CHANGEPCT24HOUR")
                @Expose
                public String CHANGEPCT24HOUR;
                @SerializedName("CHANGEDAY")
                @Expose
                public String CHANGEDAY;
                @SerializedName("CHANGEPCTDAY")
                @Expose
                public String CHANGEPCTDAY;
                @SerializedName("CHANGEHOUR")
                @Expose
                public String CHANGEHOUR;
                @SerializedName("CHANGEPCTHOUR")
                @Expose
                public String CHANGEPCTHOUR;
                @SerializedName("SUPPLY")
                @Expose
                public String SUPPLY;
                @SerializedName("MKTCAP")
                @Expose
                public String MKTCAP;
                @SerializedName("TOTALVOLUME24H")
                @Expose
                public String TOTALVOLUME24H;
                @SerializedName("TOTALVOLUME24HTO")
                @Expose
                public String TOTALVOLUME24HTO;
                @SerializedName("TOTALTOPTIERVOLUME24H")
                @Expose
                public String TOTALTOPTIERVOLUME24H;
                @SerializedName("TOTALTOPTIERVOLUME24HTO")
                @Expose
                public String TOTALTOPTIERVOLUME24HTO;
                @SerializedName("IMAGEURL")
                @Expose
                public String IMAGEURL;
                @SerializedName("CONVERSIONTYPE")
                @Expose
                public String CONVERSIONTYPE;
                @SerializedName("CONVERSIONSYMBOL")
                @Expose
                public String CONVERSIONSYMBOL;

            }
        }

    }
}
