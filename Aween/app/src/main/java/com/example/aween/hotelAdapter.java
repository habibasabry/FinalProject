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

public class hotelAdapter extends ArrayAdapter<hotelsList> {

    List<hotelsList> listHotel;

    public hotelAdapter(@NonNull Context context, int resource, @NonNull List<hotelsList> objects) {
        super(context, resource, objects);

        listHotel = objects;
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        //to show design

        View view = LayoutInflater.from(getContext()).inflate(R.layout.hotels_design, parent, false);


        //to get the info

        hotelsList currentHotel = listHotel.get(position);

        TextView hotelName = view.findViewById(R.id.hName);
        ImageView hotelImg = view.findViewById(R.id.hImage);

        hotelName.setText(currentHotel.getHotelName());
        hotelImg.setImageResource(currentHotel.getHotelImg());

        return view;

    }
}
