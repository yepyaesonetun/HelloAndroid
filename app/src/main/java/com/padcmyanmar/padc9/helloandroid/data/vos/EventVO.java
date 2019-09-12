package com.padcmyanmar.padc9.helloandroid.data.vos;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Embedded;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.Index;
import android.arch.persistence.room.PrimaryKey;

import com.google.gson.annotations.SerializedName;

import java.util.List;

@Entity(tableName = "event",
    indices = {@Index(value = "id",unique = true)})
public class EventVO {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "event_id_pk")
    private int eventIdPK;

    @SerializedName("id")
    @ColumnInfo(name = "id")
    private int id;

    @SerializedName("event_name")
    @ColumnInfo(name = "event_name")
    private String eventName;

    @SerializedName("event_start_time")
    @ColumnInfo(name = "event_start_time")
    private String eventStartTime;

    @SerializedName("event_location_name")
    @ColumnInfo(name = "event_location_name")
    private String eventLocationName;

    @SerializedName("event_location_full_address")
    @ColumnInfo(name = "event_location_full_address")
    private String eventLocationFullAddress;

    @SerializedName("event_organizer")
    @Embedded(prefix = "event_organizer_")
    private EventOrganizerVO eventOrganizer;

    @SerializedName("schedule_status")
    @ColumnInfo(name = "schedule_status")
    private int scheduleStatus;

    @SerializedName("event_type")
    @ColumnInfo(name = "event_type")
    private int eventType;

    @SerializedName("event_requirements")
    @Embedded(prefix = "event_requirements_")
    private EventRequirementsVO eventRequirements;

    @SerializedName("interested_user")
    @Ignore
    private List<UserVO> interestedUsers;

    @SerializedName("going_user")
    @Ignore
    private List<UserVO> goingUsers;

    public int getEventIdPK() {
        return eventIdPK;
    }

    public void setEventIdPK(int eventIdPK) {
        this.eventIdPK = eventIdPK;
    }

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
