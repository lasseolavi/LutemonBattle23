package com.example.lutemonbattle23;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class HomePageActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private  Storage storage;
    private LutemonListAdapter lutemonListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        storage = Storage.getInstance();

        recyclerView = findViewById(R.id.rvLutemonList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        lutemonListAdapter = new LutemonListAdapter(this, storage.listLutemons());
        lutemonListAdapter.sortLutemons(storage.listLutemons());
        recyclerView.setAdapter(lutemonListAdapter);

    }
    public void switchToNewLutemon(View view) {
        Intent intent = new Intent(this, NewLutemonActivity.class);
        startActivity(intent);
    }
    public void switchToBattleField(View view) {
        Intent intent= new Intent(this, BattleFieldActivity.class);
        startActivity(intent);
    }
    public void switchToTrainingArea(View view) {
        Intent intent = new Intent(this, TrainingAreaActivity.class);
        startActivity(intent);
    }
    protected void onResume() {
        super.onResume();
        lutemonListAdapter.sortLutemons(Storage.getInstance().listLutemons());
    }
    public void switchToInformation(View view){

    }
}
