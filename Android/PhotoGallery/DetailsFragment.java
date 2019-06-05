package com.example.photogallery;

import android.media.ExifInterface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;

public class DetailsFragment extends Fragment {

    private Button button1, button2;
    private TextView text;
    private String path;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_details, container, false);

        path = getArguments().getString("img");
        text = view.findViewById(R.id.textView3);
        text.setText(createInfo());

        button1 = view.findViewById(R.id.Info);
        button2 = view.findViewById(R.id.Exif);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text.setText(createInfo());
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text.setText(createExif());
            }
        });

        return view;
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        menu.clear();
        super.onCreateOptionsMenu(menu, inflater);
    }

    private void emptyFile(){
        Toast.makeText(getContext(), "Image does not now exist! Load folder once again.", Toast.LENGTH_LONG).show();

        getFragmentManager().popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);
        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        Fragment fragment = new MenuFragment();

        fragmentTransaction.replace(R.id.container, fragment);
        fragmentTransaction.commit();
    }

    private String createInfo() {
        ExifInterface exifInterface = null;
        String result = "INFO\n";
        try {
            exifInterface = new ExifInterface(path);
            result += "Path: " + path;
            result += "\nDescrption: " +  exifInterface.getAttribute(ExifInterface.TAG_IMAGE_DESCRIPTION);
        } catch (IOException e) {
            e.printStackTrace();
        }
        if("INFO\n"== result){
            emptyFile();
        }
        return result;
    }

    private String createExif() {
        ExifInterface exifInterface = null;
        String metadata = "EXIF\n";
        try {
            exifInterface = new ExifInterface(path);
            metadata +=  "Date: " + exifInterface.getAttribute(ExifInterface.TAG_DATETIME_DIGITIZED) + "\n";
            metadata += "Artist: " + exifInterface.getAttribute(ExifInterface.TAG_ARTIST) + "\n";
            metadata += "Location: " + exifInterface.getAttribute(ExifInterface.TAG_SUBJECT_LOCATION) + "\n";
            metadata += "Format: " + exifInterface.getAttribute(ExifInterface.TAG_JPEG_INTERCHANGE_FORMAT) + "\n";
            metadata += "Lenght: " + exifInterface.getAttribute(ExifInterface.TAG_IMAGE_LENGTH) + "\n";
            metadata += "Width: " + exifInterface.getAttribute(ExifInterface.TAG_IMAGE_WIDTH) + "\n";
        } catch (IOException e) {
            e.printStackTrace();
        }
        if("EXIF\n"== metadata){
            emptyFile();
        }
        return metadata;
    }
}
