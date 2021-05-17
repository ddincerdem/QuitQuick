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

import java.util.List;


@Dao
public interface qqDAO {
    @Query("SELECT * FROM HEALTH")
    LiveData<List<Health>> getAllHealth();

    @Insert
    void insertMessage(Message msg);
    @Delete
    void deleteMessage(Message msg);

    @Query("Select * from COMMUNITY")
    LiveData<List<Message>> getAllMessages();

    @Query("SELECT * FROM UNVAN")
    LiveData<List<Unvan>> getAllUnvan();

    @Query("Select * from USER")
    LiveData<List<User>>getAllUsers();

    @Insert
    void insertUser(User user);

    @Delete
    void deleteUser(User user);

    @Update
    void updateUser(User user);

    @Query("SELECT * FROM USER WHERE UserID = :ID")
    LiveData<List<User>> findUserById(int ID);

    @Query("SELECT * FROM USER WHERE First_Name = :name")
    LiveData<List<User>> findUserByName(String name);

    //Ara tablo

    @Transaction
    @Query("Select AchId,AchDesc,AchName,AchUnvanId from ACHIEVEMENT where AchId=(Select AchId from UserAch where UserID=:uid)")
    LiveData<List<Achievement>> getUserAchievements(int uid);

   // @Query("Select AchId from UserAch where UserID = :UserID")
   // List<Integer> getUsersAchievementIds(int UserID);  Bunlara gerek yok galiba

    @Insert
    void insertUserUnvan(User user,Unvan unvan);

    @Query("Select UnvanID from  UserUnvan where UserID=:UserID")
    List<Integer> getUsersUnvans(int UserID);

    @Transaction
    @Query("SELECT * FROM USER WHERE UserID = :ID")
    List<UserWithAchivements> getUserWithAchievements(int ID);

    @Transaction
    @Query("Select * from USER WHERE USERID = :ID")
    List<UserWithUnvans> getUserWithUnvans(int ID);
}
