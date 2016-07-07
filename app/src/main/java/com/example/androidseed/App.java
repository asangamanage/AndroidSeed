package com.example.androidseed;

import android.app.Application;

import com.facebook.stetho.Stetho;

/**
 * Created by asangamanage on 7/07/2016.
 */
public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Stetho.initializeWithDefaults(this);
    }
}
