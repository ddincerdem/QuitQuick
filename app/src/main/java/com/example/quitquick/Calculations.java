package com.example.quitquick;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class Calculations {



    public static long calculateDays(String basla,String birak){



    try {
        SimpleDateFormat dates = new SimpleDateFormat("dd-MM-yyyy");
        Date dateBaslama,dateBirakma;
        //Setting dates
        dateBaslama = dates.parse(basla);
        dateBirakma = dates.parse(birak);

        //Comparing dates
        long difference = Math.abs(dateBaslama.getTime() - dateBirakma.getTime());
        long differenceDates = difference / (24 * 60 * 60 * 1000);

        return differenceDates;

    }catch(ParseException p){ System.out.println(p.getMessage()); return 0;}


    }

    public static long cigsNotSmoked(long days,long dailyAverage){return days*dailyAverage;}

    public static long moneySaved(long days,long dailyAverage,long priceOfPack,long cigsInPack){
        long cigsNotSmoked=cigsNotSmoked(days,dailyAverage);
        long packsDidntBought = cigsNotSmoked/cigsInPack;
        return packsDidntBought * priceOfPack;
    }

    





}
