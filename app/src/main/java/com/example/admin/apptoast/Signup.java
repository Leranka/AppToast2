package com.example.admin.apptoast;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class Signup extends AppCompatActivity {
    private Button btn_signingup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        btn_signingup = findViewById(R.id.btn_signingup);

        btn_signingup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Signup.this,LandingBottomActivity.class);
                startActivity(i);
            }
        });
    }
}
