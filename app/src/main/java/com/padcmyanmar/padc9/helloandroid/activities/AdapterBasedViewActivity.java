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
import com.padcmyanmar.padc9.helloandroid.delegates.EventItemDelegate;


public class AdapterBasedViewActivity extends AppCompatActivity implements EventItemDelegate {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adapter_based_view);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

//        FloatingActionButton fab = findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });


        RecyclerView rvEvents = findViewById(R.id.rvEvents);
        rvEvents.setLayoutManager(new LinearLayoutManager(getApplicationContext(),
                LinearLayoutManager.VERTICAL, false));

        EventListAdapter adapter = new EventListAdapter(this);
        rvEvents.setAdapter(adapter);
    }


    @Override
    public void onTapEventItem() {
        startActivity(new Intent(this, EventDetailsActivity.class));
    }
}
