package com.example.swimcw2;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.GridLayout;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListView;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;

public class Grid1 extends AppCompatActivity {

    public Integer[] id_obrazkow = {
            R.drawable.img1, R.drawable.img2, R.drawable.img3,
            R.drawable.img5, R.drawable.img6, R.drawable.img7,
            R.drawable.img3, R.drawable.img2, R.drawable.img1,
            R.drawable.img7, R.drawable.img6, R.drawable.img5,
            R.drawable.img8, R.drawable.img3, R.drawable.img5};

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid1);

        GridView grid1 = (GridView) findViewById(R.id.GridView1);
        grid1.setAdapter(new myAdapter(Grid1.this));

        grid1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(Grid1.this, FullImageActivity.class);
                intent.putExtra("img", id_obrazkow[position]);

                startActivity(intent);
            }
        });
    }

    public class myAdapter extends BaseAdapter{
        private Context ctx;

        public myAdapter(Context c ){
            ctx = c;
        }

        @Override
        public int getCount() {
            return id_obrazkow.length;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ImageView mV;

            if(convertView == null){
                mV = new ImageView(ctx);
                mV.setLayoutParams(new GridView.LayoutParams(400,400));
                mV.setScaleType(ImageView.ScaleType.CENTER_CROP);
                mV.setPadding(4,4,4,4);
            }
            else mV = (ImageView) convertView;
            mV.setImageResource(id_obrazkow[position]);
            return mV;
        }
    }
}
