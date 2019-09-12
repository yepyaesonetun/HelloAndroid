package com.padcmyanmar.padc9.helloandroid.network.dataagents;

import com.padcmyanmar.padc9.helloandroid.network.EventsApi;
import com.padcmyanmar.padc9.helloandroid.network.responses.GetEventsResponse;
import com.padcmyanmar.padc9.helloandroid.utils.EventsConstants;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitDataAgentImpl implements EventDataAgent {

    private static RetrofitDataAgentImpl objInstance;

    private EventsApi mEventsApi;

    private RetrofitDataAgentImpl(){
        final OkHttpClient okHttpClient = new OkHttpClient.Builder()
                    .connectTimeout(15, TimeUnit.SECONDS)
                    .readTimeout(60, TimeUnit.SECONDS)
                    .writeTimeout(60, TimeUnit.SECONDS)
                    .build();

        Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(EventsConstants.BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(okHttpClient)
                    .build();

        mEventsApi = retrofit.create(EventsApi.class);

    }

    public static RetrofitDataAgentImpl getObjInstance(){
        if(objInstance == null){
            objInstance = new RetrofitDataAgentImpl();
        }
        return objInstance;
    }

    @Override
    public void getEvents(String accessToken, final GetEventsFromNetworkDelegate delegate) {
        Call<GetEventsResponse> eventsCall = mEventsApi.getAllEvents(accessToken);
        eventsCall.enqueue(new Callback<GetEventsResponse>() {
            @Override
            public void onResponse(Call<GetEventsResponse> call, Response<GetEventsResponse> response) {
                GetEventsResponse getEventsResponse = response.body();
                delegate.onSuccess(getEventsResponse.getEventList());
            }

            @Override
            public void onFailure(Call<GetEventsResponse> call, Throwable t) {
                delegate.onFailure(t.getLocalizedMessage());
            }
        });
    }
}
