package com.example.android.restaurantapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import com.example.android.restaurantapp.Adapter.CustomAdapter;
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
        adapter = new CustomAdapter();
        adapter.setRestaurantModels(Preferences.getRestaurants(this).getRestaurantModelArrayList());
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

    }@OnClick(R.id.btn)
    public void onBtnClick (View view){


    }

}
