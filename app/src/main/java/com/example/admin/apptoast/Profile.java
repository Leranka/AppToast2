package com.example.admin.apptoast;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class Profile extends AppCompatActivity {

ImageView back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        back = findViewById(R.id.back);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(), LandingBottomActivity.class); //CAST ACTIVITY TO MANIFEST TO RESOLVE ERROR LERATO SAMBULA
                startActivity(intent);
            }
        });

    }
}
