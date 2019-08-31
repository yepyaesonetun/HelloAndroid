package com.padcmyanmar.padc9.helloandroid.views.holders;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.padcmyanmar.padc9.helloandroid.R;
import com.padcmyanmar.padc9.helloandroid.activities.EventDetailsActivity;
import com.padcmyanmar.padc9.helloandroid.data.vos.EventVO;
import com.padcmyanmar.padc9.helloandroid.delegates.EventItemDelegate;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Ye Pyae Sone Tun
 * on 2019-08-10.
 */

public class EventItemViewHolder extends BaseViewHolder<EventVO> {

    private EventItemDelegate mEventItemDelegate;

    @BindView(R.id.tvEventName)
    TextView tvEventName;

    @BindView(R.id.tvEventTitle)
    TextView tvEventTitle;

    @BindView(R.id.ivEvent)
    ImageView ivEvent;

    @BindView(R.id.tvTime)
    TextView tvTime;

    @BindView(R.id.tvEventAgeRange)
    TextView tvEventAgeRange;

    @BindView(R.id.tvLocationName)
    TextView tvLocationName;

    @BindView(R.id.tvLocationFullAddress)
    TextView tvLocationFullAddress;

    @BindView(R.id.ivOrganizer)
    ImageView ivOrganizer;

    @BindView(R.id.tvOrganizerName)
    TextView tvOrganizerName;

    @BindView(R.id.tvEventOwnerRole)
    TextView tvEventOwnerRole;

    public EventItemViewHolder(@NonNull final View itemView, EventItemDelegate delegate) {
        super(itemView);

        ButterKnife.bind(itemView);

        mEventItemDelegate = delegate;

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mEventItemDelegate.onTapEventItem();
            }
        });
    }

    @Override
    public void bindData(EventVO data) {

    }
}
