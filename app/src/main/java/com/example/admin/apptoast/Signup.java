package com.example.admin.apptoast;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Signup extends AppCompatActivity {
    private Button btn_login, btn_signingup;
    private TextView txt_forgotPW;

Toolbar myToolbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);


        myToolbar =  findViewById(R.id.myToolbar);
        myToolbar.setTitle(" ");
        setSupportActionBar(myToolbar);
        myToolbar.setNavigationIcon(getResources().getDrawable(R.drawable.ic_keyboard_arrow_left_black_24dp));
        myToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),Login.class);
                startActivity(i);
            }
        });



        btn_login = findViewById(R.id.btn_login);
        btn_signingup = findViewById(R.id.btn_signingup);
        txt_forgotPW = findViewById(R.id.txt_forgotPW);

//        btn_login.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent i = new Intent(Signup.this,LandingBottomActivity.class);
//                startActivity(i);
//            }
//        });

//        txt_forgotPW.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent i = new Intent(Signup.this,Forgot_Password.class);
//                startActivity(i);
//            }
//        });

        btn_signingup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Signup.this,LandingBottomActivity.class);
                startActivity(i);
            }
        });
    }
}
