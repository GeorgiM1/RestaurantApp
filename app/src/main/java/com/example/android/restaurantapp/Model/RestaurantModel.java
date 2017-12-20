package com.example.android.restaurantapp.Model;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by pc on 12/18/2017.
 */

public class RestaurantModel implements Serializable{
    String logo;
    String city;
    String name;
    String rating;
    ArrayList<Menu> menu;

    public ArrayList<Menu> getMenu() {
        return menu;
    }

    public void setMenu(ArrayList<Menu> menu) {
        this.menu = menu;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

}
