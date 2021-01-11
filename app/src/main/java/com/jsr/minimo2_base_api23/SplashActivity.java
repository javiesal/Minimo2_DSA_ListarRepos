package com.jsr.minimo2_base_api23;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class SplashActivity extends AppCompatActivity {
    private Handler mHandler;
    private Runnable mRunnable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        final Context context = getApplicationContext();
        mRunnable = new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(context, MainActivity.class));
            }
        };
        mHandler = new Handler();
        mHandler.postDelayed(mRunnable, 2500);
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mRunnable != null && mHandler != null)
            mHandler.removeCallbacks(mRunnable);
    }
}