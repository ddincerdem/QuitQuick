package com.example.quitquick;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.quitquick.Entities.Message;
import com.example.quitquick.ViewModels.MessageVM;
import com.example.quitquick.ViewModels.UnvanVM;
import com.example.quitquick.ViewModels.UserVM;

import java.util.List;

public class CommunityActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    List<Message> messages;
    MessageVM messageVM;
    UserVM userVM;
    UnvanVM unvanVM;
    EditText messageBox;
    SessionManagament sessionManagament;
    Message WholeMessage;
    String message;
    int senderID;
    MessageVM msgVM;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_community);

        messageBox = (EditText)findViewById(R.id.messageBox);

        messageVM = new ViewModelProvider(this).get(com.example.quitquick.ViewModels.MessageVM.class);
        messages = messageVM.getAllMessages();
        userVM = new ViewModelProvider(this).get(com.example.quitquick.ViewModels.UserVM.class);
        unvanVM = new ViewModelProvider(this).get(com.example.quitquick.ViewModels.UnvanVM.class);
        msgVM = new ViewModelProvider(this).get(com.example.quitquick.ViewModels.MessageVM.class);
        sessionManagament = new SessionManagament(this);

        recyclerView = findViewById(R.id.recyclerView);
        MyAdapter myAdapter = new MyAdapter(this,messages,userVM,unvanVM,msgVM);
        recyclerView.setAdapter(myAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


    }

    public void sendMessage(View view) {
        senderID = sessionManagament.getSession();
        message = String.valueOf(messageBox.getText());
        WholeMessage = new Message(senderID,message,"04.06.2021");
        messageVM.insertMessage(WholeMessage);
        messageBox.setText(" ");
        Toast.makeText(getApplicationContext(), "Mesajınız Alındı", Toast.LENGTH_SHORT).show();

        Intent i = new Intent(CommunityActivity.this, CommunityActivity.class);
        startActivity(i);
    }

    public void back(View view) {
        finish();
        Intent i = new Intent(CommunityActivity.this, HomeActivity.class);
        startActivity(i);
    }
}
