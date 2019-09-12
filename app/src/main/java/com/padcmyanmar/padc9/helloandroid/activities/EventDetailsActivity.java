package com.padcmyanmar.padc9.helloandroid.activities;

import android.content.Context;
import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import android.support.v7.widget.Toolbar;
import com.padcmyanmar.padc9.helloandroid.R;
import com.padcmyanmar.padc9.helloandroid.adapters.EventDetailImageAdapter;
import com.padcmyanmar.padc9.helloandroid.data.vos.EventVO;

import butterknife.BindView;
import butterknife.ButterKnife;

public class EventDetailsActivity extends BaseActivity {

    public static final String EXTRA_EVENT_ID = "eventIdExtra";

    public static Intent newIntent(Context context, int eventIdExtra){
        Intent intent = new Intent(context, EventDetailsActivity.class);
        intent.putExtra(EXTRA_EVENT_ID, eventIdExtra);
        return intent;
    }

    @BindView(R.id.tvEventTitle)
    TextView tvEventTitle;

    @BindView(R.id.ivTagImage)
    ImageView ivTagImage;

    @BindView(R.id.tvDescription)
    TextView tvDescription;

    @BindView(R.id.tvDate)
    TextView tvDate;

    @BindView(R.id.tvCategory)
    TextView tvCategory;

    @BindView(R.id.tvAgeRange)
    TextView tvAgeRange;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_details);

        ButterKnife.bind(this);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ViewPager vpEventDetailImages = findViewById(R.id.vpEventDetailImages);

        EventDetailImageAdapter adapter = new EventDetailImageAdapter();
        vpEventDetailImages.setAdapter(adapter);

        int eventId = getIntent().getIntExtra(EXTRA_EVENT_ID, 0);

        EventVO event = eventModel.findEventById(eventId);

        bindData(event);
    }

    private void bindData(EventVO event){
        tvEventTitle.setText(event.getEventName());
        Glide.with(ivTagImage)
                .load(event.getEventOrganizer().getOrganizerPhotoUrl())
                .into(ivTagImage);
        tvDate.setText(event.getEventStartTime());
        tvCategory.setText(event.getEventType());
        tvAgeRange.setText(event.getEventRequirements().getAgeRange());
    }
}
