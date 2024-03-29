package com.padcmyanmar.padc9.helloandroid.activities;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.padcmyanmar.padc9.helloandroid.R;

public class ContainerComponentsActivity extends BaseActivity {

    private static final int REQUEST_IMAGE_GET = 1;
    public static final int RC_FROM_CONTAINER_COMPONENT = 1234;

    private ImageView ivSelectedImage;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_container_components);

        ivSelectedImage = findViewById(R.id.iv_user_image);

        Button btnStartUIComponent1 = findViewById(R.id.btn_start_ui_component_1);
        btnStartUIComponent1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = TestActivity.newIntent(getApplicationContext(), "Data from Container Component.");
                startActivityForResult(intent, RC_FROM_CONTAINER_COMPONENT);
            }
        });

        Button btnSelectUserImage = findViewById(R.id.btn_select_image);
        btnSelectUserImage.setOnClickListener(new View.OnClickListener() {
            static final int REQUEST_IMAGE_GET = 1;

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
                intent.setType("image/*");
                startActivityForResult(intent, REQUEST_IMAGE_GET);
            }
        });


        Button btnShowDirectionToShweDagonPagoda = findViewById(R.id.btn_show_direction);
        btnShowDirectionToShweDagonPagoda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String openInMapPrefix = "http://maps.google.com/maps?daddr=";
                String uriToOpen = openInMapPrefix + "Shwedagon Pagoda";
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(uriToOpen));
                if (intent.resolveActivity(getPackageManager()) != null) {
                    startActivity(intent);
                }
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_IMAGE_GET && resultCode == RESULT_OK && data != null) {
            Uri fullPhotoUri = data.getData();
            ivSelectedImage.setImageURI(fullPhotoUri);
        } else if (requestCode ==  RC_FROM_CONTAINER_COMPONENT && resultCode == RESULT_OK && data != null) {
            String dataFromStartedActivity = data.getStringExtra(TestActivity.IE_RETURN_DATA);
            Toast.makeText(getApplicationContext(), dataFromStartedActivity, Toast.LENGTH_SHORT).show();
        }
    }
}
