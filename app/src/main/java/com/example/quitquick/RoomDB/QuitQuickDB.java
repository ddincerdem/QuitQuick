package com.example.quitquick.RoomDB;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.example.quitquick.DAO.qqDAO;
import com.example.quitquick.Entities.Achievement;
import com.example.quitquick.Entities.Health;
import com.example.quitquick.Entities.Message;
import com.example.quitquick.Entities.Unvan;
import com.example.quitquick.Entities.User;
import com.example.quitquick.Entities.Relationships.UserAch;
import com.example.quitquick.Entities.Relationships.UserUnvan;

import org.jetbrains.annotations.NotNull;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {Achievement.class, Health.class, Message.class,
        Unvan.class, User.class, UserAch.class, UserUnvan.class},version = 4,exportSchema = false)
public abstract class QuitQuickDB  extends RoomDatabase {

    public abstract qqDAO getDao();

    private static QuitQuickDB instance;
    public static final ExecutorService dbWriteExecutor = Executors.newFixedThreadPool(5);

    static final Migration MIGRATION = new Migration(1, 4) {
        @Override
        public void migrate(@NonNull @NotNull SupportSQLiteDatabase database) {

        }
    };
    public static QuitQuickDB getDB(final Context context){
        if (instance==null){
            synchronized (QuitQuickDB.class) {
                instance = Room.databaseBuilder(context.getApplicationContext(),
                        QuitQuickDB.class, "quit_quick_database").addMigrations(MIGRATION).allowMainThreadQueries().build();
            }

        }
        return instance;

    }

}
