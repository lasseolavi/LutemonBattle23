package com.example.lutemonbattle23;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class LutemonViewHolder extends RecyclerView.ViewHolder {

    private TextView name, attack_defence, health_experience;
    private ImageView lutemonAvatar;

    private Button infoButton;
    private Storage storage;
    private Context context;




    public LutemonViewHolder(@NonNull View itemView) {
        super(itemView);
        context = itemView.getContext();
        lutemonAvatar = itemView.findViewById(R.id.imageView);
        name = itemView.findViewById(R.id.tv_name);
        attack_defence = itemView.findViewById(R.id.tv_attack_defense);
        health_experience = itemView.findViewById(R.id.tv_health_experience);
        infoButton = itemView.findViewById(R.id.reviveButton);


        infoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                storage = Storage.getInstance();
                int position = getAdapterPosition();
                Lutemon infoLutemon = (Lutemon) storage. listLutemons().get(position);
                if (context != null) {
                    Intent intent = new Intent(context, InformationActivity.class);
                    intent.putExtra("infoLutemon", infoLutemon);
                    context.startActivity(intent);
                }
            }
        });
    }

    public void bind(Lutemon lutemon){
        name.setText(lutemon.getName()+" ("+lutemon.getColor()+")");
        attack_defence.setText("Hyökkäys: "+lutemon.getAttack() + ", Puolustus: " + lutemon.getDefense());
        health_experience.setText("Elämä: "+lutemon.getHealth()+"/"+lutemon.getMaxHealth() + ", Kokemus: " + lutemon.getExperience());
        switch (lutemon.getAvatarImage()) {
            case 0:
                lutemonAvatar.setImageResource(R.drawable.blackavatar);
                break;
            case 1:
                lutemonAvatar.setImageResource(R.drawable.greenavatar);
                break;
            case 2:
                lutemonAvatar.setImageResource(R.drawable.orangeavatar);
                break;
            case 3:
                lutemonAvatar.setImageResource(R.drawable.pinkavatar);
                break;
            case 4:
                lutemonAvatar.setImageResource(R.drawable.whiteavatar);
                break;
        }


    }
}
