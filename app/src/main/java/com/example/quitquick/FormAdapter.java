package com.example.quitquick;


import android.content.Context;


import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.lang.reflect.Constructor;

public class FormAdapter extends FragmentPagerAdapter {
    public Context context;
    int totalTabs;

    public FormAdapter(FragmentManager fm, Context context, int totalTabs) {
        super(fm);
        this.context = context;
        this.totalTabs = totalTabs;
    }

    @Override
    public int getCount() {
        return totalTabs;
    }

    public Fragment getItem(int position){
        switch (position){
        case 0:
            form1TabFragment frm1 = new form1TabFragment();
            return frm1;
        case 1:
            form2TabFragment frm2 = new form2TabFragment();
            return frm2;
            default:return null;   }
    }
}
