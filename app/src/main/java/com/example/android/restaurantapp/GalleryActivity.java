package com.example.android.restaurantapp;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.example.android.restaurantapp.Adapter.FragmentAdapter;
import com.example.android.restaurantapp.Model.Menu;
import com.example.android.restaurantapp.Model.RestaurantModel;

import butterknife.BindView;
import butterknife.ButterKnife;

public class GalleryActivity extends AppCompatActivity {
    @BindView(R.id.pager)
    ViewPager pager;
    FragmentAdapter adapter;
    Menu menu;
    RestaurantModel restaurantModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery);
        ButterKnife.bind(this);
        adapter = new FragmentAdapter(getSupportFragmentManager());
        restaurantModel = (RestaurantModel) getIntent().getSerializableExtra("RESTAURANT_EXTRA");


        adapter.addMenus(restaurantModel.getMenu());

        pager.setAdapter(adapter);
    }
}
