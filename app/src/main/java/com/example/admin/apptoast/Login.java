package com.example.admin.apptoast;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Login extends AppCompatActivity {

    private Button btn_login;
    private TextView btn_signup;
    private TextView txt_forgotPW;
    EditText username, password;

    String usernames, passwords;

    Boolean user, pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        btn_login = findViewById(R.id.btn_login);
        btn_signup = findViewById(R.id.btn_signup);
        txt_forgotPW = findViewById(R.id.txt_forgotPW);


        username = findViewById(R.id.edt_username);
        password = findViewById(R.id.edt_password);


        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                usernames = username.getText().toString();

                if (TextUtils.isEmpty(usernames) && TextUtils.isEmpty(passwords)) {
                    username.setError("Enter username ");
                    password.setError("Enter password");
                }

                else if (usernames != null) {
                    Intent i = new Intent(Login.this, Landing.class);
                    startActivity(i);
                }

                else if (passwords != null){
                    Intent i = new Intent(Login.this, Landing.class);
                    startActivity(i);
                }

            }
        });


        btn_signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Login.this, Signup.class);
                startActivity(i);
            }
        });

        txt_forgotPW.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Login.this, Forgot_Password.class);
                startActivity(i);
            }
        });
    }
}
