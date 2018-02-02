package com.example.admin.apptoast;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class Profile extends AppCompatActivity {

    TripDatabase tripDatabase;
ImageView back;
 TextView tv_From, tv_To, tv_Trip, tv_Price, tv_Time;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        tripDatabase = new TripDatabase(getApplicationContext());
        /**
         * VIEW INSTANCES
         */
        tv_From = findViewById(R.id.tv_From);
        tv_To = findViewById(R.id.tv_To);
        tv_Trip = findViewById(R.id.tv_Trip);
        tv_Price = findViewById(R.id.tv_Price);
        tv_Time = findViewById(R.id.tv_Time);
        back = findViewById(R.id.back);


        /**
         * ONCLICKS
         */
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(), LandingBottomActivity.class); //CAST ACTIVITY TO MANIFEST TO RESOLVE ERROR LERATO SAMBULA
                startActivity(intent);
            }
        });

/**
 * RTREIVING TO DISPLAY FROM CLASS
 */
        /**
         * RETRIEVING TO DISPLAY FROM CLASS
         */
//        TripPojo report = tripDatabase.getAllSubject();
//
//        tv_From.setText(report.getPlaceFrom());
//        tv_To.setText(report.getPlaceTo());
//        tv_Trip.setText(report.getTypeTrips());
//        //tv_Price.setText(report.getSurname());
//        tv_Time.setText(""+report.getFromDate());


    }
}
