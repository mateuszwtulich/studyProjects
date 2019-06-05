package com.example.photogallery;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.view.animation.GridLayoutAnimationController;
import android.view.animation.LayoutAnimationController;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.File;
import java.util.ArrayList;


public class GridFragment extends Fragment {

    private ArrayList<String> listOfImg = new ArrayList<>();
    private static boolean run = true;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_grid, container, false);

        listOfImg = getArguments().getStringArrayList("images_paths");

        GridRecyclerView recyclerView = (GridRecyclerView) view.findViewById(R.id.recycler_view1);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(this.getActivity(), 3);
        recyclerView.setLayoutManager(gridLayoutManager);

        if (run) {
            LayoutAnimationController animation = AnimationUtils.loadLayoutAnimation(getContext(), R.anim.grid_layout_animation);
            recyclerView.setLayoutAnimation(animation);
           // run = false;
        }

        CustomAdapter customAdapter = new CustomAdapter(view.getContext(), listOfImg);
        recyclerView.setAdapter(customAdapter);

        return view;
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        menu.clear();
        inflater.inflate(R.menu.grid_fragment_menu, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        Fragment fragment;

        switch (item.getItemId()) {

            case R.id.list:
                Toast.makeText(getContext(), "Chosen: Show as list.", Toast.LENGTH_SHORT).show();
                fragment = new ListFragment();

                Bundle bundle = new Bundle();
                bundle.putStringArrayList("images_paths", listOfImg);
                fragment.setArguments(bundle);

                fragmentTransaction.replace(R.id.container, fragment);
                fragmentTransaction.commit();

                return true;
            case R.id.file_menu:

                Toast.makeText(getActivity(), "Chosen: File menu.", Toast.LENGTH_SHORT).show();

                fragment = new MenuFragment();

                fragmentTransaction.replace(R.id.container, fragment);
                fragmentTransaction.commit();
                return true;

            default:
                break;
        }

        return false;
    }


    public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.ViewHolder> {
        ArrayList<String> images;
        Context context;

        public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
            ImageView image;

            public ViewHolder(View itemView) {
                super(itemView);
                image = (ImageView) itemView.findViewById(R.id.image);
            }

            @Override
            public void onClick(View v) {

            }
        }

        public CustomAdapter(Context context, ArrayList images) {
            this.context = context;
            this.images = images;
        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.grid_row, parent, false);
            ViewHolder vh = new ViewHolder(v);
            return vh;
        }

        @Override
        public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
            File file = new File(images.get(position));
            if (file.exists()) {
                Bitmap bitmap = BitmapFactory.decodeFile(images.get(position));
                holder.image.setImageBitmap(bitmap);
            } else {
                Toast.makeText(getContext(), "One of the images does not now exist! Load folder once again.", Toast.LENGTH_LONG).show();

                getFragmentManager().popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);
                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                Fragment fragment = new MenuFragment();

                fragmentTransaction.replace(R.id.container, fragment);
                fragmentTransaction.commit();
            }

            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                    Fragment fragment = new ParentFragment();

                    Bundle bundle = new Bundle();
                    bundle.putStringArrayList("images_paths", listOfImg);
                    bundle.putString("img", listOfImg.get(position));
                    fragment.setArguments(bundle);

                    fragmentTransaction.replace(R.id.container, fragment);
                    fragmentTransaction.addToBackStack(null).commit();

                }
            });
        }

        @Override
        public int getItemCount() {
            return images.size();
        }
    }
}