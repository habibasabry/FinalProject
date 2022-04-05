package com.example.aween;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

import java.util.ArrayList;

public class UserList extends AppCompatActivity {

    ImageView home, profile, logout;

    EditText editText;
    Button button;
    ListView listView;

    ArrayList<String> arrayList;
    ArrayAdapter<String> adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_list);

        home = findViewById(R.id.Home);
        profile = findViewById(R.id.Profile);
        logout = findViewById(R.id.Logout);


        editText = findViewById(R.id.AddHere);
        button = findViewById(R.id.AddBtn);
        listView = findViewById(R.id.listView1);

        arrayList = new ArrayList<>();
        adapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1, arrayList);
        listView.setAdapter(adapter);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String addItem = editText.getText().toString();
                arrayList.add(addItem);
                adapter.notifyDataSetChanged();
                editText.setText("");
            }
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

                new AlertDialog.Builder(UserList.this).setTitle("هل أنت متأكد أنك تريد مسح المساهمة؟" + arrayList.get(position) + "من القائمة؟")
                        .setPositiveButton("نعم", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                                arrayList.remove(position);
                                adapter.notifyDataSetChanged();

                            }
                        }).setNegativeButton("لا", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                }).create().show();

                Toast.makeText(UserList.this, " " + adapterView.getItemAtPosition(position), Toast.LENGTH_SHORT).show();
            }
        });



        //menu home intent

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent home = new Intent(UserList.this, MainPage.class);
                startActivity(home);
            }
        });


        //menu profile intent

        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(UserList.this, ActivityProfile.class);
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