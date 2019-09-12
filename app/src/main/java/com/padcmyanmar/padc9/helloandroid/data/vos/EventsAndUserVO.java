package com.padcmyanmar.padc9.helloandroid.data.vos;

import android.arch.persistence.room.Embedded;
import android.arch.persistence.room.Relation;

import java.util.List;

public class EventsAndUserVO {
    @Embedded
    EventVO event;

    @Relation(parentColumn = "id", entityColumn = "event_id")
    List<UserVO> users;

    public EventVO getEvent() {
        return event;
    }

    public void setEvent(EventVO event) {
        this.event = event;
    }

    public List<UserVO> getUsers() {
        return users;
    }

    public void setUsers(List<UserVO> users) {
        this.users = users;
    }
}
