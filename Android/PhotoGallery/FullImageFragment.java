package com.example.photogallery;

import android.annotation.SuppressLint;
import android.app.WallpaperManager;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.File;
import java.util.ArrayList;

public class FullImageFragment extends Fragment {

    private ImageView fullImage;
    private MyImageView myImageView;
    private ScaleGestureDetector mScaleGestureDetector;
    private float mScaleFactor = 1.0f;
    private final static float minZoom =  0.1f;
    private final static float maxZoom = 10.0f;
//    private final static int NONE = 0;
//    private final static int PAN = 1;
//    private final static int ZOOM = 2;
//    private int eventState;
//    private float startX = 0;
//    private float startY = 0;
//    private float moveX = 0;
//    private float moveY = 0;

    private String dataImage;
    private Bitmap bitmap;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_full_image, container, false);

        fullImage = (ImageView) view.findViewById(R.id.full_image);
        dataImage = getArguments().getString("img");

        File file = new File(dataImage);
        if (file.exists()){
//            bitmap = BitmapFactory.decodeFile(dataImage);
//            fullImage.setImageBitmap(bitmap);
            mScaleGestureDetector = new ScaleGestureDetector(getContext(), new ScaleListener());
            bitmap = BitmapFactory.decodeFile(dataImage);
            fullImage.setImageBitmap(bitmap);
//            myImageView.setmBitmap(bitmap);
        }else {
            Toast.makeText(getContext(), "Image does not now exist! Load folder once again.", Toast.LENGTH_LONG).show();

            getFragmentManager().popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);
            FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
            Fragment fragment = new MenuFragment();

            fragmentTransaction.replace(R.id.container, fragment);
            fragmentTransaction.commit();
        }

        view.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                mScaleGestureDetector.onTouchEvent(event);
                return true;
            }
        });
//
//        view.setOnTouchListener(new View.OnTouchListener() {
//            public boolean onTouch(View v, MotionEvent event) {
//                switch(event.getAction() & MotionEvent.ACTION_MASK){
//                    case MotionEvent.ACTION_DOWN:
//                        eventState = PAN;
//                        startX = event.getX();
//                        startY = event.getY();
//                        break;
//                    case MotionEvent.ACTION_UP:
//                        eventState = NONE;
//                        break;
//                    case MotionEvent.ACTION_MOVE:
//                        eventState = PAN;
//                        moveX = event.getX() - startX;
//                        moveY = event.getY() - startY;
//                        break;
//                    case MotionEvent.ACTION_POINTER_DOWN:
//                        eventState = ZOOM;
//
//                        break;
//                }
//                mScaleGestureDetector.onTouchEvent(event);
//                if(eventState == PAN && mScaleFactor != minZoom || eventState == ZOOM) {
//                    getView().invalidate();
//                    getView().requestLayout();
//                }
//                return true;
//            }
//        });

        return view;
    }

    private class ScaleListener extends ScaleGestureDetector.SimpleOnScaleGestureListener {
        @Override
        public boolean onScale(ScaleGestureDetector scaleGestureDetector){
            mScaleFactor *= scaleGestureDetector.getScaleFactor();
            mScaleFactor = Math.max(0.1f,
                    Math.min(mScaleFactor, 10.0f));
            fullImage.setScaleX(mScaleFactor);
            fullImage.setScaleY(mScaleFactor);
//            fullImage.setTranslationY(moveX/mScaleFactor);
//            fullImage.setTranslationY(moveY/mScaleFactor);
            return true;
        }
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        menu.clear();
        inflater.inflate(R.menu.full_image_menu, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        File file = new File(dataImage);
//        if (!file.exists()){
//            Toast.makeText(getContext(), "Image does not now exist! Load folder once again.", Toast.LENGTH_LONG).show();
//
//            getFragmentManager().popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);
//            FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
//            Fragment fragment = new MenuFragment();
//
//            fragmentTransaction.replace(R.id.container, fragment);
//            fragmentTransaction.commit();
//        }else

        switch (item.getItemId()) {

            case R.id.share:

                Uri U = Uri.fromFile(file);
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("image/jpg");
                intent.putExtra(Intent.EXTRA_STREAM, U);
                startActivity(Intent.createChooser(intent, "Email:"));

                return true;

            case R.id.wallpaper:
                WallpaperManager myWallpaperManager
                        = WallpaperManager.getInstance(getActivity().getApplicationContext());
                try {
                    myWallpaperManager.setBitmap(bitmap);
                    Toast.makeText(getActivity().getApplicationContext(), "The wallpaper was successfully set.", Toast.LENGTH_SHORT).show();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return true;

            case R.id.details:
                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();

                Fragment fragment = new DetailsFragment();
                Bundle bundle = new Bundle();
                bundle.putString("img", dataImage);

                fragment.setArguments(bundle);
                fragmentTransaction.replace(R.id.container, fragment);
                fragmentTransaction.commit();
                return true;

            default:
                break;
        }
        return false;
    }
}
