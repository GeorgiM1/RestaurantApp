package com.example.android.restaurantapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.android.restaurantapp.Model.RestaurantModel;
import com.example.android.restaurantapp.Model.Restaurants;
import com.example.android.restaurantapp.PreferencesManager.Preferences;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class Main2Activity extends AppCompatActivity {
    @BindView(R.id.ime)
    EditText ime;
    @BindView(R.id.grad)
    EditText grad;
    @BindView(R.id.rating)
    EditText rating;
    @BindView(R.id.addBtn)
    Button add;

    Restaurants restaurants;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        ButterKnife.bind(this);
      restaurants =  Preferences.getRestaurants(this);

    }
    @OnClick(R.id.addBtn)
    public void onAddClick (View view){
      RestaurantModel restaurantModel = new RestaurantModel();
      restaurantModel.setName(ime.getText().toString());
      restaurantModel.setCity(grad.getText().toString());
      restaurantModel.setRating(rating.getText().toString());
        restaurants.getRestaurantModelArrayList().add(restaurantModel);
        Preferences.addRestaurants(restaurants,this);
        setResult(RESULT_OK, new Intent());
        finish();


    }
}
