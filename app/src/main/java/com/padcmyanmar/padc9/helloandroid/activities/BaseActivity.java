package com.padcmyanmar.padc9.helloandroid.activities;

import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.padcmyanmar.padc9.helloandroid.R;

public abstract class BaseActivity extends AppCompatActivity {

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
