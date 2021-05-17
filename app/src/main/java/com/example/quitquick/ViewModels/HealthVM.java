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
    private LiveData<List<Health>> liveDataHealth;


    public HealthVM(@NonNull @NotNull Application application) {
        super(application);
        healthRep = new HealthREP(application);
        liveDataHealth = healthRep.getAllHealth();


    }
    @Query("Select * from HEALTH")
    public LiveData<List<Health>>getAllHealth(){return liveDataHealth;}
}
