package com.example.quitquick.DAO;

import androidx.lifecycle.LiveData;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.quitquick.Entities.User;

import java.util.List;

public interface UserDao {
    @Insert
    void InsertUser(User user);

    @Delete
    void DeleteUser(User user);

    @Update
    void UpdateUser(User user);

    @Query("SELECT * FROM USER WHERE UserID = :ID")
    LiveData<List<User>> findUserById(int ID);

    @Query("SELECT * FROM USER WHERE First_Name = :name")
    LiveData<List<User>> findUserByName(String name);

}
