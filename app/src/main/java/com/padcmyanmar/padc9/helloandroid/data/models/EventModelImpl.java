package com.padcmyanmar.padc9.helloandroid.data.models;

import android.content.Context;

import com.padcmyanmar.padc9.helloandroid.data.vos.EventVO;
import com.padcmyanmar.padc9.helloandroid.data.vos.EventsAndUserVO;
import com.padcmyanmar.padc9.helloandroid.network.dataagents.EventDataAgent;
import com.padcmyanmar.padc9.helloandroid.network.dataagents.HttpUrlConnectionDataAgentImpl;
import com.padcmyanmar.padc9.helloandroid.utils.EventsConstants;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EventModelImpl extends BaseModel implements EventModel{

    private Map<Integer, EventVO> eventsDataRepository;

    private static EventModelImpl objInstance;

    public EventModelImpl(Context context) {
        super(context);
        eventsDataRepository = new HashMap<>();
    }

    public static void initializeEventModel(Context context){
        objInstance = new EventModelImpl(context);
    }

    public static EventModelImpl getObjInstance(){
        if(objInstance == null){
            throw new RuntimeException(EventsConstants.EM_EVENT_MODEL_NOT_INITIALIZED);
        }
        return objInstance;
    }


    @Override
    public void getEvents(final GetEventsFromDataLayerDelegate delegate) {
        if(mDatabase.areEventsExistInDB()){
            //delegate.onSuccess(mDatabase.eventDao().getAllEventsFromDB());
            //List<EventVO> eventsFromDB = mDatabase.eventDao().getAllEventsFromDB();
            List<EventsAndUserVO> eventsAndUsersFromDB = mDatabase.eventDao().getAllEventsFromDB();

            List<EventVO> eventsFromDB = new ArrayList<>();
            for(EventsAndUserVO eventsAndUser : eventsAndUsersFromDB){
                eventsAndUser.getEvent().setGoingUsers(eventsAndUser.getUsers());
                eventsFromDB.add(eventsAndUser.getEvent());
            }

            delegate.onSuccess(eventsFromDB);
        } else {
            mDataAgent.getEvents(EventsConstants.DUMMY_ACCESS_TOKEN, new EventDataAgent.GetEventsFromNetworkDelegate() {
                @Override
                public void onSuccess(List<EventVO> events) {

                    //mDatabase.eventDao().insertEvents(events);
                    mDatabase.eventDao().insertEventsAndUsers(events, mDatabase.userDao());

                    delegate.onSuccess(events);
                }

                @Override
                public void onFailure(String errorMessage) {
                    delegate.onFailure(errorMessage);
                }
            });
        }
    }

    @Override
    public EventVO findEventById(int eventId) {
        EventVO event = eventsDataRepository.get(eventId);
        return event;
    }
}
