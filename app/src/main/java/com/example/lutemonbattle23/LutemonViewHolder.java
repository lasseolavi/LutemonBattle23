package com.example.lutemonbattle23;

import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class LutemonViewHolder extends RecyclerView.ViewHolder {

    private TextView name, attack, defense, health, experience;
    private ImageView lutemonAvatar;





    public LutemonViewHolder(@NonNull View itemView) {
        super(itemView);
        lutemonAvatar = itemView.findViewById(R.id.imageView);
        name = itemView.findViewById(R.id.tv_name);
        attack = itemView.findViewById(R.id.tv_attack);
        defense = itemView.findViewById(R.id.tv_defense);
        health = itemView.findViewById(R.id.tv_health);
        experience = itemView.findViewById(R.id.tv_experience);
    }

    public void bind(Lutemon lutemon){
        name.setText(lutemon.getName()+" ("+lutemon.getColor()+")");
        attack.setText("Hyökkäys: "+lutemon.getAttack());
        defense.setText("Puolustus: "+lutemon.getDefense());
        health.setText("Elämä: "+lutemon.getHealth()+"/"+lutemon.getMaxHealth());
        experience.setText("Kokemus: "+lutemon.getExperience());

    }
}
