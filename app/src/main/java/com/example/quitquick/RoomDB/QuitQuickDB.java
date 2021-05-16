package com.example.quitquick.RoomDB;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.quitquick.DAO.qqDAO;
import com.example.quitquick.Entities.Achievement;
import com.example.quitquick.Entities.Health;
import com.example.quitquick.Entities.Message;
import com.example.quitquick.Entities.Unvan;
import com.example.quitquick.Entities.User;
import com.example.quitquick.Entities.UserAch;
import com.example.quitquick.Entities.UserUnvan;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {Achievement.class, Health.class, Message.class,
        Unvan.class, User.class, UserAch.class, UserUnvan.class},version = 1,exportSchema = false)
public abstract class QuitQuickDB  extends RoomDatabase {

    public abstract qqDAO getDao();

    private static QuitQuickDB instance;
    public static final ExecutorService dbWriteExecutor = Executors.newFixedThreadPool(5);

    public static QuitQuickDB getDB(final Context context){
        if (instance==null){
            synchronized (QuitQuickDB.class) {
                instance = Room.databaseBuilder(context.getApplicationContext(),
                        QuitQuickDB.class, "quit_quick_database").build();
            }

        }
        return instance;

    }

}
