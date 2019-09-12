package com.padcmyanmar.padc9.helloandroid.utils;

public class EventsConstants {
    public static final String BASE_URL = "https://78743814-6e79-4273-8c16-c5afc7b81049.mock.pstmn.io";
    public static final String GET_EVENTS = "/getAllEvents";
    public static final String LOGIN = "/login";
    public static final String REGISTER = "/register";

    //Parameters
    public static final String PARAM_ACCESS_TOKEN = "access_token";

    //Response Code
    public static final int CODE_RESPONSE_OK = 200;

    //Dummy Access Token
    public static final String DUMMY_ACCESS_TOKEN = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJodHRwOlwvXC8zNC43My45LjIyOFwvYXBpXC9sb2dpbi1ieS1wYXNzd29yZCIsImlhdCI6MTU2NjYxNzcxMSwiZXhwIjoxNTY5Mjk2MTExLCJuYmYiOjE1NjY2MTc3MTEsImp0aSI6InBabm9sMTljTEJ3c05zVFMiLCJzdWIiOjExLCJwcnYiOiJjZGU5NmRlZGNiMzMzODlmMjFhMWRhZjRlY2QyZDc0MWFkMGJlNWUyIn0.pGNd-8Ag_VIvCmrQ9xFzsr-NbLo-I-zvxeYjXXEkzCI";

    //Error Messages
    public static final String EM_NULL_EVENT_RESPONSE = "Please Check Internet Connection";
    public static final String EM_EVENT_MODEL_NOT_INITIALIZED = "Event Model should have been initialized";

    //DB Name
    public static final String EVENT_DB = "EventsDB";
}
