package com.example.lutemonbattle23;

import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class DeadLutemonsViewHolder extends RecyclerView.ViewHolder{

    private TextView name, attack_defence, health_experience;
    private ImageView lutemonAvatar;

    private Button reviveButton;
    private Storage storage;
    private Context context;

    private RecyclerView recyclerView;

    public DeadLutemonsViewHolder(@NonNull View itemView, RecyclerView recyclerView) {
        super(itemView);
        context = itemView.getContext();
        lutemonAvatar = itemView.findViewById(R.id.imageView);
        name = itemView.findViewById(R.id.tv_name);
        attack_defence = itemView.findViewById(R.id.tv_attack_defense);
        health_experience = itemView.findViewById(R.id.tv_health_experience);
        reviveButton = itemView.findViewById(R.id.reviveButton);
        this.recyclerView = recyclerView;


        reviveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                storage = Storage.getInstance();
                int position = getAdapterPosition();
                Lutemon revivableLutemon = (Lutemon) storage.getDeadLutemons().get(position);
                if (context != null) {
                    DeadLutemonListAdapter adapter = (DeadLutemonListAdapter) recyclerView.getAdapter();
                    storage.reviveLutemon(revivableLutemon);
                    storage.saveCurrentState(context);
                    adapter.notifyDataSetChanged();
                    adapter.notifyItemRangeChanged(position, adapter.getItemCount());
                    Toast.makeText(context, "Lutemon elvytetty", Toast.LENGTH_SHORT);
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
