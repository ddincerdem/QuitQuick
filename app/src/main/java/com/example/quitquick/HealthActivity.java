package com.example.quitquick;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModelProvider;
import androidx.viewpager.widget.ViewPager;

import com.example.quitquick.Entities.Health;
import com.example.quitquick.ViewModels.HealthVM;
import com.google.android.material.tabs.TabLayout;

import java.util.List;

public class HealthActivity extends AppCompatActivity {

    public List<Health> healthList;
    private HealthVM HealthVM;

    private ViewPager viewPager;
    private Button button;
    private SliderPagerAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        HealthVM = new ViewModelProvider(this).get(com.example.quitquick.ViewModels.HealthVM.class);
        healthList = HealthVM.getAllHealth();

        // making activity full screen
        /*if (Build.VERSION.SDK_INT >= 21) {
            getWindow().getDecorView()
                    .setSystemUiVisibility(
                            View.SYSTEM_UI_FLAG_LAYOUT_STABLE | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
        }*/

        setContentView(R.layout.activity_health);

        // bind views
        viewPager = findViewById(R.id.pagerIntroSlider);
        TabLayout tabLayout = findViewById(R.id.tabs);
        //button = findViewById(R.id.button);

        // init slider pager adapter
        adapter = new SliderPagerAdapter(getSupportFragmentManager(),
                FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);

        // set adapter
        viewPager.setAdapter(adapter);

        // set dot indicators
        tabLayout.setupWithViewPager(viewPager);

        // make status bar transparent
        //changeStatusBarColor();
        /*button.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View view) {
                if (viewPager.getCurrentItem() < adapter.getCount()) {
                    viewPager.setCurrentItem(viewPager.getCurrentItem() + 1);
                }
            }
        });*/
        /**
         * Add a listener that will be invoked whenever the page changes
         * or is incrementally scrolled
         */
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }
            @Override public void onPageSelected(int position) {
               /* if (position == adapter.getCount() - 1) {
                    button.setText("Sonraki");
                } else {
                    button.setText("Başa dön.");
                }*/
            }
            @Override public void onPageScrollStateChanged(int state) {
            }
        });
    }
    /*private void changeStatusBarColor() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(Color.TRANSPARENT);
        }
    }*/
}
