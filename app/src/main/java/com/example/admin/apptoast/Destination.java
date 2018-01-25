package com.example.admin.apptoast;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

public class Destination extends AppCompatActivity {

    private Spinner spinner1;
    Context context;
    private Button btn_viewprice;
    AlertDialog.Builder builder1;
    Toolbar myToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_destination);
        spinner1 = (Spinner) findViewById(R.id.spinner1);
        btn_viewprice = findViewById(R.id.btn_viewprice);

        addListenerOnSpinnerItemSelection();
        btn_viewprice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ViewDialog alert = new ViewDialog();
                alert.showDialog(Destination.this, "Your current Destination \n Where you are going \n Trip : Monthly \n Price: R980.00");
            }
        });

        myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        myToolbar.setTitle("Destination");
        myToolbar.setTitleTextColor(Color.WHITE);
        setSupportActionBar(myToolbar);


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


}
