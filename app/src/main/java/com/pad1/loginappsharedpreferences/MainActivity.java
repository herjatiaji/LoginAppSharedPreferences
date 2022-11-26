package com.pad1.loginappsharedpreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView username;
    Button logout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        username = findViewById(R.id.usrnm);
        Intent intent = getIntent();
        String usernm= intent.getStringExtra("usernm");
        username.setText(usernm);
        logout = findViewById(R.id.button_logout);


        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LoginActivity activity = new LoginActivity();
                activity.logout();
                Intent intent1 = new Intent(MainActivity.this,LoginActivity.class);
                startActivity(intent1);

            }
        });



    }
}