package com.example.lutemonbattle23;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


public class InformationActivity extends AppCompatActivity {
    private TextView head, training, battles, winRate;
    private Lutemon lutemon;
    private ImageView avatar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information);

        head = findViewById(R.id.informationHeadTv);
        training = findViewById(R.id.informationLutemonTrainingDaysTv);
        battles = findViewById(R.id.informationBattlesWonTv);
        winRate = findViewById(R.id.informationWinRate);
        avatar = findViewById(R.id.avatarImageView);

        lutemon = (Lutemon) getIntent().getSerializableExtra("infoLutemon");
        head.setText("Lutemonin " + lutemon.getName() + " (" + lutemon.getColor() + ") tiedot");
        switch (lutemon.getAvatarImage()) {
            case 0:
                avatar.setImageResource(R.drawable.blackavatar);
                break;
            case 1:
                avatar.setImageResource(R.drawable.greenavatar);
                break;
            case 2:
                avatar.setImageResource(R.drawable.orangeavatar);
                break;
            case 3:
                avatar.setImageResource(R.drawable.pinkavatar);
                break;
            case 4:
                avatar.setImageResource(R.drawable.whiteavatar);
                break;
        }
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
