package com.example.quitquick.Entities;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "HEALTH" )
public class Health {

    @PrimaryKey(autoGenerate = true)
    @NonNull
    int HealthDataID;

    @NonNull
    @ColumnInfo(name = "DayWithoutCig")
    int DayWithoutCig;

    @ColumnInfo(name = "MoneySaved")
    double MoneySaved;

    @NonNull
    @ColumnInfo(name = "LifeSaved")
    double LifeSaved;

    public Health(int dayWithoutCig, double moneySaved, double lifeSaved) {
        DayWithoutCig = dayWithoutCig;
        MoneySaved = moneySaved;
        LifeSaved = lifeSaved;
    }

    public int getHealthDataID() {
        return HealthDataID;
    }

    public void setHealthDataID(int healthDataID) {
        HealthDataID = healthDataID;
    }

    public int getDayWithoutCig() {
        return DayWithoutCig;
    }

    public void setDayWithoutCig(int dayWithoutCig) {
        DayWithoutCig = dayWithoutCig;
    }

    public double getMoneySaved() {
        return MoneySaved;
    }

    public void setMoneySaved(double moneySaved) {
        MoneySaved = moneySaved;
    }

    public double getLifeSaved() {
        return LifeSaved;
    }

    public void setLifeSaved(double lifeSaved) {
        LifeSaved = lifeSaved;
    }
}
