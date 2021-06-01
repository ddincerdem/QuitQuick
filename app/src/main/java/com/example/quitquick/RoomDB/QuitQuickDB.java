package com.example.quitquick.RoomDB;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModelProvider;
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

               prePopulateDB();

            }

        }
        return instance;

    }
    private static void prePopulateDB(){
        Health health = new Health();
        health.setDuration(1);
        health.setDescription("Kalp krizi riskiniz azalmaya başlar.");
        instance.getDao().insertHealth(health);

        health.setDuration(2);
        health.setDescription("Koku ve tat duyularınız normale döner.");
        instance.getDao().insertHealth(health);

        health.setDuration(3);
        health.setDescription("Kandaki nikotin seviyesi normal seviyeye düşer.");
        instance.getDao().insertHealth(health);

        health.setDuration(7);
        health.setDescription("1 hafta sigerayı bırakabilen insanların sigarayı başarıyla bırakma ihtimalleri 9 kat artar.");
        instance.getDao().insertHealth(health);

        health.setDuration(14);
        health.setDescription("Akciğer fonksiyonları %30 artar.");
        instance.getDao().insertHealth(health);

        health.setDuration(30);
        health.setDescription("Akciğer kapasiteniz artar.");
        instance.getDao().insertHealth(health);

        health.setDuration(60);
        health.setDescription("Kan dolaşımınız normale döner.");
        instance.getDao().insertHealth(health);

        health.setDuration(180);
        health.setDescription("Stresle başetmede sigaraya olan bağımlılığınız ortadan kalkar.");
        instance.getDao().insertHealth(health);

        health.setDuration(270);
        health.setDescription("Akciğerinizdeki siller kendilerini onarır. Enfeksiyonlara karşı direnciniz artar");
        instance.getDao().insertHealth(health);

        health.setDuration(365);
        health.setDescription("Kalp hastalığı riskiniz yarıya düşer.");
        instance.getDao().insertHealth(health);

        health.setDuration(1500);
        health.setDescription("Dolaşım sisteminiz normale döner. Pıhtı ve felç riski azalır.");
        instance.getDao().insertHealth(health);
    }

}
