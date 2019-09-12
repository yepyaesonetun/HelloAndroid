package com.padcmyanmar.padc9.helloandroid.network;

import com.padcmyanmar.padc9.helloandroid.data.vos.EventVO;
import com.padcmyanmar.padc9.helloandroid.network.responses.GetEventsResponse;
import com.padcmyanmar.padc9.helloandroid.utils.EventsConstants;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface EventsApi {
    @FormUrlEncoded
    @POST(EventsConstants.GET_EVENTS)
    Call<GetEventsResponse> getAllEvents(@Field(EventsConstants.PARAM_ACCESS_TOKEN) String accessToken);
}
