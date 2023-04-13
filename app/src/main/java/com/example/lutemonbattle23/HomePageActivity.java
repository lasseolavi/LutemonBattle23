package com.example.lutemonbattle23;

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
        recyclerView.setAdapter(new LutemonListAdapter(getApplicationContext(), storage.listLutemons()));

    }
    public void switchToNewLutemon(View view) {
        Intent intent = new Intent(this, NewLutemonActivity.class);
        startActivity(intent);
    }
    protected void onResume(View view) {
        super.onResume();
        lutemonListAdapter.notifyDataSetChanged();
    }
}
