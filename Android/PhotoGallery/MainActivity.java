package com.example.photogallery;

import android.Manifest;
import android.content.SharedPreferences;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import java.io.File;
import java.util.ArrayList;

import pub.devrel.easypermissions.EasyPermissions;

public class MainActivity extends AppCompatActivity {

    private String[] galleryPermissions = {Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE};
    private ArrayList<String> listOfImg = new ArrayList<String>();

    private Fragment fragment;
    private String path = "/sdcard/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SharedPreferences sharedPreferences = getSharedPreferences("Dane", MODE_PRIVATE);
        final SharedPreferences.Editor spe = sharedPreferences.edit();

        String pathToFile = sharedPreferences.getString("folder", null);
        

        if(pathToFile!= null) {

            if (EasyPermissions.hasPermissions(MainActivity.this, galleryPermissions)) {
                String[] listOfFiles = (new File(pathToFile)).list();

                if (listOfImg.size() != 0) {
                    listOfImg.clear();
                }

                for (String s : listOfFiles) {
                    if (getFileExtension(s).equals("jpg")) {
                        listOfImg.add(pathToFile + "/" + s);
                    }
                }
            } else {
                EasyPermissions.requestPermissions(this, "Access for storage",
                        101, galleryPermissions);
            }
        }

        if(listOfImg.size() != 0){
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragment = new GridFragment();

            Bundle bundle = new Bundle();
            bundle.putStringArrayList("images_paths", listOfImg);
            fragment.setArguments(bundle);

            fragmentTransaction.replace(R.id.container, fragment);
            fragmentTransaction.commit();

            Toast.makeText(this, pathToFile, Toast.LENGTH_SHORT).show();
        }else{
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragment = new MenuFragment();

            fragmentTransaction.add(R.id.container, fragment);
            fragmentTransaction.commit();

           // listOfImg = ((MenuFragment)fragment).getImagesPaths();
        }
    }

    public static String getFileExtension(String fullName) {
        int dotIndex = fullName.lastIndexOf('.');
        return (dotIndex == -1) ? "" : fullName.substring(dotIndex + 1);
    }
}
