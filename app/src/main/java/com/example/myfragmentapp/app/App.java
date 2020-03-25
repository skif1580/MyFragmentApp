package com.example.myfragmentapp.app;

import android.app.Application;
import android.content.Context;

import com.example.myfragmentapp.utils.AppPreferences;

public class App extends Application {
    private static Context context;
    private static AppPreferences preferences;


    @Override
    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();
        preferences= new AppPreferences(getApplicationContext());
    }

    public static Context getAppContext() {
        return context;
    }
    public static AppPreferences getPreferences() {
        return preferences;
    }
}
