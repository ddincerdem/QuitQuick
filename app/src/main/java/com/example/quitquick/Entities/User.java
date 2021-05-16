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
    public String FirstName;

    @NonNull
    @ColumnInfo(name = "Last_Name")
    public String LastName;

    @NonNull
    @ColumnInfo(name = "EMail")
    public String Email;

    @NonNull
    @ColumnInfo(name = "Password")
    public String Password;

    @NonNull
    @ColumnInfo(name = "StartDate")
    public String StartDate;

    @NonNull
    @ColumnInfo(name = "CigPerDay")
    public int CigPerDay;

    @NonNull
    @ColumnInfo(name = "PricePerPack")
    public double PricePerPack;

    @NonNull
    @ColumnInfo(name = "HowManyCigInPack")
    public int HowManyCigInPack;
    public int getUserID() {
        return UserID;
    }

    public User(int UserID, @NonNull String FirstName, @NonNull String LastName, @NonNull String Email,
                @NonNull String Password, @NonNull String StartDate, int CigPerDay, double PricePerPack, int HowManyCigInPack) {
        this.UserID = UserID;
        this.FirstName = FirstName;
        this.LastName = LastName;
        this.Email = Email;
        this.Password = Password;
        this.StartDate = StartDate;
        this.CigPerDay = CigPerDay;
        this.PricePerPack = PricePerPack;
        this.HowManyCigInPack = HowManyCigInPack;
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
