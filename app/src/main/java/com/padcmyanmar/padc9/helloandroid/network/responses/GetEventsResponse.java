package com.padcmyanmar.padc9.helloandroid.network.responses;

import com.google.gson.annotations.SerializedName;
import com.padcmyanmar.padc9.helloandroid.data.vos.EventVO;
import com.padcmyanmar.padc9.helloandroid.utils.EventsConstants;

import java.util.List;

public class GetEventsResponse {

    @SerializedName("message")
    private String message;

    @SerializedName("code")
    private int code;

    @SerializedName("data")
    private List<EventVO> eventList;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public List<EventVO> getEventList() {
        return eventList;
    }

    public void setEventList(List<EventVO> eventList) {
        this.eventList = eventList;
    }

    public Boolean isResponseOk(){
        return code == EventsConstants.CODE_RESPONSE_OK && eventList != null;
    }
}
