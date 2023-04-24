package com.example.lutemonbattle23;

import android.view.View;
import android.widget.CheckBox;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class TrainingAreaViewHolder extends RecyclerView.ViewHolder {
    private CheckBox checkBox;


    public TrainingAreaViewHolder(@NonNull View itemView) {
        super(itemView);

        checkBox = itemView.findViewById(R.id.trainingCheckBox);
    }
    public void bind(Lutemon lutemon) {
        checkBox.setText(lutemon.getName() + " (" + lutemon.getColor() + ")");
    }
    public CheckBox getCheckBox() {
        return checkBox;
    }
}
