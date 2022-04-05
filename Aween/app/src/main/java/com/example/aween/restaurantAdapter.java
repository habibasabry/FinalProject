package com.example.aween;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class restaurantAdapter extends ArrayAdapter<restaurantsList> {

    List<restaurantsList> listRestaurant;

    public restaurantAdapter(@NonNull Context context, int resource, @NonNull List<restaurantsList> objects) {
        super(context, resource, objects);

        listRestaurant = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        //to show design

        View view = LayoutInflater.from(getContext()).inflate(R.layout.restaurants_design, parent, false);



        //to get the info

        restaurantsList currentRestaurants = listRestaurant.get(position);

        TextView restaurantName = view.findViewById(R.id.name);
        ImageView restaurantImg = view.findViewById(R.id.image);

        restaurantName.setText(currentRestaurants.getRestaurantName());
        restaurantImg.setImageResource(currentRestaurants.getRestaurantImg());

        return view;
    }
}
