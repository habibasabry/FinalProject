package com.example.aween;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;

public class rDetailsActivity extends AppCompatActivity {

    ImageView home, profile, logout, address;

    TextView phoneNum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rdetails);

        home = findViewById(R.id.Home);
        profile = findViewById(R.id.Profile);
        logout = findViewById(R.id.Logout);
        address = findViewById(R.id.address);

        phoneNum = findViewById(R.id.rPhoneNum);


        //address intent

        address.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("geo: 4377.3 2085.789"));
                startActivity(intent);
            }
        });



        //phone Number intent

        final String[] num = new String[1];
        phoneNum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                num[0] = phoneNum.getText().toString().trim();

                Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+ Uri.encode(num[0])));
                startActivity(intent);

            }
        });


        //menu home intent

       home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent home = new Intent(rDetailsActivity.this, MainPage.class);
                startActivity(home);
            }
        });

        //get the info

        Bundle bundle = getIntent().getExtras();
        final restaurantsList restaurants = (restaurantsList) bundle.getSerializable("currentRestaurant");


        TextView restaurantName = findViewById(R.id.rName);
        ImageView restaurantImg = findViewById(R.id.rImage);
        TextView restaurantPhoneNum = findViewById(R.id.rPhoneNum);
        TextView restaurantEmail = findViewById(R.id.rEmail);
        TextView restaurantDescription = findViewById(R.id.rDescription);
        ImageView restaurantAddress = findViewById(R.id.address);



        //restaurantsList currentRestaurant = (restaurantsList) restaurantDetails.getSerializable("currentRestaurant");

        restaurantName.setText(restaurants.getRestaurantName());
        restaurantImg.setImageResource(restaurants.getRestaurantImg());
        restaurantPhoneNum.setText(restaurants.getPhoneNum()+"");
        restaurantEmail.setText(restaurants.getEmail());
        restaurantDescription.setText(restaurants.getDescription());
        restaurantAddress.setImageResource(restaurants.getAddress());
    }

    //logout

    public void logout(View view) {
        FirebaseAuth.getInstance().signOut();
        startActivity(new Intent(getApplicationContext(), SignPage.class));
        finish();
    }
}