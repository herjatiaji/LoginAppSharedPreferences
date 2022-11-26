package com.pad1.loginappsharedpreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
     EditText password;
     EditText username;
    private Boolean isLogin;
    private static SharedPreferences mSharedpref;
    private final String sharedProfile = "com.example.loginappsharedpreferences";
    private static String KEY = "LOGIN_KEY";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        password = findViewById(R.id.editTextPw);
        username = findViewById(R.id.editTextUsername);
        mSharedpref = getSharedPreferences(sharedProfile, MODE_PRIVATE);
        isLogin = mSharedpref.getBoolean(KEY, false);

        if(isLogin){
            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
            startActivity(intent);
        }

        findViewById(R.id.btn_login).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(username.getText().toString().equals("rogersumatra")&& password.getText().toString().equals("12345678")){
                    SharedPreferences.Editor editor = mSharedpref.edit();
                    editor.putBoolean(KEY,true);
                    editor.apply();
                    String usrnm = username.getText().toString();
                    Intent intent =new Intent(LoginActivity.this, MainActivity.class);
                    intent.putExtra("usernm",usrnm);
                    startActivity(intent);
                }
                else{
                    Toast.makeText(getApplicationContext(),"GAGAL LOGIN", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public static void logout(){
        SharedPreferences.Editor editor = mSharedpref.edit();
        editor.putBoolean(KEY,false);
        editor.apply();

    }
}