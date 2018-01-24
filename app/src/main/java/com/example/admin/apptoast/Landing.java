package com.example.admin.apptoast;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class Landing extends AppCompatActivity{

    LinearLayout citytocity, putco, reavaya, metrobus;
    ImageView profile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landing);

        citytocity = findViewById(R.id.layout_citytocity);
        putco = findViewById(R.id.layout_putco);
        reavaya = findViewById(R.id.layout_reavaya);
        metrobus = findViewById(R.id.layout_metrobus);
        profile = findViewById(R.id.profile);

        citytocity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Landing.this,Destination.class);
                startActivity(i);
            }
        });

        putco.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Landing.this,Destination.class);
                startActivity(i);
            }
        });

        reavaya.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Landing.this,Destination.class);
                startActivity(i);
            }
        });

        metrobus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Landing.this,Destination.class);
                startActivity(i);
            }
        });

        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Landing.this,Profile.class);
                startActivity(i);
            }
        });
    }
}
