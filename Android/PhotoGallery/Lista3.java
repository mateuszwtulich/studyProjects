package com.example.swimcw2;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class Lista3 extends AppCompatActivity {

    private String[] ltxt1 = {"Pozycja1", "Pozycja2", "Pozycja3", "Pozycja4", "Pozycja5", "Pozycja6", "Pozycja7", "Pozycja8", "Pozycja9", "Pozycja10"};
    private String[] ltxt2 = {"Tekst 1", "Tekst 2", "Tekst 3", "Tekst 4", "Tekst 5", "Tekst 6", "Tekst 7", "Tekst 8", "Tekst 9", "Tekst 10"};
    public Integer[] id_obrazkow = {
            R.drawable.img1, R.drawable.img2, R.drawable.img3,
            R.drawable.img5, R.drawable.img6, R.drawable.img7,
            R.drawable.img3, R.drawable.img2, R.drawable.img1,
            R.drawable.img7, R.drawable.img6, R.drawable.img5,
            R.drawable.img8, R.drawable.img3, R.drawable.img5};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista3);

        myAdapter2 adapter = new myAdapter2(ltxt1);
        ListView lista3 = (ListView) findViewById(R.id.ListView3);
        lista3.setAdapter(adapter);

    }

    public class myAdapter2 extends BaseAdapter {

        private class LVitem{
            //TextView tv1;
          //  TextView tv2;
            ImageView img;
          //  CheckBox cBox;
        }

        private LayoutInflater inflater = null;
        boolean[] zazn_pozycje;
        LVitem myLVitem;

        myAdapter2(String[] lista){
            super();
            zazn_pozycje = new boolean[ltxt1.length];
            inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }

        @Override
        public int getCount() {
            return ltxt1.length;
        }

        @Override
        public Object getItem(int position) {
            return position;
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(final int position, View convertView, ViewGroup parent) {
            if(convertView == null){
                convertView = inflater.inflate(R.layout.list_row,null);
                myLVitem = new LVitem();
                //myLVitem.tv1 = (TextView) convertView.findViewById(R.id.row_tv1);
              // myLVitem.tv2 = (TextView) convertView.findViewById(R.id.row_tv2);
                myLVitem.img = (ImageView) convertView.findViewById(id_obrazkow[position]);
              //  myLVitem.cBox = (CheckBox) convertView.findViewById(R.id.lrow_checkBox);
                convertView.setTag(myLVitem);
            }else
                myLVitem = (LVitem) convertView.getTag();

           /* myLVitem.tv1.setText(ltxt1[position]);
            //myLVitem.tv2.setText(ltxt2[position]);
            myLVitem.cBox.setChecked(zazn_pozycje[position]);
            myLVitem.cBox.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(((CheckBox)v).isChecked())
                        zazn_pozycje[position]=true;
                    else
                        zazn_pozycje[position]=false;

                    Toast.makeText(getApplicationContext(), "Zaznaczyłeś/odznaczyłeś: "+ (position+1), Toast.LENGTH_SHORT).show();
                }
            });*/
            return convertView;
        }
    }

}
