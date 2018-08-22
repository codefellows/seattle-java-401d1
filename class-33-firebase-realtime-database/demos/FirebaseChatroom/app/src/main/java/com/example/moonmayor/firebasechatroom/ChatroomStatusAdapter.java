package com.example.moonmayor.firebasechatroom;

import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

class ChatroomStatusAdapter extends RecyclerView.Adapter<ChatroomStatusAdapter.StatusViewHolder> {
    private List<ChatroomStatus> mStatuses;

    public ChatroomStatusAdapter(List<ChatroomStatus> statuses) {
        this.mStatuses = statuses;
    }

    @Override
    public StatusViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.status_item, parent, false);

        StatusViewHolder vh = new StatusViewHolder(view);
        return vh;
    }

    @Override
    public void onBindViewHolder(StatusViewHolder holder, int position) {
        ChatroomStatus status = mStatuses.get(position);
        holder.bind(status);
    }

    @Override
    public int getItemCount() {
        return mStatuses.size();
    }

    public void setStatuses(List<ChatroomStatus> statuses) {
        this.mStatuses = statuses;
    }

    public class StatusViewHolder extends RecyclerView.ViewHolder {
        View mView;

        private ImageView statusIcon;
        private TextView username;
        private TextView statusText;

        private ChatroomStatus mStatus;

        public StatusViewHolder(View itemView) {
            super(itemView);
            mView = itemView;

            statusIcon = itemView.findViewById(R.id.statusIcon);
            username = itemView.findViewById(R.id.username);
            statusText = itemView.findViewById(R.id.statusText);
        }

        public void bind(ChatroomStatus status) {
            mStatus = status;

            this.setStatusIcon();

            username.setText(status.username);
            statusText.setText(status.statusText);
        }

        public void setStatusIcon() {
            // assume red offline by default
            int id = R.drawable.red;

            if (mStatus.status.equals("online")) {
                id = R.drawable.green;
            } else if (mStatus.status.equals("away")) {
                id = R.drawable.yellow;
            } else if (mStatus.status.equals("offline")) {
                // explicitly state that red is associated with offline even though it is also default
                id = R.drawable.red;
            }

            Drawable drawable = mView.getContext().getResources().getDrawable(id);
            statusIcon.setImageDrawable(drawable);
        }
    }

}
