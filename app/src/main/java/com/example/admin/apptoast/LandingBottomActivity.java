package com.example.admin.apptoast;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;


public class LandingBottomActivity extends AppCompatActivity {

    private Toolbar toolbarBottomNav;
    private ImageView profile;
    private static Boolean in = false;


    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            if( Landing.TYPE=="city") {

                Drawable dr = getResources().getDrawable(R.drawable.city_to_city);
                Bitmap bitmap = ((BitmapDrawable) dr).getBitmap();
// Scale it to 50 x 50
                Drawable d = new BitmapDrawable(getResources(), Bitmap.createScaledBitmap(bitmap, 100, 40, true));

                toolbarBottomNav.setLogo(d);


            }

            if( Landing.TYPE=="putco") {
                Drawable dr = getResources().getDrawable(R.drawable.putco);
                Bitmap bitmap = ((BitmapDrawable) dr).getBitmap();
// Scale it to 50 x 50
                Drawable d = new BitmapDrawable(getResources(), Bitmap.createScaledBitmap(bitmap, 100, 40, true));

                toolbarBottomNav.setLogo(d);
            }
            if( Landing.TYPE=="reavaya") {
                Drawable dr = getResources().getDrawable(R.drawable.reavaya);
                Bitmap bitmap = ((BitmapDrawable) dr).getBitmap();
// Scale it to 50 x 50
                Drawable d = new BitmapDrawable(getResources(), Bitmap.createScaledBitmap(bitmap, 100, 40, true));

                toolbarBottomNav.setLogo(d);


            }
            if( Landing.TYPE=="metrobus") {
                Drawable dr = getResources().getDrawable(R.drawable.metrobus);
                Bitmap bitmap = ((BitmapDrawable) dr).getBitmap();
// Scale it to 50 x 50
                Drawable d = new BitmapDrawable(getResources(), Bitmap.createScaledBitmap(bitmap, 100, 40, true));

                toolbarBottomNav.setLogo(d);
            }

            Fragment fragment;
                switch (item.getItemId()) {

                    case R.id.navigation_home:
                        toolbarBottomNav.setTitle("       Destination");
                        fragment = new FragmentPlaces();
                        loadFragment(fragment);
                     return true;

                    case R.id.navigation_dashboard:

                            toolbarBottomNav.setTitle("       Bus Schedule");
                            fragment = new CityToCity_TimeTableFragment();
                            loadFragment(fragment);

                        return true;

                    case R.id.navigation_notifications:


                            toolbarBottomNav.setTitle("       Announcements");


                            fragment = new AnnouncementFragment();
                            loadFragment(fragment);


                        return true;

                   case R.id.navigation_trips:
                        toolbarBottomNav.setTitle("       Special Trips");
                        fragment = new SpecialTripsActivity();
                        loadFragment(fragment);
                        return true;
                    default:
                        fragment = new FragmentPlaces();

                        loadFragment(fragment);
                        return true;
                }


        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landing_bottom);

        //set Toobar
        toolbarBottomNav = findViewById(R.id.toolbarBottomNav);
        toolbarBottomNav.setTitle("       Destination");
        setSupportActionBar(toolbarBottomNav);

       // loading th first Fragment
        if(in==false||Profile.BACK==false) {
            Fragment fragment = new FragmentPlaces();

            loadFragment(fragment);


            in =true;

        }


        //declaring a profile image
        profile = findViewById(R.id.profile);
        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),Profile.class);
                startActivity(i);
            }
        });


       // mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);


        if( Landing.TYPE=="city") {

            Drawable dr = getResources().getDrawable(R.drawable.city_to_city);
            Bitmap bitmap = ((BitmapDrawable) dr).getBitmap();
            // Scale it to 50 x 50
            Drawable d = new BitmapDrawable(getResources(), Bitmap.createScaledBitmap(bitmap, 100, 40, true));

            toolbarBottomNav.setLogo(d);


        }

        if( Landing.TYPE=="putco") {
            Drawable dr = getResources().getDrawable(R.drawable.putco);
            Bitmap bitmap = ((BitmapDrawable) dr).getBitmap();
            // Scale it to 50 x 50
            Drawable d = new BitmapDrawable(getResources(), Bitmap.createScaledBitmap(bitmap, 100, 40, true));

            toolbarBottomNav.setLogo(d);
        }
        if( Landing.TYPE=="reavaya") {
            Drawable dr = getResources().getDrawable(R.drawable.reavaya);
            Bitmap bitmap = ((BitmapDrawable) dr).getBitmap();
            // Scale it to 50 x 50
            Drawable d = new BitmapDrawable(getResources(), Bitmap.createScaledBitmap(bitmap, 100, 40, true));

            toolbarBottomNav.setLogo(d);


        }
        if( Landing.TYPE=="metrobus") {
            Drawable dr = getResources().getDrawable(R.drawable.metrobus);
            Bitmap bitmap = ((BitmapDrawable) dr).getBitmap();
            // Scale it to 50 x 50
            Drawable d = new BitmapDrawable(getResources(), Bitmap.createScaledBitmap(bitmap, 100, 40, true));

            toolbarBottomNav.setLogo(d);
        }
    }
    private void loadFragment(Fragment fragment) {
        // load fragment
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.container, fragment);

        transaction.commit();
    }
    @Override
    public void onBackPressed() {

        // Otherwise defer to system default behavior.
        in =false;
        super.onBackPressed();
    }


}
