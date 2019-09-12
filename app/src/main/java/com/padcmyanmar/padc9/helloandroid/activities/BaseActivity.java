package com.padcmyanmar.padc9.helloandroid.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.padcmyanmar.padc9.helloandroid.R;
import com.padcmyanmar.padc9.helloandroid.data.models.EventModel;
import com.padcmyanmar.padc9.helloandroid.data.models.EventModelImpl;

public abstract class BaseActivity extends AppCompatActivity {

    protected EventModel eventModel;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        eventModel = EventModelImpl.getObjInstance();
    }

    protected void showIndefiniteSnackbar(String message){
        final Snackbar snackbar = Snackbar.make(getWindow().getDecorView(), message, Snackbar.LENGTH_INDEFINITE);
        snackbar.setAction(getResources().getString(R.string.lbl_ok), new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                snackbar.dismiss();
            }
        });
    }
}
