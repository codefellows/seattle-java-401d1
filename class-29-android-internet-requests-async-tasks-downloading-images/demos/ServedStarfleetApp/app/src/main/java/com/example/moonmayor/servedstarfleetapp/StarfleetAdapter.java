package com.example.moonmayor.servedstarfleetapp;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

class StarfleetAdapter extends RecyclerView.Adapter<StarfleetAdapter.ViewHolder>{
    private StarfleetPersonnel[] persons;

    public StarfleetAdapter() {
        persons = new StarfleetPersonnel[0];
    }

    public StarfleetAdapter(StarfleetPersonnel[] persons) {
       this.persons = persons;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Log.d("listadapter", "onCreate");
        View view = LayoutInflater.from(parent.getContext()).inflate(
                R.layout.starfleet_list_item,
                parent, false
        );

        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Log.d("listadapter", "onBind");
        StarfleetPersonnel person = this.persons[position];
        holder.name.setText(person.name);
        holder.rank.setText(person.rank);
    }

    @Override
    public int getItemCount() {
        return persons.length;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public View view;

        public StarfleetPersonnel person;
        public TextView name;
        public TextView rank;

        public ViewHolder(View itemView) {
            super(itemView);
            this.view = itemView;

            name = itemView.findViewById(R.id.name);
            rank = itemView.findViewById(R.id.rank);
        }
    }
}
