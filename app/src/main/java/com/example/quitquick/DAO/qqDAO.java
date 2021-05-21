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
    @Query("SELECT * FROM HEALTH")
    LiveData<List<Health>> getAllHealth();

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
    LiveData<User> findUserById(int ID);
    @Query("SELECT * FROM USER WHERE First_Name = :name")
    LiveData<List<User>> findUserByName(String name);
    @Query("Select * from USER where EMail = :Email")
    User findUserByEmail(String Email);

    //UserWithAchievemnt Queries
    @Transaction
<<<<<<< HEAD
    @Query("Select * FROM USER WHERE UserID=:uid")
    LiveData<List<UserWithAchivements>> getUserAchievements(int uid);

=======
    @Query("SELECT * FROM USER WHERE UserID = :uid")
    LiveData<List<UserWithAchivements>> getUserWithAchievements(int uid);

    @Transaction
    @Query("SELECT * FROM ACHIEVEMENT")
     List<UserWithAchivements> getAllAchievements();
>>>>>>> 76a9823e51f50c7cb973599c55b30a58f3ff3394

    //UserWithUnvan Queries

    @Transaction
<<<<<<< HEAD
    @Query("Select * from  USER where UserID=:UserID")
    List<UserWithUnvans>getUsersUnvans(int UserID);

    @Transaction
    @Query("Select * from USER WHERE USERID = :ID")
    List<UserWithUnvans> getUserWithUnvans(int ID);
=======
    @Query("SELECT * FROM  USER WHERE UserID= :UserID")
    List<UserWithUnvans> getUsersUnvans(int UserID);
>>>>>>> 76a9823e51f50c7cb973599c55b30a58f3ff3394

    @Transaction
    @Insert
    void insertUserAnotherUnvan(Unvan unvan);





}
