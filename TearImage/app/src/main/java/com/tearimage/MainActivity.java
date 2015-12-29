package com.tearimage;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final CustomGestureDetectorListener leftListener = new CustomGestureDetectorListener();
        leftListener.setMoveView(findViewById(R.id.clip_to));
        CustomGestureDetectorListener rightListener = new CustomGestureDetectorListener();
        rightListener.setMoveView(findViewById(R.id.clip_to_right));
        final GestureDetector leftGesture = new GestureDetector(this, leftListener);
        final GestureDetector rightGesture = new GestureDetector(this, rightListener);
        findViewById(R.id.clip_to).setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return leftGesture.onTouchEvent(event);
            }
        });
        findViewById(R.id.clip_to_right).setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return rightGesture.onTouchEvent(event);
            }
        });

    }
}
