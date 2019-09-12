package com.padcmyanmar.padc9.helloandroid.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.padcmyanmar.padc9.helloandroid.R;
import com.padcmyanmar.padc9.helloandroid.adapters.EventListAdapter;
import com.padcmyanmar.padc9.helloandroid.data.models.EventModel;
import com.padcmyanmar.padc9.helloandroid.data.models.EventModelImpl;
import com.padcmyanmar.padc9.helloandroid.data.vos.EventVO;
import com.padcmyanmar.padc9.helloandroid.delegates.EventItemDelegate;
import com.padcmyanmar.padc9.helloandroid.network.dataagents.HttpUrlConnectionDataAgentImpl;
import com.padcmyanmar.padc9.helloandroid.utils.EventsConstants;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


public class AdapterBasedViewActivity extends BaseActivity implements EventItemDelegate {

    @BindView(R.id.rvEvents)
    RecyclerView rvEvents;

    @BindView(R.id.fab)
    FloatingActionButton fab;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adapter_based_view);

        ButterKnife.bind(this);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        rvEvents.setLayoutManager(new LinearLayoutManager(getApplicationContext(),
                LinearLayoutManager.VERTICAL, false));

        final EventListAdapter adapter = new EventListAdapter(this);
        rvEvents.setAdapter(adapter);

        //Load Data
        eventModel.getEvents(new EventModel.GetEventsFromDataLayerDelegate() {
            @Override
            public void onSuccess(List<EventVO> events) {
                adapter.setNewData(events);
            }

            @Override
            public void onFailure(String errorMessage) {
                showIndefiniteSnackbar(errorMessage);
            }
        });
    }


    @Override
    public void onTapEventItem(int eventId) {
        Intent intent = EventDetailsActivity.newIntent(getApplicationContext(), eventId);
        startActivity(intent);
    }
}
