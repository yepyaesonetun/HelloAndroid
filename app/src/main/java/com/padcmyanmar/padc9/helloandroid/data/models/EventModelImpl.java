package com.padcmyanmar.padc9.helloandroid.data.models;

import com.padcmyanmar.padc9.helloandroid.data.vos.EventVO;

import java.util.HashMap;
import java.util.Map;

public class EventModelImpl extends BaseModel implements EventModel{

    private Map<Integer, EventVO> eventsDataRepository;

    private static EventModelImpl objInstance;

    private EventModelImpl(){
        eventsDataRepository = new HashMap<>();
    }

    public static EventModelImpl getObjInstance(){
        if(objInstance == null){
            objInstance = new EventModelImpl();
        }
        return objInstance;
    }


    @Override
    public void getEvents() {

    }
}
