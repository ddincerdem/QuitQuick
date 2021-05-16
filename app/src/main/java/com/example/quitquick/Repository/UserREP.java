package com.example.quitquick.Repository;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.example.quitquick.DAO.qqDAO;
import com.example.quitquick.Entities.User;
import com.example.quitquick.RoomDB.QuitQuickDB;

import java.util.List;

public class UserREP {

    private qqDAO dao;
    private LiveData<List<User>> liveDataUser;
    //private LiveData<User> user;
    public UserREP(Application application,int userId){
        QuitQuickDB db = QuitQuickDB.getDB(application.getApplicationContext());
        dao = db.getDao();
        liveDataUser =dao.findUserById(userId);
    }

    public void insertUser(User usr){
        dao.insertUser(usr);
    }
    public void deleteUser(User User){
        dao.deleteUser(User);
    }
    public void updateUser(User usr){
        dao.updateUser(usr);
    }
    public LiveData<List<User>> findUserByName(String name){
        return dao.findUserByName(name);
    }
}
