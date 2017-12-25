package com.example.android.restaurantapp.Model.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.android.restaurantapp.Model.Restaurants;
import com.example.android.restaurantapp.R;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by pc on 12/24/2017.
 */

public class Fragment extends android.support.v4.app.Fragment {
    private Unbinder mUnnbinder;
    @BindView(R.id.pictureFragment)
    ImageView img;
    Restaurants restaurants;

    public static Fragment newInstance(String url) {

        Bundle args = new Bundle();
        args.putString("URL_EXTRA", url);
        Fragment fragment = new Fragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment, null);
        mUnnbinder = ButterKnife.bind(this, view);

String url = getArguments().getString("URL_EXTRA");
        Picasso.with(getActivity()).load(url).centerCrop().fit().into(img);




        return view;

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mUnnbinder.unbind();
    }
}
