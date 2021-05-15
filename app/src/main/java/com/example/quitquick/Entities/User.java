package com.example.quitquick.Entities;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "USER")
public class User {
    @PrimaryKey(autoGenerate = true)
    @NonNull
    public int UserID;

    @NonNull
    @ColumnInfo(name = "First_Name")
    String FirstName;

    @NonNull
    @ColumnInfo(name = "Last_Name")
    String LastName;

    @NonNull
    @ColumnInfo(name = "EMail")
    String Email;

    @NonNull
    @ColumnInfo(name = "Password")
    String Password;

    @NonNull
    @ColumnInfo(name = "StartDate")
    String StartDate;

    @NonNull
    @ColumnInfo(name = "CigPerDay")
    int CigPerDay;

    @NonNull
    @ColumnInfo(name = "PricePerPack")
    double PricePerPack;

    @NonNull
    @ColumnInfo(name = "HowManyCigInPack")
    int HowManyCigInPack;
    public int getUserID() {
        return UserID;
    }

    public User(int userID, @NonNull String firstName, @NonNull String lastName, @NonNull String email, @NonNull String password, @NonNull String startDate, int cigPerDay, double pricePerPack, int howManyCigInPack) {
        UserID = userID;
        FirstName = firstName;
        LastName = lastName;
        Email = email;
        Password = password;
        StartDate = startDate;
        CigPerDay = cigPerDay;
        PricePerPack = pricePerPack;
        HowManyCigInPack = howManyCigInPack;
    }
    public User( @NonNull String firstName, @NonNull String lastName, @NonNull String email, @NonNull String password, @NonNull String startDate, int cigPerDay, double pricePerPack, int howManyCigInPack) {
        FirstName = firstName;
        LastName = lastName;
        Email = email;
        Password = password;
        StartDate = startDate;
        CigPerDay = cigPerDay;
        PricePerPack = pricePerPack;
        HowManyCigInPack = howManyCigInPack;
    }

    public void setUserID(int userID) {
        UserID = userID;
    }

    @NonNull
    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(@NonNull String firstName) {
        FirstName = firstName;
    }

    @NonNull
    public String getLastName() {
        return LastName;
    }

    public void setLastName(@NonNull String lastName) {
        LastName = lastName;
    }

    @NonNull
    public String getEmail() {
        return Email;
    }

    public void setEmail(@NonNull String email) {
        Email = email;
    }

    @NonNull
    public String getPassword() {
        return Password;
    }

    public void setPassword(@NonNull String password) {
        Password = password;
    }

    @NonNull
    public String getStartDate() {
        return StartDate;
    }

    public void setStartDate(@NonNull String startDate) {
        StartDate = startDate;
    }


    public int getCigPerDay() {
        return CigPerDay;
    }

    public void setCigPerDay(int cigPerDay) {
        CigPerDay = cigPerDay;
    }


    public double getPricePerPack() {
        return PricePerPack;
    }

    public void setPricePerPack(double pricePerPack) {
        PricePerPack = pricePerPack;
    }


    public int getHowManyCigInPack() {
        return HowManyCigInPack;
    }

    public void setHowManyCigInPack(int howManyCigInPack) {
        HowManyCigInPack = howManyCigInPack;
    }
}
