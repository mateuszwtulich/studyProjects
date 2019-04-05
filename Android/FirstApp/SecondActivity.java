package com.example.swimcw1;

import android.app.Activity;
import android.graphics.Matrix;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

public class SecondActivity extends Activity {

    private String toast = "No path selected";
    private String actuallBut, previousBut = "OFF";
    private TextView textView;
    private ToggleButton toggleButton;
    private ImageView imageView;
    private int angle = 20;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        textView = findViewById(R.id.textView);
        toggleButton = findViewById(R.id.toggleButton);
        imageView = findViewById(R.id.imageView);

        View mojeOkno2 = (View) findViewById(R.id.mojeOkno2);
        mojeOkno2.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                finish();
                return false;
            }
        });
    }

    private void create_toast(String toDisplay){
        Toast.makeText(getApplicationContext(), toDisplay, Toast.LENGTH_SHORT).show();
    }

    public void runBack(View view){
        onBackPressed();
    }


    protected void onStop(){
        super.onStop();
        create_toast("MediaPlayer - Stopped");
    }

    public void runToggle(View view) {
        actuallBut = (String)toggleButton.getText();
        textView.setText("Playing: " + previousBut);
        previousBut = actuallBut;

        imageView.setRotationY(angle);
        imageView.setRotationX(angle);
        angle+=20;
}

    public void firstRadio(View view) { toast = "Celine Dion - My heart will go on."; }

    public void secondRadio(View view) { toast = "Andrea Bocelli - Time to say goodbye."; }

    public void thirdRadio(View view) { toast = "Sławomir - Miłość w Zakopanem"; }

    public void playButton(View view){
        create_toast(toast);
}

}
