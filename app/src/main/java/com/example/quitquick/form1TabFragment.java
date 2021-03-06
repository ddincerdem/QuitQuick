package com.example.quitquick;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.example.quitquick.Models.User;

public class form1TabFragment extends Fragment {


    EditText etName,etSoyad,etEmail,etPassword,etPasswordConf;
    Button btnNext,btnReturntoLogin;
    ViewPager viewPager;
    TextView tvErrorF1,tvname,tvSurname,tvEmail,tvPassword,tvPasswordC;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        ViewGroup root = (ViewGroup) inflater.inflate(R.layout.form1_fragment,container,false);

        etName = root.findViewById(R.id.etName);
        etEmail = root.findViewById(R.id.etEmail);
        etPassword = root.findViewById(R.id.etPassword);
        etPasswordConf = root.findViewById(R.id.etPasswordConf);
        btnNext= root.findViewById(R.id.btnNext);
        tvErrorF1 = root.findViewById(R.id.tvErrorF1);
        etSoyad = root.findViewById(R.id.etSurname);
        tvEmail = root.findViewById(R.id.tvEmail);
        tvname = root.findViewById(R.id.tvName);
        tvSurname = root.findViewById(R.id.tvSurname);
        tvPassword = root.findViewById(R.id.tvPassword);
        tvPasswordC = root.findViewById(R.id.tvPasswordConf);
        btnReturntoLogin = root.findViewById(R.id.btnReturnLogin);

        btnReturntoLogin.setOnClickListener(v->{
            this.getActivity().finish();

        });
        btnNext.setOnClickListener(v -> {
            if (!isEmpty(etName.getText().toString().trim())){

                tvname.setTextColor(Color.RED);
                tvSurname.setTextColor(Color.WHITE);
                tvEmail.setTextColor(Color.WHITE);
                tvPassword.setTextColor(Color.WHITE);
                tvPasswordC.setTextColor(Color.WHITE);

                tvErrorF1.setText("??sim bo?? olamaz.");
            }else if(!isEmpty(etSoyad.getText().toString().trim())){


                tvname.setTextColor(Color.WHITE);
                tvSurname.setTextColor(Color.RED);
                tvEmail.setTextColor(Color.WHITE);
                tvPassword.setTextColor(Color.WHITE);
                tvPasswordC.setTextColor(Color.WHITE);

                tvErrorF1.setText("Soyisim bo?? olamaz.");
            }else if (!isAlphabetical(etName.getText().toString().trim())){


                tvname.setTextColor(Color.RED);
                tvSurname.setTextColor(Color.WHITE);
                tvEmail.setTextColor(Color.WHITE);
                tvPassword.setTextColor(Color.WHITE);
                tvPasswordC.setTextColor(Color.WHITE);

                tvErrorF1.setText("??sminizi kontrol ediniz.");
            }else if (!isAlphabetical(etSoyad.getText().toString().trim())){


                tvname.setTextColor(Color.WHITE);
                tvSurname.setTextColor(Color.RED);
                tvEmail.setTextColor(Color.WHITE);
                tvPassword.setTextColor(Color.WHITE);
                tvPasswordC.setTextColor(Color.WHITE);

                tvErrorF1.setText("Soyisminizi kontrol ediniz");
            }else if(!isEmail(etEmail.getText().toString().trim())){


                tvname.setTextColor(Color.WHITE);
                tvSurname.setTextColor(Color.WHITE);
                tvEmail.setTextColor(Color.RED);
                tvPassword.setTextColor(Color.WHITE);
                tvPasswordC.setTextColor(Color.WHITE);

                tvErrorF1.setText("E-Mailinizi kontrol ediniz.");
            }else if(!matchPW(etPassword.getText().toString().trim(),etPasswordConf.getText().toString().trim())){


                tvname.setTextColor(Color.WHITE);
                tvSurname.setTextColor(Color.WHITE);
                tvEmail.setTextColor(Color.WHITE);
                tvPassword.setTextColor(Color.RED);
                tvPasswordC.setTextColor(Color.RED);

                tvErrorF1.setText("??ifreler uyu??muyor.");
            }else if(!isPassword(etPassword.getText().toString().trim())){


                tvname.setTextColor(Color.WHITE);
                tvSurname.setTextColor(Color.WHITE);
                tvEmail.setTextColor(Color.WHITE);
                tvPassword.setTextColor(Color.RED);
                tvPasswordC.setTextColor(Color.RED);

                tvErrorF1.setTextSize(18);
                tvErrorF1.setText("??ifreniz 7-14 karakter olmal??.");
            }
            else{
                tvname.setTextColor(Color.WHITE);
                tvSurname.setTextColor(Color.WHITE);
                tvEmail.setTextColor(Color.WHITE);
                tvPassword.setTextColor(Color.WHITE);
                tvPasswordC.setTextColor(Color.WHITE);

                User.getInstance().setName(etName.getText().toString());
                User.getInstance().setSurname(etSoyad.getText().toString());
                User.getInstance().setEmail(etEmail.getText().toString());
                User.getInstance().setPassword(etPassword.getText().toString());

                tvErrorF1.setText("");
                viewPager=getActivity().findViewById(R.id.view_pager);
                viewPager.setCurrentItem(1); }

            });


        return root;
    }
    boolean isEmpty(String input){
        if (input.length()<1 || input.equals(null))return false;
        return true;
    }
    boolean isAlphabetical(String name){

        for (int i = 0; i != name.length(); ++i) {
            if (!Character.isLetter(name.charAt(i))) {

                return false;
            }
        }

        return true;
    }
    boolean isEmail(String email){
            if (email.endsWith(".com") && email.contains("@"))return true;

    return false;
    }
    boolean isPassword(String pw){
        if (pw.length()<7 || pw.length()>16)return false;
        return true;
    }
    boolean matchPW(String pw, String pwc){
        if (!pw.equals(pwc))return false;
        return true;
    }
}
