package com.example.lutemonbattle23;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class BattleFieldActivity extends AppCompatActivity implements StartBattleListener {

    private RecyclerView recyclerView;
    private TextView battleText;
    private LutemonBattleFieldListAdapter lutemonBattleFieldListAdapter;
    private Storage storage;
    private Button startBattleButton;
    private int count;
    private Lutemon firstSelection;
    private Lutemon secondSelection;
    private StartBattleListener mListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_battle_field);

        storage = Storage.getInstance();

        recyclerView = findViewById(R.id.rvBattleLutemons);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new LutemonBattleFieldListAdapter(storage.listLutemons()));
        lutemonBattleFieldListAdapter = new LutemonBattleFieldListAdapter(storage.listLutemons());

        startBattleButton = findViewById(R.id.startBattleButton);



    }


    @Override
    public void StartBattle(Lutemon firstSelected, Lutemon secondSelected) {
        System.out.println("Taistelu alkaa");
    }
}
