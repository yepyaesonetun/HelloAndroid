package com.padcmyanmar.padc9.helloandroid.data.vos;

import java.util.List;

public class EventVO {

    private int id;
    private String eventName;
    private String eventStartTime;
    private String eventLocationName;
    private String eventLocationFullAddress;
    private EventOrganizerVO eventOrganizer;
    private int scheduleStatus;
    private int eventType;
    private EventRequirementsVO eventRequirements;
    private List<UserVO> interestedUsers;
    private List<UserVO> goingUsers;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getEventStartTime() {
        return eventStartTime;
    }

    public void setEventStartTime(String eventStartTime) {
        this.eventStartTime = eventStartTime;
    }

    public String getEventLocationName() {
        return eventLocationName;
    }

    public void setEventLocationName(String eventLocationName) {
        this.eventLocationName = eventLocationName;
    }

    public String getEventLocationFullAddress() {
        return eventLocationFullAddress;
    }

    public void setEventLocationFullAddress(String eventLocationFullAddress) {
        this.eventLocationFullAddress = eventLocationFullAddress;
    }

    public EventOrganizerVO getEventOrganizer() {
        return eventOrganizer;
    }

    public void setEventOrganizer(EventOrganizerVO eventOrganizer) {
        this.eventOrganizer = eventOrganizer;
    }

    public int getScheduleStatus() {
        return scheduleStatus;
    }

    public void setScheduleStatus(int scheduleStatus) {
        this.scheduleStatus = scheduleStatus;
    }

    public int getEventType() {
        return eventType;
    }

    public void setEventType(int eventType) {
        this.eventType = eventType;
    }

    public EventRequirementsVO getEventRequirements() {
        return eventRequirements;
    }

    public void setEventRequirements(EventRequirementsVO eventRequirements) {
        this.eventRequirements = eventRequirements;
    }

    public List<UserVO> getInterestedUsers() {
        return interestedUsers;
    }

    public void setInterestedUsers(List<UserVO> interestedUsers) {
        this.interestedUsers = interestedUsers;
    }

    public List<UserVO> getGoingUsers() {
        return goingUsers;
    }

    public void setGoingUsers(List<UserVO> goingUsers) {
        this.goingUsers = goingUsers;
    }
}
