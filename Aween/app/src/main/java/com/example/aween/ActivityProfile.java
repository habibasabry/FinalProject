package com.example.aween;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;

import org.w3c.dom.Document;

public class ActivityProfile extends AppCompatActivity {

    ImageView home, profile, logout;


    TextView fullName, email, phone;
    FirebaseAuth fAuth;
    FirebaseFirestore fStore;
    String userId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        home = findViewById(R.id.Home);
        profile = findViewById(R.id.Profile);
        logout = findViewById(R.id.Logout);


        phone = findViewById(R.id.uPhoneNum);
        fullName = findViewById(R.id.uName);
        email = findViewById(R.id.uEmail);

        fAuth = FirebaseAuth.getInstance();
        fStore = FirebaseFirestore.getInstance();

        userId = fAuth.getCurrentUser().getUid();

        DocumentReference documentReference = fStore.collection("users").document(userId);
        documentReference.addSnapshotListener(this, new EventListener<DocumentSnapshot>() {
            @Override
            public void onEvent(@Nullable DocumentSnapshot value, @Nullable FirebaseFirestoreException error) {
                phone.setText(value.getString("phone"));
                fullName.setText(value.getString("fName"));
                email.setText(value.getString("email"));
            }
        });



        //menu profile intent

        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ActivityProfile.this, ActivityProfile.class);
                startActivity(intent);
            }
        });


        //menu home intent

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent home = new Intent(ActivityProfile.this, MainPage.class);
                startActivity(home);
            }
        });


        //phone Number intent

        final String[] num = new String[1];
        phone.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {

                num[0] = phone.getText().toString().trim();

                Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+ Uri.encode(num[0])));
                startActivity(intent);

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