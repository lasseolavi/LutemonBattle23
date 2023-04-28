package com.example.lutemonbattle23;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


public class InformationActivity extends AppCompatActivity {
    private TextView head, training, battles, winRate;
    private Lutemon lutemon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information);

        head = findViewById(R.id.informationHeadTv);
        training = findViewById(R.id.informationLutemonTrainingDaysTv);
        battles = findViewById(R.id.informationBattlesWonTv);
        winRate = findViewById(R.id.informationWinRate);

        lutemon = (Lutemon) getIntent().getSerializableExtra("infoLutemon");
        head.setText("Lutemonin " + lutemon.getName() + " (" + lutemon.getColor() + ") tiedot");
        training.setText("Lutemon on treenannut " + lutemon.getTrainingDays() + " päivää");
        battles.setText("Lutemon on tapellut " + lutemon.getGamesPlayed() + " kertaa ja voittanut niistä " + lutemon.getGamesWon());
        if (lutemon.gamesPlayed == 0) {
            winRate.setText("Lutemon on voittanut 0% otteluistaan");
        } else {
            float winrate = (float)lutemon.getGamesWon() / lutemon.getGamesPlayed();
            int percent = (int) (winrate*100);
            String rate = String.format("%d%%", percent);
            winRate.setText("Lutemon on voittanut " + rate + " otteluistaan");
        }
    }
}
