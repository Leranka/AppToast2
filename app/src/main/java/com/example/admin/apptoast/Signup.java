package com.example.admin.apptoast;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class Signup extends AppCompatActivity {
    private Button btn_login, btn_signingup;
    private TextView txt_forgotPW;

    private ImageButton imBack;


    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);


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
                Intent i = new Intent(Signup.this,LandingBottomActivity.class);
                startActivity(i);
            }
        });
    }
}
