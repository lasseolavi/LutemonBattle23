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
    private int id;
    private LutemonListAdapter lutemonListAdapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_lutemon);
        id = Storage.getInstance().getSavedId();

        context = this;

    }

    public void addLutemon(View view) {
        colorRG = findViewById(R.id.radioGroup);
        nameEditText = findViewById(R.id.editTextName);

        String name = nameEditText.getText().toString();


        GreenLutemon lutemon = null;
        switch (colorRG.getCheckedRadioButtonId()) {
            case R.id.whiteButton:

                WhiteLutemon whiteLutemon = new WhiteLutemon(name, id++);
                Storage.getInstance().addLutemon(whiteLutemon, context);
                break;

            case R.id.greenButton:

                GreenLutemon greenLutemon = new GreenLutemon(name, id++);
                Storage.getInstance().addLutemon(greenLutemon, context);
                break;

            case R.id.pinkButton:

                PinkLutemon pinkLutemon = new PinkLutemon(name, id++);
                Storage.getInstance().addLutemon(pinkLutemon, context);
                break;

            case R.id.orangeButton:

                OrangeLutemon orangeLutemon = new OrangeLutemon(name, id++);
                Storage.getInstance().addLutemon(orangeLutemon, context);
                break;

            case R.id.blackButton:
                BlackLutemon blackLutemon = new BlackLutemon(name, id++);
                Storage.getInstance().addLutemon(blackLutemon, context);
                break;
        }

        lutemonListAdapter = new LutemonListAdapter(this, Storage.getInstance().listLutemons());
        lutemonListAdapter.notifyDataSetChanged();
    }

}
