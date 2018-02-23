package com.example.admin.apptoast;

import android.content.Intent;
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


    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                Fragment fragment;
                switch (item.getItemId()) {

                    case R.id.navigation_home:
                        toolbarBottomNav.setTitle("Destination");
//                        fragment = new Landing();
//                        loadFragment(fragment);
                     return true;
                    case R.id.navigation_dashboard:
                        toolbarBottomNav.setTitle("Bus Schedules");
                        fragment = new TimeTableFragment();
                        loadFragment(fragment);
                        return true;
                    case R.id.navigation_notifications:
                        toolbarBottomNav.setTitle("Announcements");
                        fragment = new AnnouncementFragment();

                        loadFragment(fragment);
                        return true;
                }
                return false;

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landing_bottom);

        //set Toobar
        toolbarBottomNav = findViewById(R.id.toolbarBottomNav);
        toolbarBottomNav.setTitle(" Home");
        setSupportActionBar(toolbarBottomNav);

        //loading th first Fragment
//        Fragment fragment= new Landing();


//        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
//        transaction.replace(R.id.container, fragment);
//        transaction.commit();
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
        super.onBackPressed();
    }

//    @Override
//    protected void onStart() {
//
//        //loading th first Fragment
////        Fragment fragment= new Landing();
////
////
////        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
////        transaction.replace(R.id.container, fragment);
////        transaction.addToBackStack(null);
////        transaction.commit();
////        super.onStart();
//    }
}
