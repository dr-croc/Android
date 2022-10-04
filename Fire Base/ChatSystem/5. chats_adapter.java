package com.example.whatsappclonejava.chats;

import android.content.Context;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.whatsappclonejava.R;
import com.example.whatsappclonejava.databinding.ItemReceieveBinding;
import com.example.whatsappclonejava.databinding.ItemSentBinding;
import com.google.firebase.auth.FirebaseAuth;

import java.util.ArrayList;

public class chats_adapter extends  RecyclerView.Adapter {

    Context context;
    ArrayList<chats_modal> chats_modals;

    public chats_adapter(Context context, ArrayList<chats_modal> chats_modals) {
        this.context = context;
        this.chats_modals = chats_modals;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == Item_Sent){
            View view = LayoutInflater.from(context).inflate(R.layout.item_sent,parent,false);
            return new sent_ViewHolder(view);
        }
        else
        {
            View view = LayoutInflater.from(context).inflate(R.layout.item_receieve,parent,false);
            return  new receiever_viewHolder(view);
        }

    }

    // this is only when you have multiple views
    final int Item_Sent = 1;
    final  int Item_receive = 2;
    @Override
    public int getItemViewType(int position) {
        chats_modal chatsModal = chats_modals.get(position);
        if(FirebaseAuth.getInstance().getUid().equals(chatsModal.getSenderId())){
            // so here the condition which is implemented is, when your user id is similar to the senderId, that means its you who is senting
            return Item_Sent;
        }
        else {
            return Item_receive;
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        chats_modal message = chats_modals.get(position);

        if(holder.getClass() == sent_ViewHolder.class){
            sent_ViewHolder viewHolder = (sent_ViewHolder) holder;
            viewHolder.send_bind.senderMessage.setText(message.getMessage());
        }
        else {
            receiever_viewHolder viewHolder = (receiever_viewHolder) holder;
            viewHolder.receieve_Binding.recieverMessage.setText(message.getMessage());
        }

    }

    @Override
    public int getItemCount() {
        return chats_modals.size();
    }



    // for receiever
    public class receiever_viewHolder extends RecyclerView.ViewHolder{
        ItemReceieveBinding receieve_Binding;
        public receiever_viewHolder(@NonNull View itemView) {
            super(itemView);
            receieve_Binding = ItemReceieveBinding.bind(itemView);
        }
    }



    // for sender
    public class sent_ViewHolder extends RecyclerView.ViewHolder{
        ItemSentBinding send_bind;
        public sent_ViewHolder(@NonNull View itemView) {
            super(itemView);
            send_bind = ItemSentBinding.bind(itemView);
        }
    }
}

// 1st create the viewholder
// 2nd extend the class and implemnt the method
// 3rd get the context and array list and get the constructor
// 4th work on onCreateViewHolder
