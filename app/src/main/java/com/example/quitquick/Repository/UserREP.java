package com.example.quitquick.Repository;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.example.quitquick.DAO.qqDAO;
import com.example.quitquick.Entities.User;
import com.example.quitquick.RoomDB.QuitQuickDB;

import java.util.List;

public class UserREP {

    private qqDAO dao;
    private LiveData<List<User>> liveDataUsers;
    //private LiveData<User> user;
    public UserREP(Application application){
        QuitQuickDB db = QuitQuickDB.getDB(application.getApplicationContext());
        dao = db.getDao();
        liveDataUsers =dao.getAllUsers();
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
    public LiveData<List<User>> findUserById(int id){return dao.findUserById(id);}
    public LiveData<List<User>> getAllUsers(){return dao.getAllUsers();}
}
