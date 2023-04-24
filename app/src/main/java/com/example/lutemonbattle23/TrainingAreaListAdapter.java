package com.example.lutemonbattle23;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class TrainingAreaListAdapter extends RecyclerView.Adapter<TrainingAreaViewHolder> {
    private ArrayList<Lutemon> trainingAreaLutemons, selectedLutemons;

    public TrainingAreaListAdapter(ArrayList<Lutemon> lutemons) {
        trainingAreaLutemons = lutemons;
    }
    @NonNull
    @Override
    public TrainingAreaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new TrainingAreaViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.lutemon_training_area_view, parent, false));
    }


    @Override
    public void onBindViewHolder(@NonNull TrainingAreaViewHolder holder, int position) {
        Lutemon lutemon = trainingAreaLutemons.get(position);
        holder.bind(lutemon);
        selectedLutemons = new ArrayList<>();

        holder.getCheckBox().setOnCheckedChangeListener((compoundButton, isChecked) -> {
            if (isChecked) {
                selectedLutemons.add(lutemon);

            } else {
                selectedLutemons.remove(lutemon);

            }
        });
    }

    @Override
    public int getItemCount() {
        return trainingAreaLutemons.size();
    }

    public ArrayList<Lutemon> getSelectedLutemons() {
        return selectedLutemons;
    }
}
