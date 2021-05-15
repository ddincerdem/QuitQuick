package com.example.quitquick;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;


import android.os.Bundle;


import com.google.android.material.tabs.TabLayout;


public class RegisterActivity extends AppCompatActivity {
    TabLayout tabLayout;
    ViewPager viewPager;

   // Button btnNext,btnStart,btnQuit;
    float vv = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        //btnNext = findViewById(R.id.btnNext);
        viewPager = findViewById(R.id.view_pager);
        tabLayout =  findViewById(R.id.tab_layout);


        tabLayout.addTab(tabLayout.newTab().setText("Kişisel Bilgiler"));
        tabLayout.addTab(tabLayout.newTab().setText("Bağımlılık Formu"));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        FormAdapter adp = new FormAdapter(getSupportFragmentManager(), this, tabLayout.getTabCount());
        viewPager.setAdapter(adp);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));

       // btnNext.setTranslationY(300);
        tabLayout.setTranslationY(300);


       // btnNext.setAlpha(vv);
        tabLayout.setAlpha(vv);

        //btnNext.animate().translationY(0).alpha(1).setDuration(1000).setStartDelay(400).start();
        tabLayout.animate().translationY(0).alpha(1).setDuration(1000).setStartDelay(600).start();





    }

}
