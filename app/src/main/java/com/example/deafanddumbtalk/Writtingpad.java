package com.example.deafanddumbtalk;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;


public class Writtingpad extends AppCompatActivity {

    private CanvasView canvasView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_writtingpad);

        canvasView = (CanvasView)findViewById(R.id.Canvas);

    }

    public void ClearCanvas(View view) {
        canvasView.clearCanvas();
    }
}