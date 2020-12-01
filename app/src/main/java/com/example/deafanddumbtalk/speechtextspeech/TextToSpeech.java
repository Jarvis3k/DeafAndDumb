package com.example.deafanddumbtalk.speechtextspeech;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.deafanddumbtalk.R;

import java.util.Locale;

public class TextToSpeech extends Activity {
    EditText etInput;
    Button play,clear;

    android.speech.tts.TextToSpeech textToSpeech;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text_to_speech);


        etInput=findViewById(R.id.et_input);
        play=findViewById(R.id.play);
        clear=findViewById(R.id.clear);

        textToSpeech = new android.speech.tts.TextToSpeech(getApplicationContext(),
                new android.speech.tts.TextToSpeech.OnInitListener() {
                    @Override
                    public void onInit(int i) {
                        if (i == android.speech.tts.TextToSpeech.SUCCESS){
                            int lang = textToSpeech.setLanguage(Locale.ENGLISH);
                        }
                    }
                });

        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String s = etInput.getText().toString();


                int speech = textToSpeech.speak(s, android.speech.tts.TextToSpeech.QUEUE_FLUSH,null);

            }
        });

        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                etInput.setText("");
            }
        });
    }
}
