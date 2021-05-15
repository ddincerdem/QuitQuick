package com.example.quitquick.DAO;

import androidx.lifecycle.LiveData;
import androidx.room.Query;

import com.example.quitquick.Entities.Unvan;

import java.util.List;

public interface UnvanDao {

    @Query("SELECT * FROM UNVAN")
    LiveData<List<Unvan>> getAllUnvan();


}
