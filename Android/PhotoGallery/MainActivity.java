package com.example.swimcw2;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.annotation.MainThread;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private String[] lista = {"Pozycja1", "Pozycja2", "Pozycja3"};
    private String[] p = {"1", "2", "3"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Spinner opcje = (Spinner) findViewById(R.id.spinner1);
        if(opcje != null){
            opcje.setOnItemSelectedListener(this);

            ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, lista);
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

            opcje.setAdapter(adapter);
        }

        SharedPreferences sharedPreferences = getSharedPreferences("dane_apki", MODE_PRIVATE);
        SharedPreferences.Editor spe = sharedPreferences.edit();
        int nru = sharedPreferences.getInt("nr_uruchomienia", 0);
        nru++;
        Toast.makeText(getApplicationContext(), "Uruchomienie nr " + nru, Toast.LENGTH_SHORT).show();
        spe.putInt("nr_uruchomienia", nru);
        spe.commit();
    }

    public void runList1(View view){
        final Intent intencja = new Intent(this, Lista1.class);
        startActivity(intencja);
    }

    public void runList2(View view){
        final Intent intencja = new Intent(this, Lista2.class);
        startActivity(intencja);
    }

    public void runGrid1(View view){
        final Intent intencja = new Intent(this, Grid1.class);
        startActivity(intencja);
    }

    public void runList3(View view){
        final Intent intencja = new Intent(this, Lista3.class);
        startActivity(intencja);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(getApplicationContext(), "Wybrałeś: "+ p[position], Toast.LENGTH_LONG).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
