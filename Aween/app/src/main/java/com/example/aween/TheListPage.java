package com.example.aween;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.google.firebase.auth.FirebaseAuth;

public class TheListPage extends AppCompatActivity {

    ImageView restaurants, hotels, userList;

    ImageView home, profile, logout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_the_list_page);

        restaurants = findViewById(R.id.Restaurants);
        hotels = findViewById(R.id.Hotels);
        userList = findViewById(R.id.UserList);

        home = findViewById(R.id.Home);
        profile = findViewById(R.id.Profile);
        logout = findViewById(R.id.Logout);



        //menu home intent

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent home = new Intent(TheListPage.this, MainPage.class);
                startActivity(home);
            }
        });

        //restaurants Intent

        restaurants.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent r = new Intent(TheListPage.this, Restaurants.class);
                startActivity(r);
            }
        });


        //hotels Intent

        hotels.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent h = new Intent(TheListPage.this, Hotels.class);
                startActivity(h);
            }
        });


        //userList Intent

        userList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent u = new Intent(TheListPage.this, UserList.class);
                startActivity(u);
            }
        });

    }

    //logout

    public void logout(View view) {
        FirebaseAuth.getInstance().signOut();
        startActivity(new Intent (getApplicationContext(), SignPage.class));
        finish();
    }
}