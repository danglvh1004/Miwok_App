package com.example.miwok;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView numbers = findViewById(R.id.numbers);
        TextView family = findViewById(R.id.family);
        TextView colors = findViewById(R.id.colors);
        TextView phrases = findViewById(R.id.phrases);

        numbers.setOnClickListener(this);
        family.setOnClickListener(this);
        colors.setOnClickListener(this);
        phrases.setOnClickListener(this);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            displayToast("Choose Setting");
        }
        return super.onOptionsItemSelected(item);
    }

    public void displayToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.numbers:
                Intent numbersIntent = new Intent(this, NumbersActivity.class);
                startActivity(numbersIntent);
                break;
            case R.id.family:
                Intent familyIntent = new Intent(this, FamilyActivity.class);
                startActivity(familyIntent);
                break;
            case R.id.colors:
                Intent colorsIntent = new Intent(this, ColorsActivity.class);
                startActivity(colorsIntent);
                break;
            case R.id.phrases:
                Intent phrasesIntent = new Intent(this, PhrasesActivity.class);
                startActivity(phrasesIntent);
                break;
        }
    }
}