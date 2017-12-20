package com.example.android.restaurantapp.Model;

import java.util.ArrayList;

/**
 * Created by pc on 12/18/2017.
 */

public class Restaurants {
    ArrayList<RestaurantModel> restaurants;

    public ArrayList<RestaurantModel> getRestaurantModelArrayList() {
        return restaurants;
    }

    public void setRestaurantModelArrayList(ArrayList<RestaurantModel> restaurantModelArrayList) {
        this.restaurants = restaurantModelArrayList;
    }
}
