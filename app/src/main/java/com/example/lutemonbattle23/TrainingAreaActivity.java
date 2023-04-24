package com.example.lutemonbattle23;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class TrainingAreaActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private Storage storage;
    private TrainingAreaListAdapter trainingAreaListAdapter;
    private Button startTrainingButton;
    private ArrayList<Lutemon> selectedLutemons;
    private TextView textViewTraining;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_training_area);

        storage = Storage.getInstance();

        recyclerView = findViewById(R.id.rvTrainLutemonList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        trainingAreaListAdapter = new TrainingAreaListAdapter(storage.listLutemons());
        recyclerView.setAdapter(trainingAreaListAdapter);

        startTrainingButton = findViewById(R.id.startTrainingButton);
        textViewTraining = findViewById(R.id.textViewTraining);

        startTrainingButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectedLutemons = trainingAreaListAdapter.getSelectedLutemons();
                if (selectedLutemons.size() == 1) {
                    StartTraining(selectedLutemons.get(0));

                    textViewTraining.setVisibility(View.INVISIBLE);

                    new android.os.Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            textViewTraining.setVisibility(View.VISIBLE);
                        }
                    }, 100);
                    textViewTraining.setText(selectedLutemons.get(0).getName() + " treenaa ahkerasti!\n+1 kokemuspiste!");

                } else if (selectedLutemons.size()> 1) {
                    textViewTraining.setText("");
                    Toast.makeText(TrainingAreaActivity.this, "Liian monta lutemonia valittu\nValitse 1", Toast.LENGTH_SHORT).show();
                } else if(selectedLutemons.size() == 0){
                    textViewTraining.setText("");
                    Toast.makeText(TrainingAreaActivity.this, "valitse 1 lutemon", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public void StartTraining(Lutemon selectedLutemon) {
        Lutemon.setExperience(selectedLutemon);
    }

}
