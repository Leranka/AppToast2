package com.example.admin.apptoast;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

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
    private AnnouncementPojo announcement,announcement1,announcement2,announcement3,announcement4;
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
        announcements =new ArrayList<>();
        FirebaseApp.initializeApp(getActivity());
        DatabaseReference databaseItems = FirebaseDatabase.getInstance().getReference("Announcement");



                    listAnnounce =(RecyclerView) view.findViewById(R.id.ggg);

                    announcement = new AnnouncementPojo();

                    announcement.setTitle("New Station");
                    announcement.setDate("25 May 2017");
                    announcement.setDescription("\"The new station is at Pretoria bus station is next to Pretoria’s train station. You will also find the major companies’ booking and information offices here as well as a good cafe and an ATM.");
                    announcement1 = new AnnouncementPojo();

                    announcement1.setTitle("Change of Route");
                    announcement1.setDate("10 May 2018");
                    announcement1.setDescription("Cape Town - Commuters in Cape Town and Pretoria have been affected by a taxi strike on Monday Buses in Cape Town have also been affected by the taxi strike, resulting in delays.");


                    announcement2 = new AnnouncementPojo();
                    announcement3 = new AnnouncementPojo();
                    announcement4 = new AnnouncementPojo();

                    announcement2.setTitle("New Station");
                    announcement2.setDate("25 May 2017");
                    announcement2.setDescription("The new station is at Pretoria bus station is next to Pretoria’s train station. You will also find the major companies’ booking and information offices here as well as a good cafe and an ATM.");


                    announcement3.setTitle("New Station");
                    announcement3.setDate("31 May 2018");
                    announcement3.setDescription("From Soweto the will be change of route due to construction taking over at Vilakazi, Ohlanga and David street passanger are advice to go to jabu street catch the Putco");

                    announcement4.setTitle("Delay");
                    announcement4.setDate("10 May 2018");
                    announcement4.setDescription("Delay due to right turnsThis type of delay occurs when buses aretraveling in the curb lane and a queue of right-turning vehicles blocks the bus from movingforward.overcome by relocating bus stops to the far sideof the intersection.");

                    announcements.add(announcement);
                    announcements.add(announcement1);

                    announcements.add(announcement2);
                    announcements.add(announcement3);
                    announcements.add(announcement4);

//

                    layoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);


                AnnouncementAdapter announcementAdapter = new AnnouncementAdapter(getActivity(),announcements);

                layoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
//                DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(listAnnounce.getContext(),
//                        layoutManager.getOrientation());
//                listAnnounce.addItemDecoration(dividerItemDecoration);

                listAnnounce.setLayoutManager(layoutManager);


                listAnnounce.setAdapter(announcementAdapter);

//
//
//
//        }


            return view;
    }

//    private void runLayoutAnimation(final RecyclerView recyclerView) {
//        final Context context = recyclerView.getContext();
//        final LayoutAnimationController controller =
//                AnimationUtils.loadLayoutAnimation(context, R.anim.layout_animation_fall_down);
//
//        recyclerView.setLayoutAnimation(controller);
//        recyclerView.getAdapter().notifyDataSetChanged();
//        recyclerView.scheduleLayoutAnimation();
//    }


}
