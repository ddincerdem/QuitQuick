package com.example.quitquick.ViewModels;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.room.Query;

import com.example.quitquick.Entities.Health;
import com.example.quitquick.Repository.HealthREP;

import org.jetbrains.annotations.NotNull;

import java.util.List;


public class HealthVM extends AndroidViewModel {

    private HealthREP healthRep;
    private List<Health> liveDataHealth;


    public HealthVM(@NonNull @NotNull Application application) {
        super(application);
        healthRep = new HealthREP(application);
        liveDataHealth = healthRep.getAllHealth();


    }
    public List<Health>getAllHealth(){return liveDataHealth;}
    public void insertHealth(Health health){healthRep.insertHealth(health);}
}
