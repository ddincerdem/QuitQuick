package com.example.quitquick;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import java.util.Calendar;
import java.util.Date;

public class form2TabFragment extends Fragment {

    Button btnReturn;
    ViewPager viewPager;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        ViewGroup root = (ViewGroup) inflater.inflate(R.layout.form2_fragment,container,false);


       btnReturn=root.findViewById(R.id.btnReturn);

        btnReturn.setOnClickListener(v -> {
            viewPager=getActivity().findViewById(R.id.view_pager);
            viewPager.setCurrentItem(0);

        });


        return root;
    }

}
