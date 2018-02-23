package com.example.admin.apptoast;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Forgot_Password extends AppCompatActivity {

    Button btn_submit, btn_login;

    EditText newPassword,confirmPassword;
    String newPass,confirmPass;

    Toolbar myToolbar;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot__password);



        btn_login = findViewById(R.id.btn_login);
        newPassword = findViewById(R.id.edt_newPassword);
        confirmPassword = findViewById(R.id.confirmPassword);

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Forgot_Password.this,Login.class);
                startActivity(i);
            }
        });


        btn_submit = findViewById(R.id.btn_submit);

        btn_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                newPass = newPassword.getText().toString();
                confirmPass = confirmPassword.getText().toString();

                if (TextUtils.isEmpty(newPass) && TextUtils.isEmpty(confirmPass) ) {
                    newPassword.setError("Enter Name ");
                    confirmPassword.setError("Enter Surname");

                }

                else if (newPass != null) {
                    Intent i = new Intent(Forgot_Password.this, Login.class);
                    startActivity(i);
                }

                else if (confirmPass != null) {
                    Intent i = new Intent(Forgot_Password.this, Login.class);
                    startActivity(i);
                }

            }
        });
    }
}
