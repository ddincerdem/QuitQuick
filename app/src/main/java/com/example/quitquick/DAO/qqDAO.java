package com.example.quitquick.DAO;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.RewriteQueriesToDropUnusedColumns;
import androidx.room.Transaction;
import androidx.room.Update;

import com.example.quitquick.Entities.Achievement;
import com.example.quitquick.Entities.Health;
import com.example.quitquick.Entities.Message;

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
    List<Message> getAllMessages();



    @Query("Select * From COMMUNITY where SenderID = :id")
    public List<Message> getUsersMessagesById(int id);

    //Health Queries
    @Insert
    void insertHealth(Health health);

    @Query("SELECT * FROM HEALTH")
    List<Health> getAllHealth();

    //Unvan Queries
    @Query("SELECT * FROM UNVAN")
    List<Unvan> getAllUnvan();
    @Insert
    void insertUnvan(Unvan unvan);

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




    @Query("SELECT * FROM ACHIEVEMENT")
    List<Achievement> getAllAchievements();

    @Insert
    void insertAchievement(Achievement achievement);

    @Query("Select AchievementObjective from ACHIEVEMENT where AchId = :achId")
    int getAchievementById(int achId);


    //UserWithUnvan Queries






    @Transaction
    @Insert
    void insertUserAnotherUnvan(Unvan unvan);





}
