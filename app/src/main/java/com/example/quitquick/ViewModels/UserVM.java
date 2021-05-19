package com.example.quitquick.ViewModels;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.quitquick.Entities.User;
import com.example.quitquick.Repository.UserREP;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class UserVM extends AndroidViewModel {
    private UserREP userRep;
    private LiveData<List<User>> liveDataUsers;
    public UserVM(@NonNull @NotNull Application application) {
        super(application);
        userRep = new UserREP(application);
        liveDataUsers = userRep.getAllUsers();
    }

    public void insertUser(User usr){
        userRep.insertUser(usr);
    }
    public void deleteUser(User User){
        userRep.deleteUser(User);
    }
    public void updateUser(User usr){
        userRep.updateUser(usr);
    }
    public LiveData<List<User>> findUserByName(String name){
        return userRep.findUserByName(name);
    }
    public LiveData<User> findUserById(int id){return userRep.findUserById(id);}
    public LiveData<List<User>> getAllUsers(){return userRep.getAllUsers();}
}
