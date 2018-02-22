package com.example.admin.apptoast;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.List;

public class Profile extends AppCompatActivity {

    TripDatabase tripDatabase;
 TextView tv_From, tv_To, tv_Trip, tv_Price, tv_Time;
 ImageButton back;

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
         * RETRIEVING TO DISPLAY FROM CLASS
         */
        List<TripPojo> report = tripDatabase.getAllSubject();
        int x;

        for (x = 0; x < report.size(); x++)
        {

            tv_From.setText(report.get(x).getPlaceFrom());
        tv_To.setText(report.get(x).getPlaceTo());
        tv_Trip.setText(report.get(x).getTypeTrips());
        tv_Price.setText(report.get(x).getPrice());
        tv_Time.setText("" + report.get(x).getFromDate());
    }


   }
}
