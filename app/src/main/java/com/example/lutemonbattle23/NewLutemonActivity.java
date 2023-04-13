package com.example.lutemonbattle23;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioGroup;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

public class NewLutemonActivity extends AppCompatActivity {
    private Context context;

    private EditText nameEditText;
    private RadioGroup colorRG;
    private int id = 0;
    private LutemonListAdapter lutemonListAdapter;
    private RecyclerView recyclerView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_lutemon);
        context = this;

    }

    public void addLutemon(View view) {
        colorRG = findViewById(R.id.radioGroup);
        nameEditText = findViewById(R.id.editTextName);

        String name = nameEditText.getText().toString();

        String color = "";
        int attack = 0;
        int defense = 0;
        int experience = 0;
        int health = 0;
        int maxHealth = 0;

        switch (colorRG.getCheckedRadioButtonId()) {
            case R.id.whiteButton:
                color = "valkoinen";
                attack = 5;
                defense = 4;
                maxHealth = 20;
                break;
            case R.id.greenButton:


                color = "vihreä";
                attack = 6;
                defense = 3;
                maxHealth = 19;
                break;
            case R.id.pinkButton:
                color = "pinkki";
                attack = 7;
                defense = 2;
                maxHealth = 18;
                break;
            case R.id.orangeButton:
                color = "oranssi";
                attack = 8;
                defense = 1;
                maxHealth = 17;
                break;
            case R.id.blackButton:
                color = "musta";
                attack = 9;
                defense = 0;
                maxHealth = 16;
                break;
        }

        health = maxHealth;

        Lutemon lutemon = new Lutemon (name, color, attack, defense, experience, health, maxHealth, id++);
        Storage.getInstance().addLutemon(lutemon, context);
        lutemonListAdapter = new LutemonListAdapter(context,Storage.getInstance().listLutemons());
        int position = Storage.getInstance().listLutemons().size()-1;
        lutemonListAdapter.notifyItemInserted(position);
        //TODO: id nollaantuu kun sovelluksen sammuttaa
    }

}
