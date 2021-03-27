package com.example.quitquick;

import android.view.LayoutInflater;
import android.view.View;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.fragment.app.Fragment;

public class form1TabFragment extends Fragment {


    EditText etName,etEmail,etPassword,etPasswordConf;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        ViewGroup root = (ViewGroup) inflater.inflate(R.layout.form1_fragment,container,false);

        etName = root.findViewById(R.id.etName);
        etEmail = root.findViewById(R.id.etEmail);
        etPassword = root.findViewById(R.id.etPassword);
        etPasswordConf = root.findViewById(R.id.etPasswordConf);



        return root;
    }
}
