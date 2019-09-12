package com.padcmyanmar.padc9.helloandroid.persistence.typeconverters;

import android.arch.persistence.room.TypeConverter;

import com.google.gson.Gson;
import com.padcmyanmar.padc9.helloandroid.data.vos.EventRequirementsVO;

public class EventRequirementTypeConverter {
    @TypeConverter
    public static String eventRequirementToJson(EventRequirementsVO eventRequirementsVO){
        return new Gson().toJson(eventRequirementsVO);
    }

    @TypeConverter
    public static EventRequirementsVO jonToEventRequirement(String json){
        return new Gson().fromJson(json, EventRequirementsVO.class);
    }
}
