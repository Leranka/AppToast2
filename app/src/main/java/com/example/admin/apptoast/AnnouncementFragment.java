package com.example.admin.apptoast;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


public class AnnouncementFragment extends Fragment {
    private View view;

    private String[] title ={"Delay","Strike","Change of Route","New Station"};
    private String[] description ={"Delay due to right turnsThis type of delay occurs when buses aretraveling in the curb lane and a queue of right-turning vehicles blocks the bus from movingforward.overcome by relocating bus stops to the far sideof the intersection.",
                            "Cape Town - Commuters in Cape Town and Pretoria have been affected by a taxi strike on Monday Buses in Cape Town have also been affected by the taxi strike, resulting in delays.",
                            "From Soweto the will be change of route due to construction taking over at Vilakazi, Ohlanga and David street passanger are advice to go to jabu street catch the Putco",
                            "The new station is at Pretoria bus station is next to Pretoria’s train station. You will also find the major companies’ booking and information offices here as well as a good cafe and an ATM."};
    private String date[] ={"06-April-2017","28-March-2017","25-March-2017","08-March-2017"};
    private AnnouncementPojo announcement;
    private List<AnnouncementPojo> announcements;
    private RecyclerView listAnnounce;
    private LinearLayoutManager layoutManager;




    public AnnouncementFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view =inflater.inflate(R.layout.fragment_announcement, container, false);

        listAnnounce =(RecyclerView) view.findViewById(R.id.ggg);

            announcement = new AnnouncementPojo();
            announcements =new ArrayList<>();
        for ( int i = 0; i < title.length; i++) {

            announcement.setTitle(title[i]);
            announcement.setDate(date[i]);
            announcement.setDescription(description[i]);

            announcements.add(announcement);
            Toast.makeText(getActivity(),  ""+ announcements.get(i).getTitle(), Toast.LENGTH_SHORT).show();


        }
        AnnouncementAdapter announcementAdapter = new AnnouncementAdapter(getActivity(),announcements);

        layoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        listAnnounce.setLayoutManager(layoutManager);

        listAnnounce.setAdapter(announcementAdapter);





            return view;
    }


}
