package com.example.admin.apptoast;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.location.places.Place;
import com.google.android.gms.location.places.ui.PlaceAutocompleteFragment;
import com.google.android.gms.location.places.ui.PlaceSelectionListener;


/**
 * Created by Admin on 1/26/2018.
 */

public class FragmentPlaces extends AppCompatActivity {

    private Spinner spinner1;
    Context context;
    private Button btn_viewprice;
    AlertDialog.Builder builder1;
    Toolbar toolbar_Destination;
    Button btnBuy;

    ///fab for special trip
    private FloatingActionButton fbSpecialTrips;

    public FragmentPlaces() {
    }


    @SuppressLint("ResourceAsColor")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment);

        spinner1 = (Spinner) findViewById(R.id.spinner1);
        btn_viewprice = findViewById(R.id.btn_viewprice);
        fbSpecialTrips =findViewById(R.id.fbSpecialTrips);
        btnBuy =findViewById(R.id.btnBuy);

        addListenerOnSpinnerItemSelection();

        btnBuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent  intent = new Intent(getApplicationContext(),PaymentActivity.class);
                startActivity(intent);
            }
        });

        btn_viewprice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ViewDialog alert = new ViewDialog();
                alert.showDialog(FragmentPlaces.this, "From: Randburg \n To: Pretoria \n Trip: Monthly \n Price: R980.00");
            }
        });

        toolbar_Destination = findViewById(R.id.toolbar_Destination);
        toolbar_Destination.setTitle("Destination");
        toolbar_Destination.setTitleTextColor(Color.BLACK);
        toolbar_Destination.setNavigationIcon(getResources().getDrawable(R.drawable.ic_keyboard_arrow_left_black_24dp));
        toolbar_Destination.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),LandingBottomActivity.class);
                startActivity(i);
            }
        });



        PlaceAutocompleteFragment places = (PlaceAutocompleteFragment)
                getFragmentManager().findFragmentById(R.id.place_autocomplete_fragment);

        PlaceAutocompleteFragment from = (PlaceAutocompleteFragment)
                getFragmentManager().findFragmentById(R.id.place_autocomplete_fragment_from);

        places.setHint("To :");

        ((EditText) places.getView().findViewById(R.id.place_autocomplete_search_input)).setTextSize(14.0f);



        from.setHint("From :");
        ((EditText) from.getView().findViewById(R.id.place_autocomplete_search_input)).setTextSize(14.0f);

        places.setOnPlaceSelectedListener(new PlaceSelectionListener() {


            @Override
            public void onPlaceSelected(Place place) {

                Toast.makeText(getApplicationContext(), place.getName(), Toast.LENGTH_SHORT).show();


            }

            @Override
            public void onError(Status status) {
                Toast.makeText(getApplicationContext(), "Error " + status.getStatusMessage(), Toast.LENGTH_SHORT).show();
            }

        });

        from.setOnPlaceSelectedListener(new PlaceSelectionListener() {
            @Override
            public void onPlaceSelected(Place place) {

                Toast.makeText(getApplicationContext(), place.getName(), Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onError(Status status) {
                Toast.makeText(getApplicationContext(), "Error " + status.getStatusMessage(), Toast.LENGTH_SHORT).show();
            }

        });
        fbSpecialTrips.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                specialTrips();
            }
        });

    }


    public void addListenerOnSpinnerItemSelection() {
        spinner1 = (Spinner) findViewById(R.id.spinner1);
        spinner1.setOnItemSelectedListener(new CustomOnItemSelectedListener());
    }

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

    public  void specialTrips()
    {
        Intent intent =new Intent(FragmentPlaces.this,SpecialTripsActivity.class);
        startActivity(intent);
    }



}
