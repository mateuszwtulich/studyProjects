package com.example.swimcw1;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class FourthActivity extends Activity {

    ArrayList<CheckBox> list = new ArrayList(2);
    private TextView textView;
    private CheckBox checkBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fourth);

        textView = findViewById(R.id.textView7);
    }

    public void runBack(View view){ onBackPressed(); }

    protected void onStop(){
        super.onStop();
        Toast.makeText(getApplicationContext(), "SimpleCalculator - Stopped", Toast.LENGTH_SHORT).show();
    }

    public void check(View view) {

        int id = view.getId();
        checkBox = findViewById(id);

        if(checkBox.isChecked()) list.add(checkBox);
        else list.remove(checkBox);
    }

    public void sumUp(View view){
        if(list.size() == 2){
            textView.setText("= " + Integer.toString(Integer.parseInt((String)list.get(0).getText())+ Integer.parseInt((String)list.get(1).getText())));
        }else
        textView.setText("There must be two values checked!");
    }

    public void multiply(View view){
        if(list.size() == 2){
            textView.setText("= " + Integer.toString(Integer.parseInt((String)list.get(0).getText())* Integer.parseInt((String)list.get(1).getText())));
        }else
            textView.setText("There must be two values checked!");
    }
}




