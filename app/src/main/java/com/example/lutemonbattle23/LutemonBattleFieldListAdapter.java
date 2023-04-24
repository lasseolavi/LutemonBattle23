package com.example.lutemonbattle23;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class LutemonBattleFieldListAdapter extends RecyclerView.Adapter<LutemonBattleFieldViewHolder> {
    private ArrayList<Lutemon> battleFieldLutemons, selectedLutemons;





    public LutemonBattleFieldListAdapter(ArrayList<Lutemon> lutemons) {
        battleFieldLutemons = lutemons;
    }


    @NonNull
    @Override
    public LutemonBattleFieldViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new LutemonBattleFieldViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.lutemon_battle_field_view, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull LutemonBattleFieldViewHolder holder, int position) {
        Lutemon lutemon = battleFieldLutemons.get(position);
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
        return battleFieldLutemons.size();
    }
    public ArrayList getSelectedLutemons() {
        return selectedLutemons;
    }
}
