package com.example.quitquick;

        import androidx.annotation.RequiresApi;
        import androidx.appcompat.app.AppCompatActivity;
        import androidx.lifecycle.LiveData;
        import androidx.lifecycle.ViewModelProvider;

        import android.content.Intent;
        import android.os.Build;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.Button;
        import android.widget.ImageView;
        import android.widget.TextView;

        import com.example.quitquick.Entities.User;
        import com.example.quitquick.ViewModels.UserVM;

        import java.text.ParseException;
        import java.text.SimpleDateFormat;
        import java.time.LocalDate;
        import java.time.format.DateTimeFormatter;
        import java.util.Date;

public class ProfileActivity extends AppCompatActivity {

    public User user;
    int UserID;
    UserVM userVM;
    ImageView LogOut;
    Button Update;
    Button Delete;
    ImageView ProfilePic;
    TextView  Name;
    TextView Surname;
    TextView Email;
    TextView Cigars;
    TextView Money;
    SessionManagament sessionManagament;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        sessionManagament = new SessionManagament(this);
        LogOut = (ImageView)findViewById(R.id.btnLogOut);
        Update = (Button)findViewById(R.id.btnUpdate);
        Delete=(Button)findViewById(R.id.btnDeletAccount);
        ProfilePic=(ImageView)findViewById(R.id.imgProfilePic);
        Name = (TextView)findViewById(R.id.txtProfileName);
        Surname=(TextView)findViewById(R.id.txtProfileSurname);
        Email=(TextView)findViewById(R.id.txtProfileEmail);
        Cigars =(TextView)findViewById(R.id.txtProfileCig);
        Money = (TextView)findViewById(R.id.txtProfileMoney);
        UserID = sessionManagament.getSession();
        userVM = new ViewModelProvider(this).get(com.example.quitquick.ViewModels.UserVM.class);
        user = userVM.findUserById(UserID);

        Delete.setOnClickListener(v-> {
            userVM.deleteUser(user);
            sessionManagament.removeSession();
            openActivity();
        });
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onStart() {
        super.onStart();
        try {
            setAll(user);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public void logOut(View view) {
        SessionManagament sessionManagament = new SessionManagament(ProfileActivity.this);
        sessionManagament.removeSession();

        openActivity();
    }

    private void openActivity() {
        Intent intentLogin = new Intent(ProfileActivity.this,LoginActivity.class);
        intentLogin.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intentLogin);
    }


    @RequiresApi(api = Build.VERSION_CODES.O)
    public void setAll(User user) throws ParseException {
        String isim = user.getFirstName();
        String soyisim = user.getLastName();
        String email = user.getEmail();

        Name.setText(isim);
        Surname.setText(soyisim);
        Email.setText(email);
        Money.setText(Calculations.EarnedMoney(user.getHowManyCigInPack(),user.getPricePerPack(),user.CigPerDay,user.StartDate)+"TL");
        Cigars.setText(Calculations.cigsNotSmoked(user.getCigPerDay(),user.getStartDate()));
    }



}
