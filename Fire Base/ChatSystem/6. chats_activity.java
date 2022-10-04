package com.example.whatsappclonejava.chats;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.whatsappclonejava.R;
import com.example.whatsappclonejava.databinding.ActivityChatsBinding;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Date;

public class chatsActivity extends AppCompatActivity {

    ActivityChatsBinding binding_chats;
    chats_adapter adapter_chat;
    ArrayList<chats_modal> messages; // this is for all the messages
    String senderRoom, recieverRoom;

    FirebaseDatabase database;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_chats);
        binding_chats = ActivityChatsBinding.inflate(getLayoutInflater());
        setContentView(binding_chats.getRoot());
        getSupportActionBar().hide();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        messages = new ArrayList<>();
        adapter_chat = new chats_adapter(this, messages);
        binding_chats.recyclerView.setLayoutManager(new LinearLayoutManager(this));

        binding_chats.recyclerView.setAdapter(adapter_chat);

        String name = getIntent().getStringExtra("name").toString(); // on click this will autmatically set the name  top for whom you are sending message

        String reciver_uid = getIntent().getStringExtra("uid").toString(); // on clicking we are getting the uid of reciever
        String senderUid = FirebaseAuth.getInstance().getUid(); // this is the id of send which means the user

        binding_chats.name.setText(name);


        // this is for the unique room
        senderRoom = senderUid + reciver_uid;
        recieverRoom = reciver_uid + senderUid;

        // get instance of the firebase database for storing messages
        database = FirebaseDatabase.getInstance();

        // sending message portion
        binding_chats.chatSendBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String sender_messageTxt = binding_chats.messageBox.getText().toString();
                binding_chats.messageBox.setText("");
                /*
                * we will create a new child where we can upload and get text
                * have to create the send the model class data
                * for time stamp, using date and time
                */
                Date date = new Date();
                chats_modal message  = new chats_modal(sender_messageTxt,senderUid);
                database.getReference().child("chats")
                        .child(senderRoom)
                        .child("messages")
                        .push()
                        .setValue(message).addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void unused) {

                                // SAME WORK FOR RECIEVING END
                                database.getReference().child("chats")
                                        .child(recieverRoom)
                                        .child("messages")
                                        .push()
                                        .setValue(message)
                                        .addOnSuccessListener(new OnSuccessListener<Void>() {
                                            @Override
                                            public void onSuccess(Void unused) {

                                            }
                                        });

                            }
                        });
            }
        });

        // setting message in the layout portion
        database.getReference().child("chats")
                .child(senderRoom)
                .child("messages")
                .addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        messages.clear();
                        for(DataSnapshot snapshot1: snapshot.getChildren()){
                            chats_modal message = snapshot1.getValue(chats_modal.class);
                            messages.add(message);
                        }
                        adapter_chat.notifyDataSetChanged();
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });

    }

    // for back button
    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return super.onSupportNavigateUp();
    }

    @Override
    protected void onStart() {
        super.onStart();
        binding_chats.recyclerView.scrollToPosition(adapter_chat.getItemCount()-1);
    }
}
