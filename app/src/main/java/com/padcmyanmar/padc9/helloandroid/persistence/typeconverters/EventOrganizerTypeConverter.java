package com.padcmyanmar.padc9.helloandroid.persistence.typeconverters;

import android.arch.persistence.room.TypeConverter;

import com.google.gson.Gson;
import com.padcmyanmar.padc9.helloandroid.data.vos.EventOrganizerVO;

public class EventOrganizerTypeConverter {
    @TypeConverter
    public static String eventOrganizerToJson(EventOrganizerVO eventOrganizer){
        return new Gson().toJson(eventOrganizer);
    }

    @TypeConverter
    public static EventOrganizerVO jsonToEventOrganizer(String eventOrganizerJson){
        return new Gson().fromJson(eventOrganizerJson, EventOrganizerVO.class);
    }
}
