package com.example.admin.apptoast;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

public class Signup extends AppCompatActivity {
    private Button btn_login, btn_signingup;
    private TextView txt_forgotPW;

    private ImageButton imBack;
    ImageButton back_arrow;

    EditText name,surname,cell,email,address;
    String names,surnames,cells,emails,addresses;


    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);


        name = findViewById(R.id.edt_name);
        surname = findViewById(R.id.edt_surname);
        cell = findViewById(R.id.edt_cell);
        email = findViewById(R.id.edt_email);
        address = findViewById(R.id.edt_address);
        //back_arrow = findViewById(R.id.back_arrow);



//        btn_login = findViewById(R.id.btn_login);
        btn_signingup = findViewById(R.id.btn_signingup);
//        txt_forgotPW = findViewById(R.id.txt_forgotPW);

//        btn_login.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent i = new Intent(Signup.this,LandingBottomActivity.class);
//                startActivity(i);
//            }
//        });


        btn_signingup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                names = name.getText().toString();
                surnames = surname.getText().toString();
                cells = cell.getText().toString();
                emails = email.getText().toString();
                addresses = address.getText().toString();

                if (TextUtils.isEmpty(names) && TextUtils.isEmpty(surnames) && TextUtils.isEmpty(cells) && TextUtils.isEmpty(emails) && TextUtils.isEmpty(addresses)) {
                    name.setError("Enter Name ");
                    surname.setError("Enter Surname");
                    cell.setError("Enter Cellphone number ");
                    email.setError("Enter Email");
                    address.setError("Enter Address ");

                }

                else if (names != null) {
                    Intent i = new Intent(Signup.this, Landing.class);
                    startActivity(i);
                }

                else if (surnames != null) {
                    Intent i = new Intent(Signup.this, Landing.class);
                    startActivity(i);
                }
                else if (cells != null) {
                    Intent i = new Intent(Signup.this, Landing.class);
                    startActivity(i);
                }

                else if (emails != null) {
                    Intent i = new Intent(Signup.this, Landing.class);
                    startActivity(i);
                }

                else if (addresses != null) {
                    Intent i = new Intent(Signup.this, Landing.class);
                    startActivity(i);
                }


            }
        });
    }
}
