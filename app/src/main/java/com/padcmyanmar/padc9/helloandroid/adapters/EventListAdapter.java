package com.padcmyanmar.padc9.helloandroid.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.padcmyanmar.padc9.helloandroid.R;
import com.padcmyanmar.padc9.helloandroid.delegates.EventItemDelegate;
import com.padcmyanmar.padc9.helloandroid.views.holders.EventItemViewHolder;

/**
 * Created by Ye Pyae Sone Tun
 * on 2019-08-10.
 */

public class EventListAdapter extends RecyclerView.Adapter {

    private EventItemDelegate mEventItemDelegate;


    public EventListAdapter(EventItemDelegate mEventItemDelegate) {
        this.mEventItemDelegate = mEventItemDelegate;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_item_event, parent,false );
        return new EventItemViewHolder(itemView, mEventItemDelegate);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {

    }

    @Override
    public int getItemCount() {
        return 10;
    }
}
