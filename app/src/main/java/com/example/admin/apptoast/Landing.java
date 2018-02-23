package com.example.admin.apptoast;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

public class Landing extends Activity {

    RelativeLayout putco, reavaya, metrobus,citytocity;
    public static String TYPE ="";

    ImageView profile;
    private View view;
    CardView cardView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landing);




        citytocity = findViewById(R.id.citytocity);
        putco = findViewById(R.id.putco);
        reavaya = findViewById(R.id.reavaya);
        metrobus =findViewById(R.id.metro);


        citytocity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),LandingBottomActivity.class);
                TYPE="city";
                startActivity(i);
            }
        });

        putco.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),LandingBottomActivity.class);
                startActivity(i);
                TYPE="putco";
            }
        });

        reavaya.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),LandingBottomActivity.class);
                startActivity(i);
                TYPE="reavaya";
            }
        });

        metrobus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),LandingBottomActivity.class);
                startActivity(i);
                TYPE="metrobus";
            }
        });


    }


}
