package com.padcmyanmar.padc9.helloandroid.data.models;

import com.padcmyanmar.padc9.helloandroid.data.vos.EventVO;

import java.util.List;

public interface EventModel {
    void getEvents(GetEventsFromDataLayerDelegate delegate);
    EventVO findEventById(int evntId);

    interface GetEventsFromDataLayerDelegate{
        void onSuccess(List<EventVO> events);
        void onFailure(String errorMessage);
    }
}
