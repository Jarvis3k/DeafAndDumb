package com.example.deafanddumbtalk;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
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

public class recording extends Fragment {

    GridView gridView;

    String[] Names = {"ALphabets","Numbers","Colors","Food","Questions","Animals","Days","Weather","Relationship"};
    int[] Images = {R.drawable.abcc,R.drawable.numbers,R.drawable.color,R.drawable.food,R.drawable.question,R.drawable.animals,R.drawable.days,R.drawable.weather,R.drawable.relatinship};

    public recording() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_recording, container, false);

        gridView = view.findViewById(R.id.grid);

        CustomAdapter customAdapter = new CustomAdapter();
        gridView.setAdapter(customAdapter);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch(position){
                    case 0:
                        Intent a = new Intent(view.getContext(), Alphabets.class);
                        view.getContext().startActivity(a);
                        break;
                    case 1:
                        Intent b = new Intent(view.getContext(), Numbers.class);
                        view.getContext().startActivity(b);
                        break;
                    case 2:
                        Intent c = new Intent(view.getContext(), Colors.class);
                        view.getContext().startActivity(c);
                        break;
                    case 3:
                        Intent d = new Intent(view.getContext(), Food.class);
                        view.getContext().startActivity(d);
                        break;
                    case 4:
                        Intent e = new Intent(view.getContext(), Questions.class);
                        view.getContext().startActivity(e);
                        break;
                    case 5:
                        Intent f = new Intent(view.getContext(), Animals.class);
                        view.getContext().startActivity(f);
                        break;
                    case 6:
                        Intent g = new Intent(view.getContext(), Days.class);
                        view.getContext().startActivity(g);
                        break;
                    case 7:
                        Intent h = new Intent(view.getContext(), Weather.class);
                        view.getContext().startActivity(h);
                        break;
                    case 8:
                        Intent i = new Intent(view.getContext(), Relationship.class);
                        view.getContext().startActivity(i);
                        break;
                    default:
                        break;
                }

            }

        });
        return view;
    }

    private class CustomAdapter extends BaseAdapter {
        @Override
        public int getCount() {
            return Images.length;
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            view = getLayoutInflater().inflate(R.layout.row_data, null);
            //getting view in row_data
            TextView name = view.findViewById(R.id.text);
            ImageView image = view.findViewById(R.id.image);
            name.setText(Names[i]);
            image.setImageResource(Images[i]);
            return view;
        }
    }

}