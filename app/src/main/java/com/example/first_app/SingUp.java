package com.example.first_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class SingUp extends AppCompatActivity {
    Button callLoginIn, regButton;

    FirebaseDatabase rootNode;
    DatabaseReference reference;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //This is use to remove status bar
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_sing_up);

        callLoginIn = findViewById(R.id.login_btn);

        callLoginIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SingUp.this,Login.class);
                startActivity(intent);
                finish();
            }
        });
        //Define the button
        regButton = findViewById(R.id.reg_btn);

        //Save data in firebase on button click
        regButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                rootNode = FirebaseDatabase.getInstance();
                reference = rootNode.getReference("users");

                reference.setValue("First data stored");

            }
        });
    }

}