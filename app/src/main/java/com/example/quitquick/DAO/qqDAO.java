package com.example.quitquick.DAO;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Entity;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Transaction;
import androidx.room.Update;

import com.example.quitquick.Entities.Achievement;
import com.example.quitquick.Entities.Health;
import com.example.quitquick.Entities.Message;
import com.example.quitquick.Entities.Relationships.UserWithAchivements;
import com.example.quitquick.Entities.Relationships.UserWithUnvans;
import com.example.quitquick.Entities.Unvan;
import com.example.quitquick.Entities.User;
import com.example.quitquick.Entities.UserAch;
import com.example.quitquick.Entities.UserUnvan;

import java.util.List;


@Dao
public interface qqDAO {
    //Message Queries
    @Insert
    void insertMessage(Message msg);
    @Delete
    void deleteMessage(Message msg);
    @Query("Select * from COMMUNITY")
    LiveData<List<Message>> getAllMessages();

    //UserWithMessages Queries
    @Query("SELECT * FROM USER WHERE UserID = :id")
    LiveData<User> getMessageSender(int id);

    //Health Queries
    @Query("SELECT * FROM HEALTH")
    LiveData<List<Health>> getAllHealth();

    //Unvan Queries
    @Query("SELECT * FROM UNVAN")
    LiveData<List<Unvan>> getAllUnvan();

    //User Que ries
    @Query("Select * from USER")
    LiveData<List<User>>getAllUsers();
    @Insert
    void insertUser(User user);
    @Delete
    void deleteUser(User user);
    @Update
    void updateUser(User user);
    @Query("SELECT * FROM USER WHERE UserID = :ID")
    LiveData<User> findUserById(int ID);
    @Query("SELECT * FROM USER WHERE First_Name = :name")
    LiveData<List<User>> findUserByName(String name);

    //UserWithAchievemnt Queries
    @Transaction
    @Query("Select * FROM USER WHERE UserID=:uid")
    LiveData<List<UserWithAchivements>> getUserAchievements(int uid);


    //UserWithUnvan Queries
    @Transaction
    @Query("Select * from  USER where UserID=:UserID")
    List<UserWithUnvans>getUsersUnvans(int UserID);

    @Transaction
    @Query("Select * from USER WHERE USERID = :ID")
    List<UserWithUnvans> getUserWithUnvans(int ID);
    @Transaction
    @Insert
    void insertUserAnotherUnvan(Unvan unvan);

}
