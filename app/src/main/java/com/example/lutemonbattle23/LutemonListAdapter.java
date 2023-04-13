package com.example.lutemonbattle23;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class LutemonListAdapter extends RecyclerView.Adapter<LutemonViewHolder> {

    private Context context;

    private ArrayList<Lutemon> lutemons;

    public LutemonListAdapter(Context context, ArrayList<Lutemon> lutemons) {
        this.context = context;
        this.lutemons = lutemons;
    }

    @NonNull
    @Override
    public LutemonViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new LutemonViewHolder(LayoutInflater.from(context).inflate(R.layout.lutemon_view,parent,false));
    }
    public void sortLutemons(ArrayList<Lutemon> lutemonList) {
        Collections.sort(lutemonList, new Comparator<Lutemon>() {
            @Override
            public int compare(Lutemon lutemon, Lutemon t1) {
                return lutemon.getName().compareTo(t1.getName());
            }
        });
        lutemons = lutemonList;
        notifyDataSetChanged();
    }

    @Override
    public void onBindViewHolder(@NonNull LutemonViewHolder holder, int position) {
        holder.bind(lutemons.get(position));
    }

    @Override
    public int getItemCount() {
        return lutemons.size();
    }
}
