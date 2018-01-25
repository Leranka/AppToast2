package com.example.admin.apptoast;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

public class LandingBottomActivity extends AppCompatActivity implements SearchView.OnQueryTextListener {



    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                Fragment fragment;
                switch (item.getItemId()) {

                    case R.id.navigation_home:
                        fragment = new Landing();
                        loadFragment(fragment);
                        return true;
                    case R.id.navigation_dashboard:
                        fragment = new TimeTableFragment();
                        loadFragment(fragment);
                        return true;
                    case R.id.navigation_notifications:
                        fragment = new Landing();
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


        /**
         * Toolbar
         */
        Toolbar toolbar = findViewById(R.id.bus_Schedule) ;
        toolbar.setTitle("Bus Schedule");
        toolbar.setTitleTextColor(Color.BLACK);

      loadFragment(new Landing());




       // mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }
    private void loadFragment(Fragment fragment) {
        // load fragment
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.container, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.search, menu);
        MenuItem menuItem = menu.findItem(R.id.action_search);
        SearchView searchView = (SearchView) MenuItemCompat.getActionView(menuItem);
        searchView.setOnQueryTextListener(this);
        return true;

    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        return true;
    }
}
