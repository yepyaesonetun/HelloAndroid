package com.padcmyanmar.padc9.helloandroid.activities;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.support.v7.widget.Toolbar;
import com.padcmyanmar.padc9.helloandroid.R;
import com.padcmyanmar.padc9.helloandroid.adapters.EventDetailImageAdapter;

public class EventDetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_details);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ViewPager vpEventDetailImages = findViewById(R.id.vpEventDetailImages);

        EventDetailImageAdapter adapter = new EventDetailImageAdapter();
        vpEventDetailImages.setAdapter(adapter);
    }
}
