package com.example.lutemonbattle23;

import android.view.View;
import android.widget.CheckBox;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class LutemonBattleFieldViewHolder extends RecyclerView.ViewHolder {

    private CheckBox checkBox;


    public LutemonBattleFieldViewHolder(@NonNull View itemView) {
        super(itemView);

        checkBox = itemView.findViewById(R.id.lutemonCheckBox);
    }
    public void bind(Lutemon lutemon) {
        checkBox.setText(lutemon.getName() + " (" + lutemon.getColor() + ")");
    }
    public CheckBox getCheckBox() {
        return checkBox;
    }
}
