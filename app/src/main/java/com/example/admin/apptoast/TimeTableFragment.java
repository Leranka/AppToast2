package com.example.admin.apptoast;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;



public class TimeTableFragment extends Fragment {

    private View view;
    private Toolbar bus_Schedule;




    public TimeTableFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view =inflater.inflate(R.layout.fragment_time_table, container, false);

//        /**
//         * Toolbar
//         */
//        bus_Schedule = (Toolbar) getView().findViewById(R.id.bus_Schedule);
//        ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle("Bus Schedules");



        return view;



    }


}
