package com.example.quitquick;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity {

    EditText mail;
    EditText password;
    Button login;
    Button register;
    Intent intentHome;
    Intent intentRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        mail =(EditText)findViewById(R.id.txtEmail);
        password =(EditText)findViewById(R.id.txtPassword);
        login=(Button)findViewById(R.id.btnLogin);
        register=(Button)findViewById(R.id.btnSignUp);
        intentHome = new Intent(this,HomeActivity.class);
        intentRegister = new Intent(this,RegisterActivity.class);

        SetupClickListener();
        getSupportActionBar().hide();
    }

    public void SetupClickListener(){
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity(intentHome);
            }
        });

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              openActivity(intentRegister);
            }
        });
    }

    public void openActivity(Intent intent){

        startActivity(intent);
    }
}