package com.padcmyanmar.padc9.helloandroid.network.dataagents;

import android.os.AsyncTask;

import com.google.gson.Gson;
import com.padcmyanmar.padc9.helloandroid.network.responses.GetEventsResponse;
import com.padcmyanmar.padc9.helloandroid.utils.EventsConstants;

import java.util.concurrent.TimeUnit;

import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class OkHttpDataAgentImpl implements EventDataAgent {

    private static OkHttpDataAgentImpl objInstance;

    private OkHttpClient mHttpClient;

    private OkHttpDataAgentImpl() {
        mHttpClient = new OkHttpClient.Builder() //1.
                .connectTimeout(15, TimeUnit.SECONDS)
                .writeTimeout(15, TimeUnit.SECONDS)
                .readTimeout(60, TimeUnit.SECONDS)
                .build();
    }

    public static OkHttpDataAgentImpl getInstance() {
        if (objInstance == null) {
            objInstance = new OkHttpDataAgentImpl();
        }
        return objInstance;
    }

    @Override
    public void getEvents(String accessToken, GetEventsFromNetworkDelegate delegate) {
        new GetEventsTask(mHttpClient,accessToken,delegate).execute();
    }

    public static class GetEventsTask extends AsyncTask<Void, Void, GetEventsResponse> {

        private OkHttpClient mOkHttpClient;
        private String mAccessToken;
        private GetEventsFromNetworkDelegate mDelegate;

        public GetEventsTask(OkHttpClient okHttpClient, String accessToken, GetEventsFromNetworkDelegate delegate) {
            mOkHttpClient = okHttpClient;
            mAccessToken = accessToken;
            mDelegate = delegate;
        }

        @Override
        protected GetEventsResponse doInBackground(Void... voids) {

            RequestBody formBody = new FormBody.Builder()
                    .add(EventsConstants.PARAM_ACCESS_TOKEN, mAccessToken)
                    .build();

            Request request = new Request.Builder()
                    .url(EventsConstants.BASE_URL + EventsConstants.GET_EVENTS)
                    .post(formBody)
                    .build();

            try{

                Response response = mOkHttpClient.newCall(request).execute();

                if (response.isSuccessful()){
                    String responseString = response.body().string();

                    GetEventsResponse getEventsResponse = new Gson().fromJson(responseString, GetEventsResponse.class);
                    return getEventsResponse;
                }

            }catch (Exception e){

            }

            return null;
        }

        @Override
        protected void onPostExecute(GetEventsResponse eventsResponse) {
            super.onPostExecute(eventsResponse);

            if(eventsResponse != null){
                if(eventsResponse.isResponseOk()){
                    mDelegate.onSuccess(eventsResponse.getEventList());
                } else {
                    mDelegate.onFailure(eventsResponse.getMessage());
                }
            } else {
                mDelegate.onFailure(EventsConstants.EM_NULL_EVENT_RESPONSE);
            }
        }
    }
}
