package com.example.deafanddumbtalk;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import androidx.fragment.app.Fragment;

import com.example.deafanddumbtalk.login.Login;
import com.example.deafanddumbtalk.speechtextspeech.SpeechToText;
import com.example.deafanddumbtalk.speechtextspeech.TextToSpeech;
import com.google.firebase.auth.FirebaseAuth;

public class dash extends Fragment {

    private FirebaseAuth mAuth;


    public dash() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
       View view = inflater.inflate(R.layout.fragment_dash, container, false);

        // Inflate the layout for this fragment
        mAuth = FirebaseAuth.getInstance();

        final Button text = view.findViewById(R.id.texttospeech);
        text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                text();
            }
        });

        final Button text1= view.findViewById(R.id.speechtotext);
        text1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                text1();
            }
        });


        final Button text2= view.findViewById(R.id.signlanguage);
        text2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rec();
            }
        });


        final Button text3= view.findViewById(R.id.writtingpad);
        text3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                text3();
            }
        });


        final Button map = view.findViewById(R.id.Maps);
        map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                open();
            }
        });


        final ImageView logoutbtn = view.findViewById(R.id.logout);
        logoutbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                logout();
            }
        });


        return view;
    }

    private void rec() {
        startActivity(new Intent(getActivity(), MainActivity.class));
    }

    private void text1() {
        startActivity(new Intent(getActivity(), SpeechToText.class));
    }
    private void text() {
        startActivity(new Intent(getActivity(), TextToSpeech.class));
    }
    private void text3() {
        startActivity(new Intent(getActivity(),Writtingpad.class));
    }

    public void open() {

        Uri ref=Uri.parse("geo:11.0676862, 77.1098627");
        Intent i = new Intent(Intent.ACTION_VIEW,ref);
        i.setPackage("com.google.android.apps.maps");
        startActivity(i);
    }

    public void logout() {


        mAuth.signOut();
        Intent intent =  new Intent(getActivity(), Login.class);
        startActivity(intent);
    }
}