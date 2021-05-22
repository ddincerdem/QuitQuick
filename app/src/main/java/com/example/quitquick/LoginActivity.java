package com.example.quitquick;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.quitquick.Entities.User;
import com.example.quitquick.ViewModels.UserVM;

public class LoginActivity extends AppCompatActivity {

    EditText mail;
    EditText password;
    Button login;
    Button register;
    Intent intentHome;
    Intent intentRegister;
    UserVM uservm;
    User userToLogin;
    User user;
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
        uservm = new ViewModelProvider(this).get(com.example.quitquick.ViewModels.UserVM.class);
        SetupClickListener();
//        getSupportActionBar().hide();
    }

    public void SetupClickListener(){
        login.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                String email = mail.getText().toString();
                String parola = password.getText().toString();

                if (email.equals("") || email == null )
                {
                    Toast.makeText(getApplicationContext(), "E-Mail Girmediniz", Toast.LENGTH_SHORT).show();
                }
                if( parola.equals("") || parola == null){
                    Toast.makeText(getApplicationContext(), "Parola Girmediniz", Toast.LENGTH_SHORT).show();
                }
                else{

                    if (uservm.findUserByEmailAndPassword(email,parola) != null)
                    {

                        userToLogin = uservm.findUserByEmailAndPassword(email,parola);
                        user = new User(userToLogin);
                        openActivity(intentHome);

                    }else{

                        Toast.makeText(getApplicationContext(), "Parolaniz veya E-Mail Hatali", Toast.LENGTH_SHORT).show();
                    }
                }
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