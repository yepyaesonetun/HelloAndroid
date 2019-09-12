package com.padcmyanmar.padc9.helloandroid.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;

import com.padcmyanmar.padc9.helloandroid.views.holders.BaseViewHolder;

import java.util.ArrayList;
import java.util.List;

public abstract class BaseRecyclerAdapter<T extends BaseViewHolder<W>, W> extends RecyclerView.Adapter<T> {

    private List<W> mData;

    BaseRecyclerAdapter(){
        mData = new ArrayList<>();
    }

    @Override
    public void onBindViewHolder(@NonNull T viewHolder, int position) {
        viewHolder.bindData(mData.get(position));
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public void setNewData(List<W> data){
        mData = data;
        notifyDataSetChanged();
    }

    public void appendNewData(List<W> data){
        mData.addAll(data);
        notifyDataSetChanged();
    }
}
