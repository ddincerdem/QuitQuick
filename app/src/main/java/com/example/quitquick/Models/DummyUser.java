package com.example.quitquick.Models;

public class DummyUser {
    private static DummyUser Instance = null;
    private static String name,surname,email,password,dateStarted,smokedPerday,pricePerPack,cigsPerPack;


    private DummyUser(){
        name="";
        surname="";
        email="";
        password="";
        dateStarted="";
        smokedPerday="";
        pricePerPack="";
        pricePerPack="";
        cigsPerPack="";

    }

    public static DummyUser getInstance(){
        if (Instance==null){
            Instance=new DummyUser();
        }
        return Instance;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getDateStarted() {
        return dateStarted;
    }

    public String getSmokedPerday() {
        return smokedPerday;
    }

    public String getPricePerPack() {
        return pricePerPack;
    }

    public String getCigsPerPack() {
        return cigsPerPack;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setDateStarted(String dateStarted) {
        this.dateStarted = dateStarted;
    }

    public void setSmokedPerday(String smokedPerday) {
        this.smokedPerday = smokedPerday;
    }

    public void setPricePerPack(String pricePerPack) {
        this.pricePerPack = pricePerPack;
    }

    public void setCigsPerPack(String cigsPerPack) {
        this.cigsPerPack = cigsPerPack;
    }
}
