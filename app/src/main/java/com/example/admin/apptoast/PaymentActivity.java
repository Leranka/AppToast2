package com.example.admin.apptoast;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import io.netopen.hotbitmapgg.library.view.RingProgressBar;

public class PaymentActivity extends AppCompatActivity {

    private String From, to, trip;
    int price;
    private String[] Month = new String[]{
            "Month",
            "January",
            "February",
            "March",
            "April",
            "May",
            "June",
            "July",
            "August",
            "September",
            "October",
            "November",
            "December",

    };
    private String[] year = new String[]{
            "Year",
            "2018",
            "2019",
            "2020",
            "2021",
            "2022",
            "2023",


    };

    private Spinner spinnerMonth, spinnerYear;
    private Button btnCorfom;

    //declaring for a dialog
    private Button btnOk;
    private TextView tvDay,txt_jhb, txt_from, txt_trip, txt_price;
    private ImageView ivIcon;
    private RingProgressBar ringProgressBar2;
    private TextView Loading;
    int progress = 0;
    Handler myHandler = new Handler() {

        @Override
        public void handleMessage(Message msg) {
            if (msg.what == 0) {
                if (progress < 100) {
                    progress++;
                    // ringProgressBar1.setProgress(progress);
                    ringProgressBar2.setProgress(progress);

                }
            }
        }
    };

    //toolbar
    private Toolbar tbPayment;

    EditText edCardNumber;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);

        txt_jhb = findViewById(R.id.jhb);
        txt_from = findViewById(R.id.from);
        txt_trip = findViewById(R.id.trip);
        txt_price = findViewById(R.id.price);

        Intent i = getIntent();
        From = i.getStringExtra("from");
        to = i.getStringExtra("to");
        trip = i.getStringExtra("trip");
        price = i.getIntExtra("price", 00);

        txt_from.setText(From);
        txt_jhb.setText(to);
        txt_trip.setText(trip);
        txt_price.setText("R" +Integer.toString(price) + ".00");
/**
 * SETS EDITTEXT TO MAKE SPACE IN BETWEEN FOUR NUMBERS
 */
        edCardNumber = findViewById(R.id.edCardNumber);
        edCardNumber.addTextChangedListener(new FourDigitCardFormatWatcher());


        //Payment toolbar
        tbPayment = findViewById(R.id.tbPayment);
        tbPayment.setTitle("Payment");
        setSupportActionBar(tbPayment);
        tbPayment.setNavigationIcon(getResources().getDrawable(R.drawable.ic_keyboard_arrow_left_black_24dp));
        tbPayment.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), LandingBottomActivity.class);
                startActivity(i);
            }
        });


        //declare Spinner
        spinnerMonth = (Spinner) findViewById(R.id.spinnerMonth);
        spinnerYear = (Spinner) findViewById(R.id.spinnerYear);
        //btn to coform
        btnCorfom = (Button) findViewById(R.id.btnCorfom);

        btnCorfom.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        getBookDialog();
                    }
                });

        List<String> monthList = new ArrayList<>(Arrays.asList(Month));
        List<String> yearList = new ArrayList<>(Arrays.asList(year));

        // Initializing an ArrayAdapter for month
        final ArrayAdapter<String> spinnerArrayAdapter = new ArrayAdapter<String>(
                this, R.layout.spinner_item, monthList) {
            @Override
            public boolean isEnabled(int position) {
                if (position == 0) {
                    // Disable the first item from Spinner
                    // First item will be use for hint
                    return false;
                } else {
                    return true;
                }
            }

            @Override
            public View getDropDownView(int position, View convertView,
                                        ViewGroup parent) {
                View view = super.getDropDownView(position, convertView, parent);
                TextView tv = (TextView) view;
                if (position == 0) {
                    // Set the hint text color gray
                    tv.setTextColor(Color.GRAY);
                } else {
                    tv.setTextColor(Color.BLACK);
                }
                return view;
            }
        };


        spinnerArrayAdapter.setDropDownViewResource(R.layout.spinner_item);
        spinnerMonth.setAdapter(spinnerArrayAdapter);

        spinnerMonth.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedItemText = (String) parent.getItemAtPosition(position);
                // If user change the default selection
                // First item is disable and it is used for hint
                if (position > 0) {
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

        // Initializing an ArrayAdapter
        final ArrayAdapter<String> spinnerArrayAdapterYear = new ArrayAdapter<String>(
                this, R.layout.spinner_item, yearList) {
            @Override
            public boolean isEnabled(int position) {
                if (position == 0) {
                    // Disable the first item from Spinner
                    // First item will be use for hint
                    return false;
                } else {
                    return true;
                }
            }

            @Override
            public View getDropDownView(int position, View convertView,
                                        ViewGroup parent) {
                View view = super.getDropDownView(position, convertView, parent);
                TextView tv = (TextView) view;
                if (position == 0) {
                    // Set the hint text color gray
                    tv.setTextColor(Color.GRAY);
                } else {
                    tv.setTextColor(Color.BLACK);
                }
                return view;
            }
        };
        spinnerArrayAdapterYear.setDropDownViewResource(R.layout.spinner_item);
        spinnerYear.setAdapter(spinnerArrayAdapterYear);

        spinnerYear.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedItemText = (String) parent.getItemAtPosition(position);
                // If user change the default selection
                // First item is disable and it is used for hint
                if (position > 0) {
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
    }

    private void getBookDialog() {


        ///DIALOG BOX INITIALIZATION
        AlertDialog.Builder mBuilder = new AlertDialog.Builder(PaymentActivity.this);
        mBuilder.setCancelable(false);
        View mView = getLayoutInflater().inflate(R.layout.conform_payment_dialog, null);


        tvDay = mView.findViewById(R.id.tvDay);
        ivIcon = mView.findViewById(R.id.ivIcon);
        btnOk = mView.findViewById(R.id.btnOk);

        //Date, department

        Date currentTimes = Calendar.getInstance().getTime();
        final DateFormat dateFormats = new SimpleDateFormat("dd MMM yyyy");


        ringProgressBar2 = mView.findViewById(R.id.progress_bar_2);
        Loading = mView.findViewById(R.id.Loading);


        new Thread(new Runnable() {
            @Override
            public void run() {

                for (int i = 0; i < 100; i++) {
                    try {
                        Thread.sleep(50);
                        myHandler.sendEmptyMessage(0);

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                myHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        Loading.setVisibility(View.GONE);
                        ivIcon.setVisibility(View.VISIBLE);
                        tvDay.setVisibility(View.VISIBLE);

                        if (progress >= 100) {
                            btnOk.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    btnOk.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View view) {


//
                                            Intent intents = new Intent(PaymentActivity.this, LandingBottomActivity.class);
                                            startActivity(intents);

                                        }
                                    });
                                }
                            });
                        }

                    }
                });
            }
        }).start();


        mBuilder.setView(mView);
        AlertDialog dialog = mBuilder.create();
        dialog.show();
        // DIALOG END
    }


}
