package com.example.android.restaurantapp;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.android.restaurantapp.Adapter.MenuAdapter;
import com.example.android.restaurantapp.Model.Menu;
import com.example.android.restaurantapp.Model.OnMenuClickListener;
import com.example.android.restaurantapp.Model.RestaurantModel;
import com.example.android.restaurantapp.Model.Restaurants;
import com.example.android.restaurantapp.PreferencesManager.Preferences;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

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
    int rest_poistion;
    @BindView(R.id.addBtn)
    Button addBtn;
    @BindView(R.id.gallery)
    Button gallery;
    Restaurants restaurants;


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
            rest_poistion = getIntent().getIntExtra("POSITION", 0);
            menuAdapter = new MenuAdapter(this, new OnMenuClickListener() {
                @Override
                public void onMenuClickListener(Menu menu, int position) {
                    Intent intent = new Intent(RestaurntMenuActivity.this, EditMenuActivity.class);
                    intent.putExtra("MENU", menu);
                    intent.putExtra("USER", restaurantModel);
                    intent.putExtra("restoranposition", rest_poistion);
                    intent.putExtra("menuposition", position);
                    startActivityForResult(intent, 1000);


                }

                @Override
                public void onLongMenuClickListener(Menu menu, final int position) {
                    AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(RestaurntMenuActivity.this);
                    alertDialogBuilder.setMessage("Are you sure you want to delete this item? ");
                    alertDialogBuilder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            restaurantModel.getMenu().remove(position);
                            restaurants = Preferences.getRestaurants(RestaurntMenuActivity.this);
                            restaurants.getRestaurantModelArrayList().get(rest_poistion).getMenu().remove(position);
                            Preferences.addRestaurants(restaurants, RestaurntMenuActivity.this);
                            menuAdapter.notifyDataSetChanged();

                        }
                    });
                    alertDialogBuilder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {

                        }
                    });
                    alertDialogBuilder.create().show();


                }
            });

            menuAdapter.setMenus(restaurantModel.getMenu());
            recyclerView.setHasFixedSize(true);
            recyclerView.setLayoutManager(new LinearLayoutManager(this));
            recyclerView.setAdapter(menuAdapter);


        }

    }

    @OnClick(R.id.addBtn)
    public void onAddClick(View view) {
        Intent intent = new Intent(RestaurntMenuActivity.this, EditMenuActivity.class);
        intent.putExtra("ADD", true);
        intent.putExtra("restoranposition", rest_poistion);
        startActivityForResult(intent, 1002);
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 1000 && resultCode == RESULT_OK) {

            restaurantModel = new RestaurantModel();
            restaurantModel.setMenu(Preferences.getRestaurants(this).getRestaurantModelArrayList().get(rest_poistion).getMenu());
            menuAdapter.setMenus(restaurantModel.getMenu());
            menuAdapter.notifyDataSetChanged();

        }
        if (requestCode == 1002 && resultCode == RESULT_OK) {
            restaurantModel = new RestaurantModel();
            restaurantModel = Preferences.getRestaurants(this).getRestaurantModelArrayList().get(rest_poistion);
            menuAdapter.setMenus(restaurantModel.getMenu());
            menuAdapter.notifyDataSetChanged();


        }
    }

    @OnClick(R.id.gallery)
    public void OnGalleryClick(View view) {
        Intent intent = new Intent(RestaurntMenuActivity.this, GalleryActivity.class);
        intent.putExtra("RESTAURANT_EXTRA", restaurantModel);
        startActivity(intent);
    }

}
