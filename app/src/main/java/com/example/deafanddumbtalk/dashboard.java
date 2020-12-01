package com.example.deafanddumbtalk;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.example.deafanddumbtalk.login.Login;
import com.example.deafanddumbtalk.speechtextspeech.SpeechToText;
import com.example.deafanddumbtalk.speechtextspeech.TextToSpeech;
import com.google.firebase.auth.FirebaseAuth;
import com.ismaeldivita.chipnavigation.ChipNavigationBar;


public class dashboard extends AppCompatActivity {

    private ChipNavigationBar chipNavigationBar;
    private Fragment fragment = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);


        chipNavigationBar = findViewById(R.id.bottonNav);
        chipNavigationBar.setItemSelected(R.id.profile, true);
        getSupportFragmentManager().beginTransaction().replace(R.id.container, new home()).commit();
        chipNavigationBar.setOnItemSelectedListener(new ChipNavigationBar.OnItemSelectedListener() {
            @Override
            public void onItemSelected(int i) {
                switch (i) {
                    case R.id.profile:
                        fragment = new home();
                        break;
                    case R.id.home:
                        fragment = new dash();
                        break;

                    case R.id.writtingpad:
                        fragment = new recording();
                        break;


                }
                if (fragment != null) {
                    getSupportFragmentManager().beginTransaction().replace(R.id.container, fragment).commit();
                }


            }
        });
    }


}