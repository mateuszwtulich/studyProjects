package com.example.swimcw2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.SparseBooleanArray;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class Lista2 extends AppCompatActivity {

    private String[] array = {"Karol", "Maciek", "Kuba", "Radek", "Piotr", "Kewin", "Bartek", "Mateusz", "Paweł", "Karol", "Kamil", "Krzysiek"};
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista2);

        final ListView list2 = findViewById(R.id.ListView2);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_multiple_choice, array);
        list2.setAdapter(adapter);

        list2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                String string = "";
                SparseBooleanArray zaznaczone = list2.getCheckedItemPositions();

                for (int i = 0; i < zaznaczone.size() ; i++) {
                    if(zaznaczone.valueAt(i)){
                        int indeks = zaznaczone.keyAt(i);
                        string += (" " + String.valueOf(indeks+1));
                    }
                }
                Toast.makeText(Lista2.this, "Wybrałeś: " + string, Toast.LENGTH_SHORT).show();
            }
        });
    }

}
