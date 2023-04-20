package com.example.lutemonbattle23;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class LutemonBattleFieldListAdapter extends RecyclerView.Adapter<LutemonBattleFieldViewHolder> {
    private ArrayList<Lutemon> battleFieldLutemons;
    private int count;
    private Lutemon firstSelected;
    private Lutemon secondSelected;
    private Button startBattleButton;
    private StartBattleListener mListener;

    public LutemonBattleFieldListAdapter(ArrayList<Lutemon> lutemons) {
        battleFieldLutemons = lutemons;
        count = 0;
    }
    public void setStartBattleListener(StartBattleListener listener) {
        mListener = listener;
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

        holder.getCheckBox().setOnCheckedChangeListener((compoundButton, isChecked) -> {
            if (isChecked) {
                count++;

                if (count == 1) {
                    firstSelected = lutemon;
                } else if (count == 2) {
                    secondSelected = lutemon;
                }
            } else {
                count--;

                if (firstSelected == lutemon) {
                    firstSelected = null;
                } else if (secondSelected == lutemon) {
                    secondSelected = null;
                }
            }
            //TODO: Tässä kohtaaa oikeat oliot tallentuu, nyt pitää keksiä tapa saada taistelu aloitettua vasta napppia painamalla
        });
    }
    public Lutemon getFirstSelected(){
        return firstSelected;
    }
    public Lutemon getSecondSelected(){
        return secondSelected;
    }

    @Override
    public int getItemCount() {
        return battleFieldLutemons.size();
    }
}
