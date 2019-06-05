package com.example.photogallery;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.File;
import java.util.ArrayList;

public class ListFragment extends Fragment {

    private ArrayList<String> listOfImg;
    private static boolean run = true;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_list, container, false);

        listOfImg = getArguments().getStringArrayList("images_paths");

        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recycler_view2);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this.getActivity());
        recyclerView.setLayoutManager(layoutManager);

        if(run) {
            LayoutAnimationController animation = AnimationUtils.loadLayoutAnimation(getContext(), R.anim.list_layout_animation);
            recyclerView.setLayoutAnimation(animation);
           // run = false;
        }

        MyAdapter customAdapter = new MyAdapter(view.getContext(), listOfImg);
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
        inflater.inflate(R.menu.list_fragment_menu, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        Fragment fragment;

        switch (item.getItemId()) {

            case R.id.grid:
                Toast.makeText(getContext(), "Chosen: Show as grid.", Toast.LENGTH_SHORT).show();
                fragment = new GridFragment();

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


    public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
        private ArrayList<String> listOfImg;
        private Context context;


        public class MyViewHolder extends RecyclerView.ViewHolder {

            ImageView imageView;

            public MyViewHolder(View itemView) {
                super(itemView);
                imageView = (ImageView) itemView.findViewById(R.id.image);
            }
        }

        public MyAdapter(Context context, ArrayList<String> arrayList) {
            listOfImg = arrayList;
            this.context = context;
        }

        @Override
        public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_row, parent, false);

            MyViewHolder vh = new MyViewHolder(v);
            return vh;
        }

        @Override
        public void onBindViewHolder(MyViewHolder holder, final int position) {

            File file = new File(listOfImg.get(position));
            if (file.exists()){
                Bitmap bitmap = BitmapFactory.decodeFile(listOfImg.get(position));
                holder.imageView.setImageBitmap(bitmap );
            }else {
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
            return listOfImg.size();
        }
    }
}
