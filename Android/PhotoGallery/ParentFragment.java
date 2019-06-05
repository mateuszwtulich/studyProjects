package com.example.photogallery;

import android.app.WallpaperManager;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.github.chrisbanes.photoview.PhotoView;
import com.github.chrisbanes.photoview.PhotoViewAttacher;

import java.io.File;
import java.util.ArrayList;

public class ParentFragment extends Fragment {

    private ArrayList<String> imagesPaths;
    private String path;
    private String currentPath;
    private int currentIndex;
    private MyViewPager viewPager;
    private ImagePagerAdapter adpater;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_parent, container, false);

        imagesPaths = getArguments().getStringArrayList("images_paths");
        path = getArguments().getString("img");

        int index = 0, i = 0;

        for (String s : imagesPaths) {
            if (s.equals(path)) index = i;
            i++;
        }
        currentIndex = index;
        viewPager = view.findViewById(R.id.view_pager);

        adpater = new ImagePagerAdapter(imagesPaths);
        viewPager.setAdapter(adpater);
        viewPager.setCurrentItem(index);
        viewPager.setPageTransformer(true, new ZoomOutPageTransformer());

        viewPager.setOnSwipeOutListener(new MyViewPager.OnSwipeOutListener() {

            public void onSwipeOutAtStart(){
                Toast.makeText(getContext(), "The beginning.", Toast.LENGTH_SHORT).show();
            };
            public void onSwipeOutAtEnd(){
                Toast.makeText(getContext(), "The end", Toast.LENGTH_SHORT).show();
            };
        });

        return view;
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

        File file = new File(imagesPaths.get(currentIndex));
        Bitmap bitmap = BitmapFactory.decodeFile(imagesPaths.get(currentIndex));
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
                bundle.putString("img", currentPath);

                fragment.setArguments(bundle);
                fragmentTransaction.replace(R.id.container, fragment);
                fragmentTransaction.commit();
                return true;

            default:
                break;
        }
        return false;
    }


    private class ImagePagerAdapter extends PagerAdapter{

        private ArrayList<String> imagesPaths;


        public ImagePagerAdapter(ArrayList<String> imagesPaths) {
            this.imagesPaths = imagesPaths;
        }

        public int getCount() {
            return imagesPaths.size();
        }

        @Override
        public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
            return view == o;
        }

        @NonNull
        @Override
        public Object instantiateItem(@NonNull ViewGroup container, int position) {
            PhotoView photoView = new PhotoView(container.getContext());
            Glide.with(getContext()).asBitmap().load(Uri.fromFile(new File(imagesPaths.get(position)))).thumbnail(0.2f).into(photoView);
            photoView.setMaximumScale(5.0f);
            //photoView.setMediumScale(1.0f);
            //photoView.setMinimumZoom(0.2f);
            container.addView(photoView, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
            currentPath = imagesPaths.get(position);
            return photoView;
        }

        @Override
        public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
            container.removeView((View) object);
        }
    }

    public class ZoomOutPageTransformer implements MyViewPager.PageTransformer {
        private static final float MIN_SCALE = 0.85f;
        private static final float MIN_ALPHA = 0.5f;

        public void transformPage(View view, float position) {
            int pageWidth = view.getWidth();
            int pageHeight = view.getHeight();

            if (position < -1) {
                view.setAlpha(0f);

            } else if (position <= 1) {
                float scaleFactor = Math.max(MIN_SCALE, 1 - Math.abs(position));
                float vertMargin = pageHeight * (1 - scaleFactor) / 2;
                float horzMargin = pageWidth * (1 - scaleFactor) / 2;
                if (position < 0) {
                    view.setTranslationX(horzMargin - vertMargin / 2);
                } else {
                    view.setTranslationX(-horzMargin + vertMargin / 2);
                }

                view.setScaleX(scaleFactor);
                view.setScaleY(scaleFactor);

                view.setAlpha(MIN_ALPHA +
                        (scaleFactor - MIN_SCALE) /
                                (1 - MIN_SCALE) * (1 - MIN_ALPHA));

            } else {
                view.setAlpha(0f);
            }
        }
    }

}





