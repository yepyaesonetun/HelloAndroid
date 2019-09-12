package com.padcmyanmar.padc9.helloandroid;

import android.app.Application;

import com.padcmyanmar.padc9.helloandroid.data.models.EventModelImpl;

public class EventsApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        EventModelImpl.initializeEventModel(getApplicationContext());
    }
}
