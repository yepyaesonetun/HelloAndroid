package com.padcmyanmar.padc9.helloandroid.data.models;

import android.content.Context;

import com.padcmyanmar.padc9.helloandroid.network.dataagents.EventDataAgent;
import com.padcmyanmar.padc9.helloandroid.network.dataagents.HttpUrlConnectionDataAgentImpl;
import com.padcmyanmar.padc9.helloandroid.network.dataagents.OkHttpDataAgentImpl;
import com.padcmyanmar.padc9.helloandroid.network.dataagents.RetrofitDataAgentImpl;
import com.padcmyanmar.padc9.helloandroid.persistence.EventsDatabase;

import retrofit2.Retrofit;

public abstract class BaseModel {

    protected EventDataAgent mDataAgent;
    protected EventsDatabase mDatabase;

    public BaseModel(Context context){
        mDataAgent = RetrofitDataAgentImpl.getObjInstance();
        mDatabase = EventsDatabase.getObjInstance(context);
    }


}
