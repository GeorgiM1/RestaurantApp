package com.example.android.restaurantapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.android.restaurantapp.Adapter.MenuAdapter;
import com.example.android.restaurantapp.Model.Menu;
import com.example.android.restaurantapp.Model.OnMenuClickListener;
import com.example.android.restaurantapp.Model.RestaurantModel;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RestaurntMenuActivity extends AppCompatActivity {
    @BindView(R.id.menu_recycler)
    RecyclerView recyclerView;
    @BindView(R.id.logo_restaurant)
    ImageView logo;
    @BindView(R.id.city_restaurant)
    TextView city;
    @BindView(R.id.likes_restuarant)
    TextView likes;
    @BindView(R.id.rating_restaurant)
    TextView rating;
    RestaurantModel restaurantModel;
    @BindView(R.id.name_restaurant)
    TextView name;
    MenuAdapter menuAdapter;
    Menu menu;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurnt_menu);
        ButterKnife.bind(this);
        restaurantModel = (RestaurantModel) getIntent().getSerializableExtra("RESTAURANT_EXTRA");
        if (getIntent().hasExtra("RESTAURANT_EXTRA")) {
            Picasso.with(this).load(restaurantModel.getLogo()).fit().into(logo);
            city.setText(restaurantModel.getCity());
            likes.setText("123 likes");
            rating.setText(restaurantModel.getRating());
            name.setText(restaurantModel.getName());
            menuAdapter=new MenuAdapter(this, new OnMenuClickListener() {
                @Override
                public void onMenuClickListener(Menu menu) {

                }
            });
            menuAdapter.setMenus(restaurantModel.getMenu());
            recyclerView.setHasFixedSize(true);
            recyclerView.setLayoutManager(new LinearLayoutManager(this));
            recyclerView.setAdapter(menuAdapter);


        }
    }
}
