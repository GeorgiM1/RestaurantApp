package com.example.android.restaurantapp.Adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.android.restaurantapp.Model.Menu;

import java.util.ArrayList;

/**
 * Created by pc on 12/24/2017.
 */

public class FragmentAdapter extends FragmentPagerAdapter {
    ArrayList<Menu> menus = new ArrayList<>();

    public void addMenus (ArrayList<Menu> _menus){
        menus=_menus;
    }

    public FragmentAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {

        return com.example.android.restaurantapp.Model.Fragments.Fragment.newInstance(menus.get(position).getLink());


    }

    @Override
    public int getCount() {
        if (menus.size()==0){
            return 0;
        }
        return menus.size();
    }
}
