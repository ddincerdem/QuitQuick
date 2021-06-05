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
import com.example.quitquick.Entities.UserAchievementCR;
import com.example.quitquick.Entities.UserUnvanCR;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {UserAchievementCR.class, UserUnvanCR.class,Achievement.class, Health.class, Message.class,
        Unvan.class, User.class},version = 8,exportSchema = false)
public abstract class QuitQuickDB  extends RoomDatabase {



    public abstract qqDAO getDao();

    private static QuitQuickDB instance;
    public static final ExecutorService dbWriteExecutor = Executors.newFixedThreadPool(5);



    public static QuitQuickDB getDB(final Context context){
        if (instance==null){
            synchronized (QuitQuickDB.class) {
                instance = Room.databaseBuilder(context.getApplicationContext(),
                        QuitQuickDB.class, "quit_quick_database").fallbackToDestructiveMigration().allowMainThreadQueries().build();

               prePopulateDB();

            }

        }
        return instance;

    }
    private static void prePopulateDB(){
        List<Health> healthList;
        healthList= instance.getDao().getAllHealth();
        if (healthList.isEmpty() || healthList.size()<1){
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
        instance.getDao().insertHealth(health);}

        List<Achievement> achievementList;
        achievementList= instance.getDao().getAllAchievements();


        if (achievementList.isEmpty() || achievementList.size()<1){

            Achievement ach = new Achievement();
            ach.setAchDesc("1 sigara içilmedi");
            ach.setAchName("sigara1");
            ach.setAchUnvanId(1);
            ach.setAchId(1);
            ach.setAchievementObjective(1);
            instance.getDao().insertAchievement(ach);

            ach.setAchDesc("100 sigara içilmedi");
            ach.setAchName("sigara2");
            ach.setAchUnvanId(2);
            ach.setAchId(2);
            ach.setAchievementObjective(100);
            instance.getDao().insertAchievement(ach);

            ach.setAchDesc("1000 sigara içilmedi");
            ach.setAchName("sigara3");
            ach.setAchievementObjective(1000);
            ach.setAchUnvanId(3);
            ach.setAchId(3);
            instance.getDao().insertAchievement(ach);

            ach.setAchDesc("10 lira harcanmadı");
            ach.setAchievementObjective(10);
            ach.setAchName("para1");
            ach.setAchUnvanId(4);
            ach.setAchId(4);
            instance.getDao().insertAchievement(ach);

            ach.setAchDesc("100 lira harcanmadı");
            ach.setAchName("para2");
            ach.setAchievementObjective(100);
            ach.setAchUnvanId(5);
            ach.setAchId(5);
            instance.getDao().insertAchievement(ach);

            ach.setAchDesc("1000 lira harcanmadı");
            ach.setAchName("para3");
            ach.setAchievementObjective(100);
            ach.setAchUnvanId(6);
            ach.setAchId(6);
            instance.getDao().insertAchievement(ach);

            ach.setAchDesc("1 gündür sigara içilmedi");
            ach.setAchievementObjective(1);
            ach.setAchName("gun1");
            ach.setAchUnvanId(7);
            ach.setAchId(7);
            instance.getDao().insertAchievement(ach);

            ach.setAchDesc("10 gündür sigara içilmedi");
            ach.setAchievementObjective(10);
            ach.setAchName("gun2");
            ach.setAchUnvanId(8);
            ach.setAchId(8);
            instance.getDao().insertAchievement(ach);

            ach.setAchDesc("100 gündür sigara içilmedi");
            ach.setAchName("gun3");
            ach.setAchId(9);
            ach.setAchievementObjective(100);
            ach.setAchUnvanId(9);
            instance.getDao().insertAchievement(ach);

            ach.setAchDesc("1000 gündür sigara içilmedi");
            ach.setAchName("gun4");
            ach.setAchievementObjective(1000);
            ach.setAchUnvanId(10);
            ach.setAchId(10);
            instance.getDao().insertAchievement(ach);

            ach.setAchDesc("1 mesaj gönderildi");
            ach.setAchName("mesaj1");
            ach.setAchievementObjective(1);
            ach.setAchUnvanId(11);
            ach.setAchId(11);
            instance.getDao().insertAchievement(ach);

            ach.setAchDesc("10 mesaj gönderildi");
            ach.setAchName("mesaj2");
            ach.setAchievementObjective(10);
            ach.setAchUnvanId(12);
            ach.setAchId(12);
            instance.getDao().insertAchievement(ach);

            ach.setAchDesc("100 mesaj gönderildi");
            ach.setAchName("mesaj3");
            ach.setAchievementObjective(100);
            ach.setAchUnvanId(13);ach.setAchId(13);
            instance.getDao().insertAchievement(ach);

        }

        List<Unvan> unvanList;
        unvanList = instance.getDao().getAllUnvan();

        if (unvanList.isEmpty() || unvanList.size()<1){

            Unvan unvan = new Unvan();
            unvan.setUnvanID(1);
            unvan.setUnvanName("Çömez");
            instance.getDao().insertUnvan(unvan);

            unvan.setUnvanID(2);
            unvan.setUnvanName("Kararlı");
            instance.getDao().insertUnvan(unvan);

            unvan.setUnvanID(3);
            unvan.setUnvanName("Tecrübeli");
            instance.getDao().insertUnvan(unvan);

            unvan.setUnvanID(4);
            unvan.setUnvanName("Biriktirici");
            instance.getDao().insertUnvan(unvan);

            unvan.setUnvanID(5);
            unvan.setUnvanName("Kumbaracı");
            instance.getDao().insertUnvan(unvan);

            unvan.setUnvanID(6);
            unvan.setUnvanName("Tutumlu");
            instance.getDao().insertUnvan(unvan);

            unvan.setUnvanID(7);
            unvan.setUnvanName("Yeni bıraktı");
            instance.getDao().insertUnvan(unvan);

            unvan.setUnvanID(8);
            unvan.setUnvanName("İstikrarlı");
            instance.getDao().insertUnvan(unvan);

            unvan.setUnvanID(9);
            unvan.setUnvanName("İradeli");
            instance.getDao().insertUnvan(unvan);

            unvan.setUnvanID(10);
            unvan.setUnvanName("Eski içici");
            instance.getDao().insertUnvan(unvan);

            unvan.setUnvanID(11);
            unvan.setUnvanName("Sosyal bırakıcı");
            instance.getDao().insertUnvan(unvan);

            unvan.setUnvanID(12);
            unvan.setUnvanName("Çok sosyal");
            instance.getDao().insertUnvan(unvan);

            unvan.setUnvanID(13);
            unvan.setUnvanName("Aşırı sosyal");
            instance.getDao().insertUnvan(unvan);

        }
    }


}


