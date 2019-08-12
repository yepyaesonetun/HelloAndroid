package com.padcmyanmar.padc9.helloandroid.views.holders;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.padcmyanmar.padc9.helloandroid.activities.EventDetailsActivity;
import com.padcmyanmar.padc9.helloandroid.delegates.EventItemDelegate;

/**
 * Created by Ye Pyae Sone Tun
 * on 2019-08-10.
 */

public class EventItemViewHolder extends RecyclerView.ViewHolder {

    private EventItemDelegate mEventItemDelegate;

    public EventItemViewHolder(@NonNull final View itemView, EventItemDelegate delegate) {
        super(itemView);

        mEventItemDelegate = delegate;

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mEventItemDelegate.onTapEventItem();
            }
        });
    }
}
