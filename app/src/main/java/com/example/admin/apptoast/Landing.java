package com.example.admin.apptoast;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class Landing extends Fragment{

    LinearLayout citytocity, putco, reavaya, metrobus;
    ImageView profile;
    private View view;

    public Landing() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater,  ViewGroup container, Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.activity_landing, container, false);

        citytocity = view.findViewById(R.id.layout_citytocity);
        putco = view.findViewById(R.id.layout_putco);
        reavaya = view.findViewById(R.id.layout_reavaya);
        metrobus = view.findViewById(R.id.layout_metrobus);


        citytocity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getActivity(),Destination.class);
                startActivity(i);
            }
        });

        putco.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getActivity(),Destination.class);
                startActivity(i);
            }
        });

        reavaya.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getActivity(),Destination.class);
                startActivity(i);
            }
        });

        metrobus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getActivity(),Destination.class);
                startActivity(i);
            }
        });

//
        return view;
    }


}
