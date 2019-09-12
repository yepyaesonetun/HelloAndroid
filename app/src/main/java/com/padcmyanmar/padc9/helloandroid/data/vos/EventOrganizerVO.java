package com.padcmyanmar.padc9.helloandroid.data.vos;

import android.arch.persistence.room.ColumnInfo;

import com.google.gson.annotations.SerializedName;

public class EventOrganizerVO {

    @SerializedName("organizer_name")
    @ColumnInfo(name = "organizer_name")
    private String oraganizerName;
    @SerializedName("organizer_photo_url")
    @ColumnInfo(name = "organizer_photo_url")
    private String organizerPhotoUrl;
    @SerializedName("organizer_role")
    @ColumnInfo(name = "organizer_role")
    private String organizerRole;

    public String getOraganizerName() {
        return oraganizerName;
    }

    public void setOraganizerName(String oraganizerName) {
        this.oraganizerName = oraganizerName;
    }

    public String getOrganizerPhotoUrl() {
        return organizerPhotoUrl;
    }

    public void setOrganizerPhotoUrl(String organizerPhotoUrl) {
        this.organizerPhotoUrl = organizerPhotoUrl;
    }

    public String getOrganizerRole() {
        return organizerRole;
    }

    public void setOrganizerRole(String organizerRole) {
        this.organizerRole = organizerRole;
    }
}
