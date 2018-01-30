package com.example.admin.apptoast;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.location.places.Place;
import com.google.android.gms.location.places.ui.PlaceAutocompleteFragment;
import com.google.android.gms.location.places.ui.PlaceSelectionListener;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


public class SpecialTripsActivity extends AppCompatActivity {
    //declare variables
    private Spinner spinnerEvent;
    private int positionget;

    //String  event for s
    private String[] events = {"Select type of event","Funeral","School trip","tours", "excursions", "council events","Others" };

    //TextView for Date
    private TextView btn_start,btn_end;

    // variables to save user selected date and time
    public  int year,month,day,hour,minute;

    // declare  the variables to Show/Set the date and time when Time and  Date Picker Dialog first appears
    private int mYear, mMonth, mDay,mHour,mMinute;
    //btn
    private Button btn_viewpriceSp,btnBuyNowSp;

    //EditText
    private EditText tvToSpecialTrip;

    static final int DATE_DIALOG_ID = 0;

    ///String to check if the date is  select
    private int firstDate,secondDate;

    public SpecialTripsActivity()
    {
        // Assign current Date and Time Values to Variables
        final Calendar c = Calendar.getInstance();
        mYear = c.get(Calendar.YEAR);
        mMonth = c.get(Calendar.MONTH);
        mDay = c.get(Calendar.DAY_OF_MONTH);
        mHour = c.get(Calendar.HOUR_OF_DAY);
        mMinute = c.get(Calendar.MINUTE);
    }




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_special_trips);

        spinnerEvent = (Spinner) findViewById(R.id.spinnerEvent);
        //edit
        btn_start =(TextView) findViewById(R.id.btn_start);
        btn_end =(TextView)findViewById(R.id.btn_end);

        //btn
        btn_viewpriceSp =findViewById(R.id.btn_viewpriceSp);
        btnBuyNowSp =findViewById(R.id.btnBuyNowSp);

        //edittext declaration for destination
        //tvToSpecialTrip =findViewById(R.id.tvToSpecialTrip);


        // Initializing an ArrayAdapter for event
        final ArrayAdapter<String> spinnerArrayAdapter = new ArrayAdapter<String>(
                this,R.layout.spinner_item,events){
            @Override
            public boolean isEnabled(int position){
                if(position == 0)
                {
                    // Disable the first item from Spinner
                    // First item will be use for hint
                    return false;
                }
                else
                {
                    return true;
                }
            }
            @Override
            public View getDropDownView(int position, View convertView,
                                        ViewGroup parent) {
                View view = super.getDropDownView(position, convertView, parent);
                TextView tv = (TextView) view;
                if(position == 0){
                    // Set the hint text color gray
                    tv.setTextColor(Color.GRAY);
                }
                else {
                    tv.setTextColor(Color.BLACK);
                }
                return view;
            }
        };


        //set a spinner

        spinnerArrayAdapter.setDropDownViewResource(R.layout.spinner_item);
        spinnerEvent.setAdapter(spinnerArrayAdapter);

        //set a spinner
        spinnerEvent.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedItemText = (String) parent.getItemAtPosition(position);
                // If user change the default selection
                // First item is disable and it is used for hint
                positionget =position;
                if(position > 0){
                    // Notify the selected item text
                    Toast.makeText
                            (getApplicationContext(), "Selected : " + selectedItemText, Toast.LENGTH_SHORT)
                            .show();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        btn_start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDialog(DATE_DIALOG_ID);
                Calendar cal = Calendar.getInstance();
                cal.set(year,month,day);
                Date currentTime = cal.getTime();
                secondDate=year;

                DateFormat dateFormat = new SimpleDateFormat("dd MMM yyyy");
                String date =  dateFormat.format(currentTime).toString();
                btn_start.setHint(date);
            }
        });

        btn_end.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDialog(DATE_DIALOG_ID);
                Calendar cal = Calendar.getInstance();
                firstDate=year;
                cal.set(year,month,day);

                Date currentTime = cal.getTime();

                DateFormat dateFormat = new SimpleDateFormat("dd MMM yyyy");
                String date =  dateFormat.format(currentTime).toString();
                btn_end.setHint(date);
            }
        });



        //view price
        btn_viewpriceSp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SpecialTripsActivity.ViewDialog alert = new SpecialTripsActivity.ViewDialog();
                alert.showDialog(SpecialTripsActivity.this, "Your current Destination \n Where you are going \n Trip : two Days \n Price: R10 00.00");
            }
        });


        // btn to buy
        btnBuyNowSp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(positionget==0)     {
                    // validate the spinner
                    Snackbar snackbar = Snackbar.make(view, "Select Type of event", Snackbar.LENGTH_LONG);

                    snackbar.show();
                }

                String tripTo =  tvToSpecialTrip.getText().toString();
                if(tripTo.isEmpty())
                {
                    tvToSpecialTrip.setError("Destination can not be empty");
                }else {

                    if (firstDate == 0) {
                        Snackbar snackbar = Snackbar.make(view, "Select First date ", Snackbar.LENGTH_LONG);

                        snackbar.show();
                    }else {
                        if (firstDate == 0) {
                            Snackbar snackbar = Snackbar.make(view, "Select Second date ", Snackbar.LENGTH_LONG);

                            snackbar.show();
                        }else {
                            SpecialTripsActivity.ViewDialog alert = new SpecialTripsActivity.ViewDialog();
                            alert.showDialog(SpecialTripsActivity.this, " Special Trip have been booked \n We are  still processing your application\n we will get back to you Soon..");
                        }
                    }
                }





            }
        });


        //fragement place
        PlaceAutocompleteFragment places = (PlaceAutocompleteFragment)
                getFragmentManager().findFragmentById(R.id.tvSpecialTripTo);

        PlaceAutocompleteFragment from = (PlaceAutocompleteFragment)
                getFragmentManager().findFragmentById(R.id.tvSpecialTripFrom);

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


    }

    // Register  DatePickerDialog listener
    private DatePickerDialog.OnDateSetListener mDateSetListener =
            new DatePickerDialog.OnDateSetListener() {
                // the callback received when the user "sets" the Date in the DatePickerDialog
                public void onDateSet(DatePicker view, int yearSelected,
                                      int monthOfYear, int dayOfMonth) {
                    year = yearSelected;
                    month = monthOfYear;
                    day = dayOfMonth;
                    Calendar cal = Calendar.getInstance();
                    cal.set(yearSelected,monthOfYear,dayOfMonth);
                    Date currentTime = cal.getTime();

                    DateFormat dateFormat = new SimpleDateFormat("dd MMM yyyy");
                    String date =  dateFormat.format(currentTime).toString();

                    Toast.makeText(SpecialTripsActivity.this, ""+date, Toast.LENGTH_SHORT).show();
                    // Set the Selected Date in Select date Button
                    //  btnSelectDate.setText("Date selected : "+dateFormat);
                }
            };

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

    // Method automatically gets Called when you call showDialog()  method
    @Override
    protected Dialog onCreateDialog(int id) {
        switch (id) {
            case DATE_DIALOG_ID:
                // create a new DatePickerDialog with values you want to show
                return new DatePickerDialog(this,
                        mDateSetListener,
                        mYear, mMonth, mDay);



        }
        return null;
    }

    private void setSpinnerError(Spinner spinner, String error){
        View selectedView = spinner.getSelectedView();
        if (selectedView != null && selectedView instanceof TextView) {
            spinner.requestFocus();
            TextView selectedTextView = (TextView) selectedView;
            selectedTextView.setError("error"); // any name of the error will do
            selectedTextView.setTextColor(Color.RED); //text color in which you want your error message to be displayed
            selectedTextView.setText(error); // actual error message
            spinner.performClick(); // to open the spinner list if error is found.

        }
    }
}