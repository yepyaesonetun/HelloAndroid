package com.padcmyanmar.padc9.helloandroid.network.dataagents;

import com.padcmyanmar.padc9.helloandroid.data.vos.EventVO;

import java.util.List;

public interface EventDataAgent {
    void getEvents(String accessToken);

    interface GetEventsFromNetworkDelegate{
        void onSuccess(List<EventVO> events);
        void onFailure(String errorMessage);
    }
}
