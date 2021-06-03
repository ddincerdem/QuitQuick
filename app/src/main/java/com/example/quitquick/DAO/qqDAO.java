package com.example.quitquick.DAO;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Transaction;
import androidx.room.Update;

import com.example.quitquick.Entities.Achievement;
import com.example.quitquick.Entities.Health;
import com.example.quitquick.Entities.Message;
import com.example.quitquick.Entities.Relationships.UserWithAchivements;
import com.example.quitquick.Entities.Relationships.UserWithMessages;
import com.example.quitquick.Entities.Relationships.UserWithUnvans;
import com.example.quitquick.Entities.Unvan;
import com.example.quitquick.Entities.User;

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
    @Transaction
    @Query("SELECT * FROM USER WHERE UserID = :id")
    LiveData<UserWithMessages> getMessageWithSender(int id);

    //Health Queries
    @Insert
    void insertHealth(Health health);

    @Query("SELECT * FROM HEALTH")
    List<Health> getAllHealth();

    //Unvan Queries
    @Query("SELECT * FROM UNVAN")
    LiveData<List<Unvan>> getAllUnvan();

    //User Queries
    @Insert
    void insertUser(User user);
    @Delete
    void deleteUser(User user);
    @Update
    void updateUser(User user);
    @Query("SELECT * FROM USER WHERE UserID = :ID")
    User findUserById(int ID);
    @Query("SELECT * FROM USER WHERE First_Name = :name")
    LiveData<List<User>> findUserByName(String name);
    @Query("Select * from USER where EMail = :Email AND Password = :Pass")
    User findUserByEmailAndPassword(String Email,String Pass);

    //UserWithAchievemnt Queries
    @Transaction
    @Query("Select * FROM USER WHERE UserID=:uid")
    LiveData<List<UserWithAchivements>> getUserAchievements(int uid);


    @Query("SELECT * FROM USER WHERE UserID = :uid")
    LiveData<List<UserWithAchivements>> getUserWithAchievements(int uid);

    @Transaction
    @Query("SELECT * FROM ACHIEVEMENT")
     List<Achievement> getAllAchievements();


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
