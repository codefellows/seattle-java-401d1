package com.example.moonmayor.whatswhatsapp.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.moonmayor.whatswhatsapp.ConversationActivity;
import com.example.moonmayor.whatswhatsapp.R;
import com.example.moonmayor.whatswhatsapp.models.ChatMessage;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by moonmayor on 10/4/17.
 */

public class MessageListAdapter extends ArrayAdapter<ChatMessage> {
    private Context mContext;
    private List<ChatMessage> mMessages;

    public class ViewHolder {
        public View mView;
        public TextView mMessageUsername;
        public TextView mMessageText;
        public TextView mMessageTimestamp;

        public ChatMessage mMessage;

        public ViewHolder(View view, ChatMessage message) {
            this.mView = view;
            this.mMessage = message;

            mMessageUsername = view.findViewById(R.id.messageUsername);
            mMessageText = view.findViewById(R.id.messageText);
            mMessageTimestamp = view.findViewById(R.id.messageTimestamp);
        }
    }

    public MessageListAdapter(Context context, int resource, List<ChatMessage> messages) {
        super(context, resource, messages);
        mContext = context;
        mMessages = messages;
    }



    @Override
    public int getCount() {
        return mMessages.size();
    }

    @Nullable
    @Override
    public ChatMessage getItem(int position) {
        return mMessages.get(position);
    }

    @Override
    public boolean isEmpty() {
        return this.mMessages.isEmpty();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ChatMessage message = this.getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(mContext).inflate(R.layout.chat_message, parent, false);
            convertView.setTag(new ViewHolder(convertView, message));
        }

        ViewHolder holder = (ViewHolder) convertView.getTag();
        holder.mMessageUsername.setText(message.username);
        holder.mMessageText.setText(message.message);

        String timestamp = (new SimpleDateFormat("YYYY MM/dd HH:mm")).format(new Date(message.timestamp));
        holder.mMessageTimestamp.setText(timestamp);

        return convertView;
    }
}
