package com.example.admin.apptoast;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.ImageView;

public class Landing extends Activity{

    CardView citytocity, putco, reavaya, metrobus;
    ImageView profile;
    private View view;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landing);




        citytocity = findViewById(R.id.layout_citytocity);
        putco = findViewById(R.id.layout_putco);
        reavaya = findViewById(R.id.layout_reavaya);
        metrobus =findViewById(R.id.layout_metrobus);


        citytocity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),LandingBottomActivity.class);
                startActivity(i);
            }
        });

        putco.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),LandingBottomActivity.class);
                startActivity(i);
            }
        });

        reavaya.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),LandingBottomActivity.class);
                startActivity(i);
            }
        });

        metrobus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),LandingBottomActivity.class);
                startActivity(i);
            }
        });



    }


}
