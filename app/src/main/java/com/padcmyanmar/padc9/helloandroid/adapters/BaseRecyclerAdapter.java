package com.padcmyanmar.padc9.helloandroid.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;

import com.padcmyanmar.padc9.helloandroid.views.holders.BaseViewHolder;

import java.util.List;

public abstract class BaseRecyclerAdapter<T extends BaseViewHolder<W>, W> extends RecyclerView.Adapter<T> {

    private List<W> mData;

    @Override
    public void onBindViewHolder(@NonNull T viewHolder, int position) {
        viewHolder.bindData(mData.get(position));
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }
}
