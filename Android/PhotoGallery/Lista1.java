package com.example.swimcw2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class Lista1 extends AppCompatActivity{

    private String[] array = {"Karol", "Maciek", "Kuba", "Radek", "Piotr", "Kewin", "Bartek", "Mateusz", "Paweł", "Karol", "Kamil", "Krzysiek"};

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista1);

        ListView list1 = findViewById(R.id.ListView1);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, array);
        list1.setAdapter(adapter);

        list1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(Lista1.this, array[position], Toast.LENGTH_SHORT).show();
            }
        });
    }

}

