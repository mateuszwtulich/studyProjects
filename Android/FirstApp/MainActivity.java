package com.example.swimcw1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void runFirst(View view){
        final Intent intencja1 = new Intent(this, SecondActivity.class);
        Button button = (Button) findViewById(R.id.button1);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intencja1);
            }
        });
        startActivity(intencja1);
    }

    public void runSecond(View view){
        final Intent intencja2 = new Intent(this, ThirdActivity.class);
        startActivity(intencja2);
    }

    public void runThird(View view){
        final Intent intencja3 = new Intent(this, FourthActivity.class);
        startActivity(intencja3);
    }
}
