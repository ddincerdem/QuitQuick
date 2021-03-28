package com.example.quitquick;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class ProfileActivity extends AppCompatActivity {

    ImageView LogOut;
    Button Update;
    Button Delete;
    ImageView ProfilePic;
    TextView  Name;
    TextView Surname;
    TextView Email;
    TextView Cigars;
    TextView Money;
    Intent intetLogin;
    Intent intentUpdateForm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);


        LogOut = (ImageView)findViewById(R.id.btnLogOut);
        Update = (Button)findViewById(R.id.btnUpdate);
        Delete=(Button)findViewById(R.id.btnDeletAccount);
        ProfilePic=(ImageView)findViewById(R.id.imgProfilePic);
        Name = (TextView)findViewById(R.id.txtProfileName);
        Surname=(TextView)findViewById(R.id.txtProfileSurname);
        Email=(TextView)findViewById(R.id.txtProfileEmail);
        Cigars =(TextView)findViewById(R.id.txtProfileCig);
        Money = (TextView)findViewById(R.id.txtProfileMoney);

        setContentView(R.layout.activity_profile);


    }



}