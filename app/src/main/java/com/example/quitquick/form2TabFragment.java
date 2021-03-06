package com.example.quitquick;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.viewpager.widget.ViewPager;

import com.example.quitquick.Models.User;
import com.example.quitquick.ViewModels.UserVM;

public class form2TabFragment extends Fragment {

    Button btnReturn,btnRegister;
    ViewPager viewPager;
    EditText etDateStarted, etSmokesPerDay,etPriceForPack,etCigsPerPack;
    TextView tvDateStarted, tvSmokesPerday,tvPriceForPack,tvCigsPerPack,tvErrorF2;
    private UserVM UserVM;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        ViewGroup root = (ViewGroup) inflater.inflate(R.layout.form2_fragment,container,false);
        UserVM = new ViewModelProvider(this).get(com.example.quitquick.ViewModels.UserVM.class);

       btnReturn=root.findViewById(R.id.btnReturn);
       etDateStarted = root.findViewById(R.id.etDateStarted);
       etSmokesPerDay = root.findViewById(R.id.etSmokesPerDay);
       etPriceForPack = root.findViewById(R.id.etPriceForPack);
       etCigsPerPack = root.findViewById(R.id.etCigPerPack);

       tvDateStarted = root.findViewById(R.id.tvStartedSmoking);
       tvSmokesPerday = root.findViewById(R.id.tvSmokesPerDay);
       tvPriceForPack = root.findViewById(R.id.tvCigPrice);
       tvCigsPerPack = root.findViewById(R.id.tvCigsInPack);
       tvErrorF2 = root.findViewById(R.id.tvErrorF2);

       btnRegister = root.findViewById(R.id.btnRegister);

       btnReturn.setOnClickListener(v -> {
            viewPager=getActivity().findViewById(R.id.view_pager);
            viewPager.setCurrentItem(0);

        });

        btnRegister.setOnClickListener(v -> {

        if (!isEmptyDate(etDateStarted.getText().toString())){

            tvDateStarted.setTextColor(Color.RED);
            tvSmokesPerday.setTextColor(Color.WHITE);
            tvPriceForPack.setTextColor(Color.WHITE);
            tvCigsPerPack.setTextColor(Color.WHITE);
            tvErrorF2.setTextColor(Color.RED);
            tvErrorF2.setText("Bo?? b??rak??lamaz.");

        }else if(!isDateValid(etDateStarted.getText().toString())){

                tvDateStarted.setTextColor(Color.RED);
                tvSmokesPerday.setTextColor(Color.WHITE);
                tvPriceForPack.setTextColor(Color.WHITE);
                tvCigsPerPack.setTextColor(Color.WHITE);
                tvErrorF2.setTextColor(Color.RED);
                tvErrorF2.setText("Hatal?? tarih.");

        }else if (!isEmpty(etSmokesPerDay.getText().toString())){


            tvDateStarted.setTextColor(Color.WHITE);
            tvSmokesPerday.setTextColor(Color.RED);
            tvPriceForPack.setTextColor(Color.WHITE);
            tvCigsPerPack.setTextColor(Color.WHITE);
            tvErrorF2.setTextColor(Color.RED);
            tvErrorF2.setText("Bo?? b??rak??lamaz..");


        }else if(!isInteger(etSmokesPerDay.getText().toString())){

            tvDateStarted.setTextColor(Color.WHITE);
            tvSmokesPerday.setTextColor(Color.RED);
            tvPriceForPack.setTextColor(Color.WHITE);
            tvCigsPerPack.setTextColor(Color.WHITE);
            tvErrorF2.setTextColor(Color.RED);
            tvErrorF2.setText("Tamsay?? giriniz.");
        }else if(!isEmpty(etPriceForPack.getText().toString())){

            tvDateStarted.setTextColor(Color.WHITE);
            tvSmokesPerday.setTextColor(Color.WHITE);
            tvPriceForPack.setTextColor(Color.RED);
            tvCigsPerPack.setTextColor(Color.WHITE);
            tvErrorF2.setTextColor(Color.RED);
            tvErrorF2.setText("Bo?? b??rak??lamaz.");

        }else if(!isEmpty(etCigsPerPack.getText().toString())){


            tvDateStarted.setTextColor(Color.WHITE);
            tvSmokesPerday.setTextColor(Color.WHITE);
            tvPriceForPack.setTextColor(Color.WHITE);
            tvCigsPerPack.setTextColor(Color.RED);
            tvErrorF2.setTextColor(Color.RED);
            tvErrorF2.setText("Bo?? b??rak??lamaz.");

        }else if(!isInteger(etCigsPerPack.getText().toString())){

            tvDateStarted.setTextColor(Color.WHITE);
            tvSmokesPerday.setTextColor(Color.WHITE);
            tvPriceForPack.setTextColor(Color.WHITE);
            tvCigsPerPack.setTextColor(Color.RED);

            tvErrorF2.setTextColor(Color.RED);
            tvErrorF2.setText("Tamsay?? giriniz.");
        }else{

            User.getInstance().setDateStarted(etDateStarted.getText().toString());
            User.getInstance().setSmokedPerday(etSmokesPerDay.getText().toString());
            User.getInstance().setPricePerPack(etPriceForPack.getText().toString());
            User.getInstance().setCigsPerPack(etCigsPerPack.getText().toString());
            tvDateStarted.setTextColor(Color.WHITE);
            tvSmokesPerday.setTextColor(Color.WHITE);
            tvPriceForPack.setTextColor(Color.WHITE);
            tvCigsPerPack.setTextColor(Color.WHITE);



            com.example.quitquick.Entities.User usr = new com.example.quitquick.Entities.User(
                    User.getInstance().getName(),
                    User.getInstance().getSurname(),
                    User.getInstance().getEmail(),
                    User.getInstance().getPassword(),
                    User.getInstance().getDateStarted(),
                    Integer.parseInt(User.getInstance().getSmokedPerday()),
                    Integer.parseInt(User.getInstance().getPricePerPack()),
                    Integer.parseInt(User.getInstance().getCigsPerPack()));

            UserVM.insertUser(usr);
            tvErrorF2.setTextColor(Color.GREEN);

            tvErrorF2.setText("Kay??t Ba??ar??l??!");


        }


        });



        return root;
    }

    boolean isDateValid(String date){

        if (date.length()<10)return false;
        try {
            int day,month,year;
            day = Integer.parseInt(date.substring(0,2));
            month = Integer.parseInt(date.substring(3,5));
            year = Integer.parseInt(date.substring(6));
            if (year<1970 || year >2021)return false;
            if(month<1 || month >12 )return false;
            if(day<1 || day>31) return false;
        }catch (Exception e){
            return false;
        }

        return true;

    }
    boolean isInteger(String number){

        try{
            Integer.parseInt(number);
        }catch(NumberFormatException e){
            return false;
        }

        return true;
    }
    boolean isEmptyDate(String input){

        int counter;
        for (counter=0;counter<input.length();counter++){
            if (input.charAt(counter)!='/' && !isInteger(String.valueOf(input.charAt(counter))) ){return false;}
        }
        if (input.equals(null)||input=="GG/AA/YYYY"){return false;}     //date i??in ??zel kontroller

        return true;
    }
    boolean isEmpty(String input){

        if(input.equals(null) || input =="" || input.length()<1)return false;
        return true;
    }
}
