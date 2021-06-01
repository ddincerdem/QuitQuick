package com.example.quitquick;

import android.os.Build;
import android.os.Bundle;
import android.provider.CalendarContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.StringRes;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModelProvider;

import com.example.quitquick.Entities.Health;
import com.example.quitquick.ViewModels.HealthVM;

import java.util.List;

public class SliderItemFragment extends Fragment {

    public List<Health> healthList;
    public HealthVM healthVM;


    private static final String ARG_POSITION = "slider-position";

    // prepare all subtitle images arrays
    @StringRes
    private static final int[] PAGE_IMAGE =
            new int[] {
                    R.drawable.ic_heart_attack,R.drawable.ic_smell_and_taste,R.drawable.ic_blood_nicotine,
                    R.drawable.ic_success,R.drawable.ic_lungs,R.drawable.ic_lungs_growing,
                    R.drawable.ic_blood_circulation,R.drawable.ic_stress,R.drawable.ic_lung_enfection,
                    R.drawable.ic_heart_disease,R.drawable.ic_blood_cloth
            };
    // prepare all background images arrays
    @StringRes
    private static final int[] BG_IMAGE = new int[] {
           /* R.drawable.ic_bg_red, R.drawable.ic_bg_blue, R.drawable.ic_bg_green,
            R.drawable.ic_bg_purple*/
    };

    private int position;
    public SliderItemFragment() {
        // Required empty public constructor
    }
    /**
     * Use this factory method to create a new instance of
     *
     * @return A new instance of fragment SliderItemFragment.
     */
    public static SliderItemFragment newInstance(int position) {
        SliderItemFragment fragment = new SliderItemFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_POSITION, position);
        fragment.setArguments(args);
        return fragment;
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            position = getArguments().getInt(ARG_POSITION);
        }
        healthVM = new ViewModelProvider(this).get(com.example.quitquick.ViewModels.HealthVM.class);
        healthList = healthVM.getAllHealth();
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_slider_item, container, false);

    }
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP) @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        // set page background
        view.setBackgroundColor(7369);
        //view.setBackground(requireActivity().getDrawable(BG_IMAGE[2]));
        TextView title = view.findViewById(R.id.textView);
        TextView titleText = view.findViewById(R.id.textView2);
        ImageView imageView = view.findViewById(R.id.imageView);
        // set page title
        title.setText(healthList.get(position).getDuration()+" Günden sonra");

        // set page sub title text
        titleText.setText(healthList.get(position).getDescription());
        // set page image
        imageView.setImageResource(PAGE_IMAGE[position]);
    }
}