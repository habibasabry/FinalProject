package com.example.aween;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.auth.FirebaseAuth;

public class MainPage extends AppCompatActivity {

    ImageView rules, about, lists;

    ImageView home, profile, logout;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_page);

        rules = findViewById(R.id.Rules);
        about = findViewById(R.id.About);
        lists = findViewById(R.id.lists);

        home = findViewById(R.id.Home);
        profile = findViewById(R.id.Profile);
        logout = findViewById(R.id.Logout);




        //menu profile intent

        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainPage.this, ActivityProfile.class);
                startActivity(intent);
            }
        });


        //menu home intent

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent home = new Intent(MainPage.this, MainPage.class);
                startActivity(home);
            }
        });


        //rules Intent

        rules.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent r = (new Intent(MainPage.this, Rules.class));
                startActivity(r);
            }
        });




        //about page Intent

        about.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent a = (new Intent(MainPage.this, AboutApp.class));
                startActivity(a);
            }
        });



        //lists Intent

        lists.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ll = (new Intent(MainPage.this, TheListPage.class));
                startActivity(ll);
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