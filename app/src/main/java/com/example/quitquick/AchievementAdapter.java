package com.example.quitquick;

import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;

import com.example.quitquick.Entities.Achievement;
import com.example.quitquick.Entities.UserAchievementCR;
import com.example.quitquick.Entities.UserUnvanCR;
import com.example.quitquick.ViewModels.AchievementVM;
import com.example.quitquick.ViewModels.MessageVM;
import com.example.quitquick.ViewModels.UnvanVM;
import com.example.quitquick.ViewModels.UserAchievementCRVM;
import com.example.quitquick.ViewModels.UserUnvanCRVM;
import com.example.quitquick.ViewModels.UserVM;

import java.io.Serializable;
import java.text.ParseException;
import java.util.List;
import java.util.Objects;

public class AchievementAdapter extends ArrayAdapter<Achievement> {
    private List<Achievement> achievements;
    Context context;
    int layoutId;
    int userID;
    private SessionManagament sessionManagament;
    private AchievementVM achievementVM;
    private UserVM userVM;
    public UnvanVM unvanVM;
    public MessageVM messageVM;
    public com.example.quitquick.Entities.User user;
    public UserUnvanCRVM userUnvanCRVM;
    public UserAchievementCRVM userAchievementCRVM;

    public AchievementAdapter(@NonNull Context context, int resource, @NonNull List<Achievement> achievementList) {
        super(context, resource,  achievementList);
        this.context = context;
        this.layoutId = resource;
        this.achievements = achievementList;
    }
    @RequiresApi(api = Build.VERSION_CODES.O)
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent){
        LayoutInflater inflater =LayoutInflater.from(context);
        View view = inflater.inflate(layoutId,parent,false);

        TextView tvAchDescription = view.findViewById(R.id.achievementDesc);
        TextView tvAchProgress = view.findViewById(R.id.achievementProgress);
        Button btnUnlock = view.findViewById(R.id.btnUnlockTitle);

        Achievement ach = achievements.get(position);
        tvAchDescription.setText(ach.getAchDesc());



        achievementVM = new ViewModelProvider((ViewModelStoreOwner) context).get(com.example.quitquick.ViewModels.AchievementVM.class);
        userVM = new ViewModelProvider((ViewModelStoreOwner) context).get(com.example.quitquick.ViewModels.UserVM.class);
        unvanVM = new ViewModelProvider((ViewModelStoreOwner) context).get(com.example.quitquick.ViewModels.UnvanVM.class);
        sessionManagament = new SessionManagament(context);
        userID = sessionManagament.getSession();
        user = userVM.findUserById(userID);
        messageVM = new ViewModelProvider((ViewModelStoreOwner)context).get(com.example.quitquick.ViewModels.MessageVM.class);
        userUnvanCRVM = new ViewModelProvider((ViewModelStoreOwner)context).get(com.example.quitquick.ViewModels.UserUnvanCRVM.class);
        userAchievementCRVM = new ViewModelProvider((ViewModelStoreOwner)context).get(com.example.quitquick.ViewModels.UserAchievementCRVM.class);
        try {
            Serializable  current= checkForProgress(achievements.get(position).getAchId());
            int objective = achievements.get(position).getAchievementObjective();
            tvAchProgress.setText(current+"/"+objective);

        } catch (ParseException e) {
            e.printStackTrace();
        }



        try {
            if(checkForAchieved(ach.getAchId())){
                btnUnlock.setClickable(true);
                btnUnlock.setText("Başardın!");
                btnUnlock.setHighlightColor(Color.BLUE);
                tvAchProgress.setText("✓✓✓");
                tvAchDescription.setTextColor(Color.BLUE);
                if (!Objects.isNull(isCollected(user.getUserID(),achievements.get(position).getAchId()))){

                    tvAchDescription.setTextColor(Color.BLACK);
                }


            }else{btnUnlock.setText("Kilitli.");btnUnlock.setEnabled(false);btnUnlock.setTextColor(Color.RED);tvAchDescription.setTextColor(Color.RED);}
        } catch (ParseException e) {
            e.printStackTrace();
        }

        btnUnlock.setOnClickListener(v -> {

            int unvanId = achievements.get(position).getAchId();
            int achId = achievements.get(position).getAchId();
            UserUnvanCR dummy = new UserUnvanCR();

            UserUnvanCR lamb;
            lamb = isCollected(user.getUserID(),unvanId);

            try {
                if (checkForAchieved(achId)) {
                    if(Objects.isNull(lamb)){

                        Toast.makeText(context, "" + unvanVM.getUnvanById(unvanId).getUnvanName() + " ünvanı açıldı. Tebrikler!", Toast.LENGTH_LONG).show();
                        dummy.setUnvanID(unvanId);
                        dummy.setUserID(user.getUserID());
                        userUnvanCRVM.insertUserUnvanCR(dummy);
                        UserAchievementCR dum = new UserAchievementCR();
                        dum.setAchievementID(achId);
                        dum.setUserID(user.getUserID());
                        userAchievementCRVM.insertUserAchievementCR(dum);
                        achDone(btnUnlock);
                        tvAchDescription.setTextColor(Color.BLACK);
                    }
                }
            } catch (ParseException e) {
                e.printStackTrace();
            }
        });

        return view;
    }
    @RequiresApi(api = Build.VERSION_CODES.O)
    public boolean checkForAchieved(int achId) throws ParseException {
        boolean flag =false;
        switch (achId){
            case 1:

                if (Double.parseDouble(Calculations.cigsNotSmoked(user.getCigPerDay(),user.getStartDate()))>=achievementVM.getAchievementById(achId))flag=true;

                break;

            case 2:

                if (Double.parseDouble(Calculations.cigsNotSmoked(user.getCigPerDay(),user.getStartDate()))>=achievementVM.getAchievementById(achId))flag=true;

                break;

            case 3:

                if (Double.parseDouble(Calculations.cigsNotSmoked(user.getCigPerDay(),user.getStartDate()))>=achievementVM.getAchievementById(achId))flag=true;

                break;

            case 4:

                if (Double.parseDouble(Calculations.EarnedMoney(user.getHowManyCigInPack(),user.getPricePerPack(),user.getCigPerDay(),user.getStartDate()))>=achievementVM.getAchievementById(achId))flag=true;

                break;

            case 5:

                if (Double.parseDouble(Calculations.EarnedMoney(user.getHowManyCigInPack(),user.getPricePerPack(),user.getCigPerDay(),user.getStartDate()))>=achievementVM.getAchievementById(achId))flag=true;

                break;

            case 6:

                if (Double.parseDouble(Calculations.EarnedMoney(user.getHowManyCigInPack(),user.getPricePerPack(),user.getCigPerDay(),user.getStartDate()))>=achievementVM.getAchievementById(achId))flag=true;

                break;

            case 7:

                if(Calculations.daysNotSmoked(user.getStartDate())>=achievementVM.getAchievementById(achId))flag=true;

                break;

            case 8:

                if(Calculations.daysNotSmoked(user.getStartDate())>=achievementVM.getAchievementById(achId))flag=true;

                break;

            case 9:

                if(Calculations.daysNotSmoked(user.getStartDate())>=achievementVM.getAchievementById(achId))flag=true;

                break;

            case 10:

                if(Calculations.daysNotSmoked(user.getStartDate())>=achievementVM.getAchievementById(achId))flag=true;

                break;

            case 11:

            if (messageVM.getUsersMessagesById(userID).size()>=achievementVM.getAchievementById(achId))flag=true;

                break;

            case 12:

                if (messageVM.getUsersMessagesById(userID).size()>=achievementVM.getAchievementById(achId))flag=true;

                break;

            case 13:

                if (messageVM.getUsersMessagesById(userID).size()>=achievementVM.getAchievementById(achId))flag=true;

                break;

            default:
                return flag;

        }

        return flag;
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public Serializable checkForProgress(int achId) throws ParseException {

                if (achId==1||achId==2||achId==3) {
                    return Integer.parseInt(Calculations.cigsNotSmoked(user.getCigPerDay(), user.getStartDate()));
                }else if(achId==4||achId==5||achId==6){
                    return  Calculations.EarnedMoney(user.getHowManyCigInPack(),user.getPricePerPack(),user.getCigPerDay(),user.getStartDate());
                }else if(achId==7||achId==8||achId==9||achId==10){
                    return (int) Calculations.daysNotSmoked(user.getStartDate());
                }else if(achId==11||achId==12||achId==13){
                    return messageVM.getUsersMessagesById(user.getUserID()).size();
                }

                return -1;



    }

    public void achDone(Button btnUnlock){btnUnlock.setText("Alındı.");btnUnlock.setEnabled(false);}

    public UserUnvanCR isCollected(int userID,int unvanID){
        return  userUnvanCRVM.checkIfUserHasUnvan(userID,unvanID);

    }
}
