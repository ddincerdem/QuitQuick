package com.example.quitquick.DAO;

import androidx.lifecycle.LiveData;
import androidx.room.Query;

import com.example.quitquick.Entities.Health;

import java.util.List;

public interface HealthDao {

    @Query("SELECT * FROM HEALTH")
    LiveData<List<Health>> getAllHealth();

}
