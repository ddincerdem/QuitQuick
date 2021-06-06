package com.example.quitquick;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;

import com.example.quitquick.Entities.Message;
import com.example.quitquick.Entities.Unvan;
import com.example.quitquick.Entities.User;
import com.example.quitquick.ViewModels.MessageVM;
import com.example.quitquick.ViewModels.UnvanVM;
import com.example.quitquick.ViewModels.UserVM;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    Context context;
    List<Message> messages;
    public UserVM userVM;
    Message msg;
    User Sender;
    UnvanVM unvanVM;
    Unvan unvan;
    MessageVM messageVM;

    public MyAdapter(Context ct,List<Message> msg,UserVM VM,UnvanVM uw,MessageVM mVM){
     context = ct;
     messages = msg;
     userVM = VM;
     unvanVM= uw;
     messageVM = mVM;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.item_sent,parent,false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
             msg = messages.get(position);
             try {
                 Sender = userVM.findUserById(msg.getSenderId());
             }catch (Exception e){
                 messageVM.deleteMessage(msg);
             }
            try{
              unvan = unvanVM.getUnvanById(Sender.getSelectedUnvanID());
              holder.isim.setText(unvan.getUnvanName()+" "+Sender.getFirstName() +" "+Sender.getLastName());

            }catch (Exception e){

              holder.isim.setText(Sender.getFirstName() +" "+Sender.getLastName());
             }
            if (msg != null) {
                holder.mesaj.setText(msg.getMessage());
            }
    }
    @Override
    public int getItemCount() {
        return messages.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView isim,mesaj;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            isim = itemView.findViewById(R.id.sender);
            mesaj = itemView.findViewById(R.id.messagedetail);
        }
    }
}
