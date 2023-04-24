package com.example.lutemonbattle23;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class BattleFieldActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private TextView firstSelectionTv, secondSelectionTv, battleLogTv;
    private LutemonBattleFieldListAdapter lutemonBattleFieldListAdapter;
    private Storage storage;
    private Button startBattleButton;
    private Lutemon firstSelection;
    private Lutemon secondSelection;
    private BattleFieldScreen screen;
    Handler handler = new Handler();
    private ArrayList<Lutemon> selectedLutemons;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_battle_field);

        storage = Storage.getInstance();

        recyclerView = findViewById(R.id.rvBattleLutemons);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        lutemonBattleFieldListAdapter = new LutemonBattleFieldListAdapter(storage.listLutemons());
        recyclerView.setAdapter(lutemonBattleFieldListAdapter);


        startBattleButton = findViewById(R.id.startBattleButton);
        firstSelectionTv = findViewById(R.id.firstPlayerTv);
        secondSelectionTv = findViewById(R.id.secondPlayerTv);
        battleLogTv = findViewById(R.id.battleLogTv);
        startBattleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectedLutemons = lutemonBattleFieldListAdapter.getSelectedLutemons();
                if (selectedLutemons.size() == 2) {
                    firstSelection = selectedLutemons.get(0);
                    secondSelection = selectedLutemons.get(1);
                    try {
                        StartBattle(firstSelection,secondSelection);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }

                } else {
                    Toast.makeText(BattleFieldActivity.this, "Valitse kaksi lutemonia", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    public void StartBattle(Lutemon firstSelected, Lutemon secondSelected) throws InterruptedException {

        screen = new BattleFieldScreen();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Lutemon currentAttacker = randomLutemon(firstSelection, secondSelection);
                    while (firstSelected.getHealth() > 0 && secondSelected.getHealth() > 0 ) {
                        Lutemon defendingLutemon = getOtherLutemon(currentAttacker, firstSelection, secondSelection);
                        String firstSelectionText = screen.printLutemonBattleScreen(firstSelected);
                        String secondSelectionText = screen.printLutemonBattleScreen(secondSelected);
                        firstSelectionTv.setText(firstSelectionText);
                        secondSelectionTv.setText(secondSelectionText);
                        int damage = calculateDamage(currentAttacker, defendingLutemon);
                        String battleLogText = screen.battleLogScreen(damage, currentAttacker, defendingLutemon);
                        battleLogTv.setText(battleLogText);
                        defendingLutemon.health -= damage;
                        if (defendingLutemon.health <= 0) {
                            Lutemon winner = currentAttacker;
                            Lutemon loser = getOtherLutemon(winner, firstSelection, secondSelection);
                            //remove dead lutemon
                            storage.removeLutemon(loser, getApplicationContext());
                            winner.setHealth(winner.getMaxHealth());
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    if (loser.equals(firstSelected)) {
                                        firstSelectionTv.setText("\n\n\n\n\n\n\t\tVOITTAJA");
                                    } else {
                                        secondSelectionTv.setText("\n\n\n\n\n\n\t\tVOITTAJA");
                                    }

                                    new Handler().postDelayed(new Runnable() {
                                        //Change to the HomePageActivity after delay
                                        @Override
                                        public void run() {
                                            if (winner.equals(firstSelected)) {
                                                firstSelectionTv.setText("\n\n\n\n\n\nSiirrytään takaisin kotinäkymään");
                                            } else {
                                                secondSelectionTv.setText("\n\n\n\n\n\nSiirrytään takaisin kotinäkymään");
                                            }
                                            new Handler().postDelayed(new Runnable() {
                                                @Override
                                                public void run() {
                                                    returnToHomePage();
                                                }
                                            }, 2500);
                                        }
                                    }, 2500);
                                }
                            });
                            break;
                        }
                        currentAttacker = defendingLutemon;
                        Thread.sleep(2000);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }).start();
    }
    public static int calculateDamage(Lutemon attacker, Lutemon defender) {
        int baseDamage = attacker.getAttack() + attacker.getExperience() - defender.getDefense();
        // create random factor that gives values form -5 to 5
        int randomFactor = (int) (Math.random() * 10 ) - 5;
        int totalDamage = baseDamage + randomFactor;
        //Only return non-negative values (attack  cannot be negative)
        if (totalDamage < 0) {
            return 0;
        } else {
            return totalDamage;
        }
    }
    public static Lutemon getOtherLutemon(Lutemon reference, Lutemon firstSelection, Lutemon secondSelection) {
        if (reference.equals(firstSelection)) {
            return secondSelection;
        } else {
            return firstSelection;
        }
    }
    public static Lutemon randomLutemon(Lutemon firstSelection, Lutemon secondSelection) {
        double randomNumber = Math.random();
        Lutemon randomlySelectedLutemon;
        if (randomNumber >= 0) {
            randomlySelectedLutemon = firstSelection;
        } else {
            randomlySelectedLutemon = secondSelection;
        }
        return randomlySelectedLutemon;
    }
    private void returnToHomePage(){
        Intent intent = new Intent(this, HomePageActivity.class);
        startActivity(intent);
        finish();
    }

}




