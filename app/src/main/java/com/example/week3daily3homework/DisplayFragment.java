package com.example.week3daily3homework;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;


/**
 * A simple {@link Fragment} subclass.
 */
public class DisplayFragment extends Fragment {
    ImageView tvFragImage;

    public DisplayFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_display, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        tvFragImage = view.findViewById(R.id.tvFragImg);
    }

    public void setDisplay(String string) {
        if(tvFragImage != null) {
            Glide.with(this.getContext()).load(string).into(tvFragImage);
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }
}
