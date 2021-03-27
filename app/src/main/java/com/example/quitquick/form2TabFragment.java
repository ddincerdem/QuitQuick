package com.example.quitquick;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;

public class form2TabFragment extends Fragment {

    Button btnStart,btnQuit;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        ViewGroup root = (ViewGroup) inflater.inflate(R.layout.form2_fragment,container,false);

        btnStart=root.findViewById(R.id.btnPickStart);
        btnQuit=root.findViewById(R.id.btnPickQuickDate);

        btnQuit.setOnClickListener(v -> {


            DialogFragment picker = new DatePicker();

            picker.show(getFragmentManager(), "datePicker");

        });

        btnStart.setOnClickListener(v -> {

            DialogFragment picker = new DatePicker();

            picker.show(getFragmentManager(), "datePicker");

        });




        return root;
    }

}
