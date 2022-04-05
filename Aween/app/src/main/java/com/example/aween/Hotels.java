package com.example.aween;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;

import com.google.firebase.auth.FirebaseAuth;

import java.util.ArrayList;

public class Hotels extends AppCompatActivity {

    ImageView home, profile, logout;


    //the array list

    ArrayList<hotelsList> hotel = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hotels);

        home = findViewById(R.id.Home);
        profile = findViewById(R.id.Profile);
        logout = findViewById(R.id.Logout);



        //menu profile intent

        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Hotels.this, ActivityProfile.class);
                startActivity(intent);
            }
        });


        //menu home intent

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent home = new Intent(Hotels.this, MainPage.class);
                startActivity(home);
            }
        });


        //list hotels

        hotelsList h1 = new hotelsList("FourSeasons", R.drawable.fourseasons, 22006000, "FourSeasons@gmail.com", "يوجد لدينا خمس وجبات كاملة مع التغليف المحكم", R.drawable.ic_baseline_location_on_24);
        hotelsList h2 = new hotelsList("Jumeirah", R.drawable.jumeirah, 22269600, "Jumeirah@gmail.com", "متوفر أربعة وجبات مغلفة جاهزة للإستلام", R.drawable.ic_baseline_location_on_24);
        hotelsList h3 = new hotelsList("Marina", R.drawable.marina, 22230030, "Marina@gnail.com", "متوفرة ثلاث وجبات *بدون مشروب* مع التغليف", R.drawable.ic_baseline_location_on_24);
        hotelsList h4 = new hotelsList("Movenpick", R.drawable.movenpick, 24610033, "movenpick@gmail.com", "متاح ثلاث وجبات فطور محكمة التغليف وجاهزة للإستلام", R.drawable.ic_baseline_location_on_24);
        hotelsList h5 = new hotelsList("Safir", R.drawable.safir, 2545555, "Safir@gmail.com", "نفذت كمية وجبات اليوم! الرجاء ترقُب اليوم التالي", R.drawable.ic_baseline_location_on_24);
        hotelsList h6 = new hotelsList("Regency", R.drawable.regency, 25766666, "Regency@gmail.com", "متوفرة وجبة صحية كاملة مع التغليف", R.drawable.ic_baseline_location_on_24);
        hotelsList h7 = new hotelsList("Symphony", R.drawable.symphonystyle, 25770000, "Symphony@gnail.com", "متوفر وجبتان كاملتان مع التغليف المحكم", R.drawable.ic_baseline_location_on_24);



        // adding restaurant
        
        hotel.add(h1);
        hotel.add(h2);
        hotel.add(h3);
        hotel.add(h4);
        hotel.add(h5);
        hotel.add(h6);
        hotel.add(h7);


        hotelAdapter hotelAdapter = new hotelAdapter(this, 0, hotel);


        //link the list to Java
        ListView listView = findViewById(R.id.listView);


        //adapter activation
        listView.setAdapter(hotelAdapter);


        //details page intent
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                hotelsList currentHotel = hotel.get(i);

                Intent detailsIntent = new Intent(Hotels.this, hDetailsActivity.class);
                detailsIntent.putExtra("currentHotel", currentHotel);
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