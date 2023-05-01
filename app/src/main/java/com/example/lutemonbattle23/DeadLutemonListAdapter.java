package com.example.lutemonbattle23;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class DeadLutemonListAdapter extends RecyclerView.Adapter<DeadLutemonsViewHolder> {

    private Context context;

    private ArrayList<Lutemon> deadLutemons;

    private RecyclerView recyclerView;

    public DeadLutemonListAdapter(Context context, ArrayList<Lutemon> deadLutemons, RecyclerView recyclerView) {
        this.context = context;
        this.deadLutemons = deadLutemons;
        this.recyclerView = recyclerView;
    }

    @NonNull
    @Override
    public DeadLutemonsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new DeadLutemonsViewHolder(LayoutInflater.from(context).inflate(R.layout.dead_lutemon_view,parent,false), recyclerView);
    }

    @Override
    public void onBindViewHolder(@NonNull DeadLutemonsViewHolder holder, int position) {
        holder.bind(deadLutemons.get(position));
    }
    public void sortLutemons(ArrayList<Lutemon> lutemonList) {
        Collections.sort(lutemonList, new Comparator<Lutemon>() {
            @Override
            // Sort Lutemons by their name
            public int compare(Lutemon lutemon, Lutemon t1) {
                return lutemon.getName().compareTo(t1.getName());
            }
        });
        deadLutemons = lutemonList;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return deadLutemons.size();
    }
}
