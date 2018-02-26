package com.example.admin.apptoast;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;



public class CityToCity_TimeTableFragment extends Fragment {

    private View view;
    private Toolbar bus_Schedule;




    public CityToCity_TimeTableFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view =inflater.inflate(R.layout.city_to_city, container, false);





        return view;



    }


}
