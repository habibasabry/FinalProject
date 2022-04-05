package com.example.aween;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;

public class hDetailsActivity extends AppCompatActivity {

    ImageView home, profile, logout, address;

    TextView phoneNum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hdetails);

        home = findViewById(R.id.Home);
        profile = findViewById(R.id.Profile);
        logout = findViewById(R.id.Logout);
        address = findViewById(R.id.address);

        phoneNum = findViewById(R.id.hPhoneNum);


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
                Intent home = new Intent(hDetailsActivity.this, MainPage.class);
                startActivity(home);
            }
        });


        //get the info

        Bundle bundle = getIntent().getExtras();
        final hotelsList hotels = (hotelsList) bundle.getSerializable("currentHotel");


        TextView hotelName = findViewById(R.id.hName);
        ImageView hotelImg = findViewById(R.id.hImage);
        TextView hotelPhoneNum = findViewById(R.id.hPhoneNum);
        TextView hotelEmail = findViewById(R.id.hEmail);
        TextView hotelDescription = findViewById(R.id.hDescription);


        hotelName.setText(hotels.getHotelName());
        hotelImg.setImageResource(hotels.getHotelImg());
        hotelPhoneNum.setText(hotels.getHotelPhoneNum()+"");
        hotelEmail.setText(hotels.getHotelEmail());
        hotelDescription.setText(hotels.getHotelDescription());


    }

    //logout

    public void logout(View view) {
        FirebaseAuth.getInstance().signOut();
        startActivity(new Intent(getApplicationContext(), SignPage.class));
        finish();
    }

}