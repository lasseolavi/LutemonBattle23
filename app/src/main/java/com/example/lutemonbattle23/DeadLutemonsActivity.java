package com.example.lutemonbattle23;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class DeadLutemonsActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private  Storage storage;
    private DeadLutemonListAdapter deadLutemonListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dead_lutemons);

        storage = Storage.getInstance();

        recyclerView = findViewById(R.id.rv_deadLutemons);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        deadLutemonListAdapter = new DeadLutemonListAdapter(this, storage.getDeadLutemons(), recyclerView);
        deadLutemonListAdapter.sortLutemons(storage.getDeadLutemons());
        recyclerView.setAdapter(deadLutemonListAdapter);

    }
}
