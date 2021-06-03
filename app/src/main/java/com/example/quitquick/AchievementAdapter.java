package com.example.quitquick;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.LiveData;

import com.example.quitquick.Entities.Achievement;

import java.lang.reflect.Array;
import java.util.List;

public class AchievementAdapter extends ArrayAdapter<Achievement> {
    private List<Achievement> achievements;
    Context context;
    int layoutId;

    public AchievementAdapter(@NonNull Context context, int resource, @NonNull List<Achievement> achievementList) {
        super(context, resource,  achievementList);
        this.context = context;
        this.layoutId = resource;
        this.achievements = achievementList;
    }
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent){
        LayoutInflater inflater =LayoutInflater.from(context);
        View view = inflater.inflate(layoutId,parent,false);

        TextView tvAchDescription = view.findViewById(R.id.achievementDesc);
        TextView tvAchProgress = view.findViewById(R.id.achievementProgress);
        Button btnUnlock = view.findViewById(R.id.btnUnlockTitle);

        Achievement ach = achievements.get(position);
        tvAchDescription.setText(ach.getAchDesc());
        tvAchProgress.setText("1");




        return view;
    }
}
