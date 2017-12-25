package com.example.android.restaurantapp.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.android.restaurantapp.Model.Menu;
import com.example.android.restaurantapp.Model.OnMenuClickListener;
import com.example.android.restaurantapp.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by pc on 12/18/2017.
 */

public class MenuAdapter extends RecyclerView.Adapter<MenuAdapter.ViewHolder1> {
    ArrayList<Menu> menus = new ArrayList<>();

    Context context;
    OnMenuClickListener onMenuClickListener;

    public MenuAdapter(Context _context, OnMenuClickListener _onMenuClickListener) {
        context = _context;
        onMenuClickListener = _onMenuClickListener;

    }

    public void setMenus(ArrayList<Menu> menuArrayList) {
        menus = menuArrayList;
    }


    @Override
    public ViewHolder1 onCreateViewHolder(ViewGroup parent, int viewType) {
        context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.menu_recycler, parent, false);
        ViewHolder1 viewHolder1 = new ViewHolder1(view);
        return viewHolder1;

    }

    @Override
    public void onBindViewHolder(final ViewHolder1 holder, final int position) {
        final Menu menu = menus.get(position);
        holder.foodName.setText(menu.getFoodname());
        holder.price.setText(menu.getPrice());
        Picasso.with(context).load(menu.getLink()).centerCrop().fit().into(holder.img);
        if (menu.isIsveg()) {
            holder.isVeg.setChecked(true);
        } else holder.isVeg.setChecked(false);

        holder.menu_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onMenuClickListener.onMenuClickListener(menu, position);
            }
        });

        holder.menu_layout.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                onMenuClickListener.onLongMenuClickListener(menu, position);
                return false;
            }
        });


    }

    @Override
    public int getItemCount() {
        if (menus == null) {
            return 0;
        }
        return menus.size();
    }

    public class ViewHolder1 extends RecyclerView.ViewHolder {
        @BindView(R.id.vegan)
        CheckBox isVeg;
        @BindView(R.id.foodImage)
        ImageView img;
        @BindView(R.id.food_name)
        TextView foodName;
        @BindView(R.id.price)
        TextView price;
        @BindView(R.id.menu_layout_layout)
        RelativeLayout menu_layout;

        public ViewHolder1(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}

