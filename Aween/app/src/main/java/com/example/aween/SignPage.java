package com.example.aween;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Process;
import android.text.InputType;
import android.text.TextUtils;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;


public class SignPage extends AppCompatActivity {
    EditText mEmail, mPassword;
    Button mLoginBtn;
    TextView mCreateBtn;
    ProgressBar progressBar;
    FirebaseAuth fAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_page);

        mEmail = findViewById(R.id.LEmail);
        mPassword = findViewById(R.id.LPassword);
        progressBar = findViewById(R.id.progressBar);
        fAuth = FirebaseAuth.getInstance();
        mLoginBtn = findViewById(R.id.loginBtn);
        mCreateBtn = findViewById(R.id.LcreateText);


        //password dots method

        mPassword.setInputType(InputType.TYPE_CLASS_TEXT);
        mPassword.setTransformationMethod(new PasswordTransformationMethod());

        //mPassword.setTransformationMethod(PasswordTransformationMethod.getInstance()); (another way)



        //to login
        mLoginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = mEmail.getText().toString().trim();
                String password = mPassword.getText().toString().trim();

                if(TextUtils.isEmpty(email)){
                    mEmail.setError("Pleas enter your Email.");
                    return;
                }

                if(TextUtils.isEmpty(password)){
                    mPassword.setError("Pleas enter the Password");
                    return;
                }

                if(password.length() < 6){
                    mPassword.setError("Password must be >= characters");
                    return;
                }



                //loading sign

                progressBar.setVisibility(view.VISIBLE);




                //authenticate the user

                fAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()){
                            Toast.makeText(SignPage.this, "تم تسجيل دخولك بنجاح", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent (getApplicationContext(), MainPage.class));
                        }else{
                            Toast.makeText(SignPage.this, "حدث خطأ! " + task.getException().getMessage(), Toast.LENGTH_SHORT).show();

                        }
                    }
                });
            }
        });


        //create account intent

        Intent intent = (new Intent(SignPage.this, NewUser.class));
        mCreateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(intent);
            }
        });
    }
}