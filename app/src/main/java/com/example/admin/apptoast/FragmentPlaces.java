package com.example.admin.apptoast;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.location.places.Place;
import com.google.android.gms.location.places.ui.PlaceSelectionListener;
import com.google.android.gms.location.places.ui.SupportPlaceAutocompleteFragment;


/**
 * Created by Admin on 1/26/2018.
 */

public class FragmentPlaces extends Fragment {

    private Spinner spinner1;
    Context context;
    private Button btn_viewprice;
    AlertDialog.Builder builder1;
    Toolbar toolbar_Destination;
    Button btnBuy;


    String to, From;
    String[] trip = {"Pay as you go", "Weekly", "Monthly"};
    String selected;
    int price=0;
    private  View view;

    SupportPlaceAutocompleteFragment mapFragment, mFrom;


    ///fab for special trip
    private FloatingActionButton fbSpecialTrips;

    public FragmentPlaces() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
         view =inflater.inflate(R.layout.fragment, container, false);
       spinner1 =  view.findViewById(R.id.spinner1);
        super.onViewCreated(view, savedInstanceState);
        android.support.v4.app.FragmentManager fm = getChildFragmentManager();
        SupportPlaceAutocompleteFragment mapFragment = (SupportPlaceAutocompleteFragment) fm.findFragmentByTag("mapFragment");





        super.onViewCreated(view, savedInstanceState);
        fm = getChildFragmentManager();
        mapFragment = (SupportPlaceAutocompleteFragment) fm.findFragmentByTag("mapFragment");
        if (mapFragment == null) {
            mapFragment = new SupportPlaceAutocompleteFragment();
            FragmentTransaction ft = fm.beginTransaction();
            ft.add(R.id.fragment_id, mapFragment, "mapFragment");
            ft.commit();
            fm.executePendingTransactions();
        }


        super.onViewCreated(view, savedInstanceState);
        FragmentManager fmFrom = getChildFragmentManager();
        mFrom = (SupportPlaceAutocompleteFragment) fm.findFragmentByTag("mFrom");
        if (mFrom == null) {
            mFrom = new SupportPlaceAutocompleteFragment();
            FragmentTransaction ft = fmFrom.beginTransaction();
            ft.add(R.id.fragment_from, mFrom, "mFrom");
            ft.commit();
            fmFrom.executePendingTransactions();
        }
       // mapFragment.getMapAsync(callback);


        btn_viewprice = view.findViewById(R.id.btn_viewprice);
        fbSpecialTrips = view.findViewById(R.id.fbSpecialTrips);
        btnBuy = view.findViewById(R.id.btnBuy);


        //addListenerOnSpinnerItemSelection();

        // spinner1.setOnItemSelectedListener(this);
        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                selected = trip[i];
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
      /*  ArrayAdapter<String> TripAdapter = new ArrayAdapter<>(getActivity(),R.layout.custom_textview_to_spinner, trip);
       // TripAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        TripAdapter.setDropDownViewResource(R.layout.custom_textview_to_spinner);
        spinner1.setAdapter(TripAdapter);*/





        btnBuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(From!= null) {
                    if(to!= null) {

                            Intent intent = new Intent(getActivity(), PaymentActivity.class);
                            intent.putExtra("from", From);
                            intent.putExtra("to", to);
                            intent.putExtra("trip", selected);
                            intent.putExtra("price", price);
                            startActivity(intent);

                    }else {
                        Toast.makeText(getActivity(), "All field are required", Toast.LENGTH_SHORT).show();
                    }


                }else {
                    Toast.makeText(getActivity(), "All field are required", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btn_viewprice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ViewDialog alert = new ViewDialog();
                if(selected=="Pay as you go") {
                  price =90;
                }

                if(selected=="Weekly") {
                    price =230;

                }

                if(selected=="Monthly") {
                    price =980;

                }


                TripDatabase tripDatabase = new TripDatabase(getActivity());
               //tripDatabase.addContact();
                alert.showDialog(getActivity(), "From: " + From + "\n" + "To: " + to + "\n" + selected + "\n R"+ price + ".00");
            }
        });

//        toolbar_Destination = view.findViewById(R.id.toolbar_Destination);
//        toolbar_Destination.setTitle("Destination");
//        toolbar_Destination.setTitleTextColor(Color.BLACK);
//        toolbar_Destination.setNavigationIcon(getResources().getDrawable(R.drawable.ic_keyboard_arrow_left_black_24dp));
//        toolbar_Destination.setNavigationOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent i = new Intent(getActivity(), LandingBottomActivity.class);
//                startActivity(i);
//            }
//        });


         //places = (PlaceAutocompleteFragment);
               // getActivity().getFragmentManager().findFragmentById(R.id.place_autocomplete_fragment_from);

       // PlaceAutocompleteFragment from = (PlaceAutocompleteFragment);
               // getActivity().getFragmentManager().findFragmentById(R.id.place_autocomplete_fragment_from);

      /*  mapFragment.setHint("To :");

        ((EditText) mapFragment.getView().findViewById(R.id.place_autocomplete_search_input)).setTextSize(14.0f);*/


       /* from.setHint("From :");
        ((EditText) from.getView().findViewById(R.id.place_autocomplete_search_input)).setTextSize(14.0f);*/

        mapFragment.setOnPlaceSelectedListener(new PlaceSelectionListener() {


            @Override
            public void onPlaceSelected(Place place) {

                to = place.getName().toString();
            }

            @Override
            public void onError(Status status) {
                Toast.makeText(getActivity(), "Error " + status.getStatusMessage(), Toast.LENGTH_SHORT).show();
            }

        });

        mFrom.setOnPlaceSelectedListener(new PlaceSelectionListener() {
            @Override
            public void onPlaceSelected(Place place) {


                From = place.getName().toString();


            }

            @Override
            public void onError(Status status) {
                Toast.makeText(getActivity(), "Error " + status.getStatusMessage(), Toast.LENGTH_SHORT).show();
            }

        });
        fbSpecialTrips.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                specialTrips();
            }
        });
        return view;
    }

//
//   public void addListenerOnSpinnerItemSelection() {
//        spinner1 = (Spinner) findViewById(R.id.spinner1);
//        spinner1.setOnItemSelectedListener(new CustomOnItemSelectedListener());
//
//        trip = spinner1.getSelectedItem().toString();
//        Toast.makeText(getApplicationContext(), "" + trip, Toast.LENGTH_SHORT).show();
//

    public class ViewDialog {

        public void showDialog(Activity activity, String msg) {
            final Dialog dialog = new Dialog(activity);
            dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
            dialog.setCancelable(false);
            dialog.setContentView(R.layout.dialog);

            TextView text = (TextView) dialog.findViewById(R.id.text_dialog);
            text.setText(msg);

            Button dialogButton = (Button) dialog.findViewById(R.id.btn_dialog);
            dialogButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    dialog.dismiss();
                }
            });

            dialog.show();

        }
    }

    public void specialTrips() {
        Intent intent = new Intent(getActivity(), SpecialTripsActivity.class);
        startActivity(intent);
    }

}
