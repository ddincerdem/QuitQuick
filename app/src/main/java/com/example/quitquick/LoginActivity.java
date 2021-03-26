package com.example.quitquick;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity {

    EditText mail =(EditText)findViewById(R.id.txtEmail);
    EditText password =(EditText)findViewById(R.id.txtPassword);
    Button login=(Button)findViewById(R.id.btnLogin);
    Button register=(Button)findViewById(R.id.btnRegister);
    Intent intentHome = new Intent(this,HomeActivity.class);
    Intent intentRegister = new Intent(this,RegisterActivity.class);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
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