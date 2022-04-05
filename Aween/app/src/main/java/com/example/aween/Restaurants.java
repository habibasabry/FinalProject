package com.example.aween;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;

import com.google.firebase.auth.FirebaseAuth;

import java.util.ArrayList;

public class Restaurants extends AppCompatActivity {

    ImageView home, profile, logout;

    //the array list

    ArrayList<restaurantsList> restaurant = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurants);

        home = findViewById(R.id.Home);
        profile = findViewById(R.id.Profile);
        logout = findViewById(R.id.Logout);


        //menu home intent

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent home = new Intent(Restaurants.this, MainPage.class);
                startActivity(home);
            }
        });


        //menu profile intent

        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Restaurants.this, ActivityProfile.class);
                startActivity(intent);
            }
        });



        // list restaurant

        restaurantsList r1 = new restaurantsList("Burger King", R.drawable.r1, 1811111, "burgerKing@gmail.com", "متوفر ثلاث وجبات مغلفة وجاهزة للإستلام", R.drawable.ic_baseline_location_on_24);
        restaurantsList r2 = new restaurantsList("P.F.Chang's", R.drawable.r2, 22081293, "pfchang's@gmail.com", "توجد وجبة متوفرة محكمة التغيف *بدون مشروب", R.drawable.ic_baseline_location_on_24);
        restaurantsList r3 = new restaurantsList("dunkin donuts", R.drawable.r3, 22451191, "dunkinDonuts@gmail.com", "متوفر علبتين 12 قطعة", R.drawable.ic_baseline_location_on_24);
        restaurantsList r4 = new restaurantsList("pizza hut", R.drawable.r4, 1815050, "pizzahut@gmail.com", "متوفر 4 وجبات كاملة مغلفة", R.drawable.ic_baseline_location_on_24);
        restaurantsList r5 = new restaurantsList("Breakfast Club", R.drawable.r5, 23722737, "breakfastclub@gmail.com", "متوفر ثلاث فطائر جيدة التغليف", R.drawable.ic_baseline_location_on_24);
        restaurantsList r6 = new restaurantsList("Asha's", R.drawable.r6, 22254097, "asha'skw@gmail.com", "متاح أربعة أطباق مع التغليف *بدون مشروب", R.drawable.ic_baseline_location_on_24);
        restaurantsList r7 = new restaurantsList("Izmir", R.drawable.r7, 66305552, "izmirq8@gmail.com", "ثلاث وجبات جاهزة كاملة ومغلفة", R.drawable.ic_baseline_location_on_24);


        // adding restaurant

          restaurant.add(r1);
          restaurant.add(r2);
          restaurant.add(r3);
          restaurant.add(r4);
          restaurant.add(r5);
          restaurant.add(r6);
          restaurant.add(r7);


        restaurantAdapter restaurant_Adapter = new restaurantAdapter(this, 0, restaurant);

        //link the list to Java
        ListView listView  = findViewById(R.id.listView);


        //adapter activation
        listView.setAdapter(restaurant_Adapter);


        //details page intent
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                restaurantsList currentRestaurant = restaurant.get(i);

                Intent detailsIntent = new Intent(Restaurants.this, rDetailsActivity.class);
                detailsIntent.putExtra("currentRestaurant", currentRestaurant);

                startActivity(detailsIntent);
            }
        });

    }

    //logout

    public void logout(View view) {
        FirebaseAuth.getInstance().signOut();
        startActivity(new Intent(getApplicationContext(), SignPage.class));
        finish();
    }
}