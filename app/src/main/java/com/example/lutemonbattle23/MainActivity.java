package com.example.lutemonbattle23;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context = MainActivity.this;
        Storage.getInstance().loadLutemons(context);
        Intent intent = new Intent(this, HomePageActivity.class);
        startActivity(intent);
    }
}