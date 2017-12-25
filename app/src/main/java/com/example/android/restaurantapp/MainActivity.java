package com.example.android.restaurantapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import com.example.android.restaurantapp.Adapter.CustomAdapter;
import com.example.android.restaurantapp.Model.OnRestaurantRowClickListener;
import com.example.android.restaurantapp.Model.RestaurantModel;
import com.example.android.restaurantapp.Model.Restaurants;
import com.example.android.restaurantapp.PreferencesManager.Preferences;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {
    CustomAdapter adapter;
    @BindView(R.id.recycler)
    RecyclerView recyclerView;
    @BindView(R.id.btn)
    Button btn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        adapter = new CustomAdapter(this, new OnRestaurantRowClickListener() {
            @Override
            public void onRestaurantRowClickListener(RestaurantModel model, int position) {
                Intent intent = new Intent(MainActivity.this, RestaurntMenuActivity.class);
                intent.putExtra("RESTAURANT_EXTRA", model);
                intent.putExtra("POSITION", position);
                startActivityForResult(intent, 1000);
            }
        });

        Restaurants restaurants = Preferences.getRestaurants(this);
        adapter.setRestaurantModels(restaurants.getRestaurantModelArrayList());
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);


    }

    @OnClick(R.id.btn)
    public void onBtnClick(View view) {
        Intent intent = new Intent(this, Main2Activity.class);
        startActivityForResult(intent, 1000);

    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        adapter.setRestaurantModels(Preferences.getRestaurants(this).getRestaurantModelArrayList());

        adapter.notifyDataSetChanged();

    }
}

