package com.example.deafanddumbtalk;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import javax.annotation.Nullable;

import static com.example.deafanddumbtalk.Register.TAG;

public class home extends Fragment {

    private static String uname;
    FirebaseFirestore db = FirebaseFirestore.getInstance();
    private FirebaseAuth mAuth;


    MediaPlayer mediaPlayer1;
    MediaPlayer mediaPlayer2;
    MediaPlayer mediaPlayer3;
    MediaPlayer mediaPlayer4;
    MediaPlayer mediaPlayer5;


    private Button ring1;
    private Button ring2;
    private Button ring3;
    private Button ring4;
    private Button ring5;

    TextView welcometxt;
    public home() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_home, container, false);



        final Button ring1 = view.findViewById (R.id.ring1);
        mediaPlayer1 = MediaPlayer.create(getActivity(),R.raw.thankyou);
        ring1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayer1.start();
            }
        });


        final Button ring2 = view.findViewById(R.id.ring2);
        mediaPlayer2 = MediaPlayer.create(getActivity(),R.raw.ineedsome);
        ring2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayer2.start();
            }
        });

        final Button ring3  = view.findViewById(R.id.ring3);
        mediaPlayer3 = MediaPlayer.create(getActivity(),R.raw.yourwelcome);
        ring3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayer3.start();
            }
        });


        final Button ring4 = view.findViewById(R.id.ring4);
        mediaPlayer4 = MediaPlayer.create(getActivity(),R.raw.ineedbathroom);
        ring4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayer4.start();
            }
        });


        final Button ring5 = view.findViewById(R.id.ring5);
        mediaPlayer5 = MediaPlayer.create(getActivity(),R.raw.ineedfood);
        ring5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayer5.start();
            }
        });







        // Inflate the layout for this fragment

        welcometxt = view.findViewById(R.id.txt_welcome);


        mAuth = FirebaseAuth.getInstance();

        String userId;
        userId = mAuth.getCurrentUser().getUid();
        DocumentReference documentReference = db.collection("users").document(userId);
        documentReference.addSnapshotListener(new EventListener<DocumentSnapshot>() {
            @Override
            public void onEvent(@Nullable DocumentSnapshot documentSnapshot, @Nullable FirebaseFirestoreException e) {
                if(documentSnapshot.exists()){
                    welcometxt.setText("Welcome " + documentSnapshot.getString("Name"));

                }else {
                    Log.d("tag", "onEvent: Document do not exists");
                }
            }
        });

        return view;
    }


}