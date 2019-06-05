package com.example.photogallery;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.util.ArrayList;

import pub.devrel.easypermissions.EasyPermissions;

import static android.content.Context.MODE_PRIVATE;

public class MenuFragment extends Fragment {

    private String filePath;
    private String path = "/sdcard/";

    private ArrayList<String> imagesPaths = new ArrayList<String>();
    private ArrayList<String> folders = new ArrayList<String>();
    private String[] galleryPermissions = {Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE};

    @SuppressLint("ResourceType")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_menu, container, false);
        find_folders_paths((new File(path)).listFiles());

        MyAdapter adapter = new MyAdapter(folders);
        ListView listView = view.findViewById(R.id.imageList);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                SharedPreferences sharedPreferences = getActivity().getSharedPreferences("Dane", MODE_PRIVATE);
                final SharedPreferences.Editor spe = sharedPreferences.edit();
                spe.putString("folder", folders.get(position));
                spe.commit();

                filePath = folders.get(position);
                get_permission(filePath);


                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                Fragment fragment;

                if(imagesPaths.size()!=0) {
                    fragment = new GridFragment();

                    Bundle bundle = new Bundle();
                    bundle.putStringArrayList("images_paths", imagesPaths);
                    fragment.setArguments(bundle);

                    fragmentTransaction.replace(R.id.container, fragment);
                    fragmentTransaction.commit();

                    Toast.makeText(getContext(), filePath, Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(getContext(), "This file is now empty! Folders were reloaded.", Toast.LENGTH_SHORT).show();
                    fragment = new MenuFragment();

                    fragmentTransaction.add(R.id.container, fragment);
                    fragmentTransaction.commit();
                }

            }
        });
        return view;
    }

    private void find_folders_paths(File[]files) {

        for(File file: files){
            if (file.isFile()) {
                if (file.getName().toLowerCase().endsWith("jpg")) {
                    if(!folders.contains(file.getParent()))
                        folders.add(file.getParent());
                }
            } else if (file.isDirectory()){
                find_folders_paths(file.listFiles());
            }
        }
    }

    private void get_permission(String path){
        if (EasyPermissions.hasPermissions(getContext(), galleryPermissions)) {
            pick_image(path);
        } else {
            EasyPermissions.requestPermissions(this, "Access for storage",
                    101, galleryPermissions);
        }
    }

    private void pick_image(String path) {
        File file = new File(path);
        String[] listOfFiles = file.list();

        if(imagesPaths.size() != 0) {
            imagesPaths.clear();
        }

        for (String s: listOfFiles){
            if(MainActivity.getFileExtension(s).equals("jpg")){
                imagesPaths.add(path + "/" + s);
            }
        }
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        menu.clear();
        super.onCreateOptionsMenu(menu, inflater);
    }

    public ArrayList<String> getImagesPaths() {
        return imagesPaths;
    }

    public class MyAdapter extends BaseAdapter {

        private class Item{
            protected ImageView imageView;
            protected TextView textView;
        }

        private LayoutInflater inflater = null;
        private  Item item;
        private String[] foldersPaths = new String[folders.size()];

        MyAdapter(ArrayList<String> foldersPaths){
            super();

            int i = 0;
            for (String s: foldersPaths) {
                this.foldersPaths[i] = s;
                i++;
            }
            item = new Item();
            inflater = (LayoutInflater) getActivity().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }

        @Override
        public int getCount() {
            return foldersPaths.length;
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
                convertView = inflater.inflate(R.layout.menu_list_row,null);
                item.imageView = convertView.findViewById(R.id.imageList);
                item.textView = convertView.findViewById(R.id.textList);

                convertView.setTag(item);
            }else
                item = (Item) convertView.getTag();
            item.textView.setText(foldersPaths[position]);

            return convertView;
        }
    }
}

