package com.example.android.restaurantapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;

import com.example.android.restaurantapp.Model.Menu;
import com.example.android.restaurantapp.Model.RestaurantModel;
import com.example.android.restaurantapp.Model.Restaurants;
import com.example.android.restaurantapp.PreferencesManager.Preferences;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class EditMenuActivity extends AppCompatActivity {

    @BindView(R.id.food_price)
    EditText price;
    @BindView(R.id.veganBtn)
    RadioButton isVeg;
    @BindView(R.id.notVeganBtn)
    RadioButton nVeg;
    RestaurantModel restaurantModel;
    @BindView(R.id.editBtn)
    Button editBtn;
    Menu menu;
    int menu_posi;
    int res_pos;
    Restaurants restaurants;
    @BindView(R.id.addFood)
    Button addBtn;
    @BindView(R.id.foodNAME)
    EditText foodName;
    @BindView(R.id.IMAGE)
    ImageView foodImage;
    public String imgPath;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_menu);
        ButterKnife.bind(this);
        Intent intent = getIntent();

        restaurants = Preferences.getRestaurants(this);
        res_pos = intent.getIntExtra("restoranposition", 0);

        if (intent.hasExtra("MENU")) {
            restaurantModel = (RestaurantModel) intent.getSerializableExtra("USER");
            menu = (Menu) intent.getSerializableExtra("MENU");
            price.setText(menu.getPrice().toString());
            foodName.setText(menu.getFoodname().toString());
            imgPath = menu.getLink();
            Picasso.with(this).load(imgPath).centerCrop().fit().into(foodImage);
            menu_posi = intent.getIntExtra("menuposition", 0);

            addBtn.setClickable(false);
            if (menu.isIsveg()) {
                isVeg.setChecked(true);
                nVeg.setChecked(false);
            } else {
                isVeg.setChecked(false);
                nVeg.setChecked(true);
            }


        }
        if (intent.hasExtra("ADD")) {
            editBtn.setClickable(false);
            Picasso.with(this).load(R.mipmap.ic_launcher).centerCrop().fit().into(foodImage);
        }


    }

    @OnClick(R.id.editBtn)
    public void onEditClik(View view) {
        menu.setPrice(price.getText().toString());
        if (isVeg.isChecked()) {
            menu.setIsveg(true);
        } else menu.setIsveg(false);
        menu.setFoodname(foodName.getText().toString());
        menu.setLink(imgPath);


        restaurants.getRestaurantModelArrayList().get(res_pos).getMenu().set(menu_posi, menu);
        Preferences.addRestaurants(restaurants, this);


        Intent newIntent = new Intent(EditMenuActivity.this, RestaurntMenuActivity.class);

        setResult(RESULT_OK, newIntent);
        finish();


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 1003) {
            imgPath = data.getData().toString();
            Picasso.with(this).load(imgPath).centerCrop().fit().into(foodImage);
        }
    }

    @OnClick(R.id.addFood)
    public void onAddClick(View view) {
        menu = new Menu();
        menu.setPrice(price.getText().toString());
        if (isVeg.isChecked()) {
            menu.setIsveg(true);
        } else menu.setIsveg(false);
        menu.setFoodname(foodName.getText().toString());
        menu.setLink(imgPath);

        restaurants.getRestaurantModelArrayList().get(res_pos).getMenu().add(menu);
        Preferences.addRestaurants(restaurants, this);


        setResult(RESULT_OK, new Intent(EditMenuActivity.this, RestaurntMenuActivity.class));
        finish();


    }

    @OnClick(R.id.IMAGE)
    public void OnImageClick(View view) {
//        Intent intent = new Intent();
//        intent.setType("image/*");
//        intent.setAction(Intent.ACTION_GET_CONTENT);
        Intent i = new Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(i, 1003);
    }


}
