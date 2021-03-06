package com.example.quitquick.ViewModels;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.room.Query;

import com.example.quitquick.Entities.Unvan;
import com.example.quitquick.Repository.UnvanREP;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class UnvanVM extends AndroidViewModel {
    private UnvanREP unvanRep;
    private List<Unvan> liveDataUnvan;

    public UnvanVM(@NonNull @NotNull Application application) {
        super(application);
        unvanRep= new UnvanREP(application);
        liveDataUnvan = unvanRep.getAllUnvan();

    }
    @Query("Select * from UNVAN")
    public List<Unvan> getAllUnvan(){return liveDataUnvan;}
    void insertUnvan(Unvan unvan){unvanRep.insertUnvan(unvan);}
    public  Unvan getUnvanById(int id){
        return unvanRep.getUnvanById(id);
    }
}
