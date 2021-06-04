package com.example.quitquick;

import android.content.Context;
import android.os.Build;

import androidx.annotation.RequiresApi;
import androidx.lifecycle.ViewModelProvider;

import com.example.quitquick.Entities.User;
import com.example.quitquick.ViewModels.UserVM;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public  class Calculations {



    @RequiresApi(api = Build.VERSION_CODES.O)
    public static String EarnedMoney(int howManyCigInPack, double pricePerPack, int cigPerDay, String startDatee) throws ParseException {



        int pakettekiSigara =howManyCigInPack;
        double paketFiyati = pricePerPack;
        int gunlukIcilenSigara = cigPerDay;
        double taneFiyati = paketFiyati / pakettekiSigara;
        double kazanilanPara;

        String DateStart = startDatee;
        SimpleDateFormat formatter1=new SimpleDateFormat("dd/MM/yyyy");
        Date startDate = formatter1.parse(DateStart);

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate localDate = LocalDate.now();
        String nowDate = dtf.format(localDate);
        Date nowwDate = formatter1.parse(nowDate);

        long differenceInTime = nowwDate.getTime() - startDate.getTime();
        long differenceInDays = (differenceInTime / (1000 * 60 * 60 * 24)) % 365;

        kazanilanPara = taneFiyati *differenceInDays* gunlukIcilenSigara;
        String Para = String.valueOf(kazanilanPara);

        return Para;
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public static String cigsNotSmoked(int cigPerDay,String startDatee) throws ParseException {


        int gunlukIcilenSigara = cigPerDay;
        long sigaraAdet;

        String DateStart = startDatee;
        SimpleDateFormat formatter1=new SimpleDateFormat("dd/MM/yyyy");
        Date startDate = formatter1.parse(DateStart);

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate localDate = LocalDate.now();
        String nowDate = dtf.format(localDate);
        Date nowwDate = formatter1.parse(nowDate);

        long differenceInTime = nowwDate.getTime() - startDate.getTime();
        long differenceInDays = (differenceInTime / (1000 * 60 * 60 * 24)) % 365;

        sigaraAdet = differenceInDays * gunlukIcilenSigara;
        String adet = String.valueOf(sigaraAdet);

        return adet;
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public static long daysNotSmoked(String startDatee) throws ParseException{

        String DateStart = startDatee;
        SimpleDateFormat formatter1=new SimpleDateFormat("dd/MM/yyyy");
        Date startDate = formatter1.parse(DateStart);

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate localDate = LocalDate.now();
        String nowDate = dtf.format(localDate);
        Date nowwDate = formatter1.parse(nowDate);

        long differenceInTime = nowwDate.getTime() - startDate.getTime();
        long differenceInDays = (differenceInTime / (1000 * 60 * 60 * 24)) % 365;

        return differenceInDays;

    }





}
