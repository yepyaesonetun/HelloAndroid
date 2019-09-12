package com.padcmyanmar.padc9.helloandroid.network.dataagents;

import android.os.AsyncTask;

import com.google.gson.Gson;
import com.padcmyanmar.padc9.helloandroid.network.responses.GetEventsResponse;
import com.padcmyanmar.padc9.helloandroid.utils.EventsConstants;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

public class HttpUrlConnectionDataAgentImpl implements EventDataAgent {
    private static HttpUrlConnectionDataAgentImpl objInstance;

    private HttpUrlConnectionDataAgentImpl() {

    }

    public static HttpUrlConnectionDataAgentImpl getObjInstance() {
        if (objInstance == null) {
            objInstance = new HttpUrlConnectionDataAgentImpl();
        }
        return objInstance;
    }

    @Override
    public void getEvents(String accessToken, GetEventsFromNetworkDelegate delegate) {
        new GetEventsTask(accessToken, delegate).execute();
    }

    public static class GetEventsTask extends AsyncTask<Void, Void, GetEventsResponse> {

        private String accessToken;
        private GetEventsFromNetworkDelegate eventsResponseDelegate;

        public GetEventsTask(String accessToken, GetEventsFromNetworkDelegate eventsResponseDelegate) {
            this.accessToken = accessToken;
            this.eventsResponseDelegate = eventsResponseDelegate;
        }

        @Override
        protected GetEventsResponse doInBackground(Void... voids) {
            URL url;
            BufferedReader reader = null;
            StringBuilder stringBuilder;

            try {
                // create the HttpURLConnection
                url = new URL(EventsConstants.BASE_URL
                        + EventsConstants.GET_EVENTS); //1.

                HttpURLConnection connection = (HttpURLConnection) url.openConnection(); //2.

                // just want to do an HTTP POST here
                connection.setRequestMethod("POST"); //3.

                // uncomment this if you want to write output to this url
                //connection.setDoOutput(true);

                // give it 15 seconds to respond
                connection.setReadTimeout(15 * 1000); //4. ms

                connection.setDoInput(true); //5.
                connection.setDoOutput(true);

                //put the request parameter into NameValuePair list.
                List<NameValuePair> params = new ArrayList<>(); //6.
                params.add(new BasicNameValuePair(EventsConstants.PARAM_ACCESS_TOKEN,
                        accessToken));

                //write the parameters from NameValuePair list into connection obj.
                OutputStream outputStream = connection.getOutputStream();
                BufferedWriter writer = new BufferedWriter(
                        new OutputStreamWriter(outputStream, "UTF-8"));
                writer.write(getQuery(params));
                writer.flush();
                writer.close();
                outputStream.close();

                connection.connect(); //7.

                // read the output from the server
                reader = new BufferedReader(new InputStreamReader(connection.getInputStream())); //8.
                stringBuilder = new StringBuilder();

                String line = null;
                while ((line = reader.readLine()) != null) {
                    stringBuilder.append(line + "\n");
                }

                String responseString = stringBuilder.toString(); //9.

                GetEventsResponse response = new Gson()
                        .fromJson(responseString, GetEventsResponse.class);

                return response;

            } catch (Exception e) {

            } finally {
                // close the reader; this can throw an exception too, so
                // wrap it in another try/catch block.
                if (reader != null) {
                    try {
                        reader.close();
                    } catch (IOException ioe) {
                        ioe.printStackTrace();
                    }
                }
            }

            return null;
        }

        @Override
        protected void onPostExecute(GetEventsResponse eventsResponse) {
            super.onPostExecute(eventsResponse);

            if(eventsResponse != null){
                if(eventsResponse.isResponseOk()){
                    eventsResponseDelegate.onSuccess(eventsResponse.getEventList());
                } else {
                    eventsResponseDelegate.onFailure(eventsResponse.getMessage());
                }
            } else {
                eventsResponseDelegate.onFailure(EventsConstants.EM_NULL_EVENT_RESPONSE);
            }
        }

        private String getQuery(List<NameValuePair> params) throws UnsupportedEncodingException {
            StringBuilder result = new StringBuilder();
            boolean first = true;

            for (NameValuePair pair : params) {
                if (first)
                    first = false;
                else
                    result.append("&");

                result.append(URLEncoder.encode(pair.getName(), "UTF-8"));
                result.append("=");
                result.append(URLEncoder.encode(pair.getValue(), "UTF-8"));
            }

            return result.toString();
        }


    }
}
