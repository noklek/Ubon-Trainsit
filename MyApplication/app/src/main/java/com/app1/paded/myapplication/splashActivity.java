package com.app1.paded.myapplication;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class splashActivity extends AppCompatActivity {
  private static  int SPLASH_TIME_OUT=900;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.spladh_layout);
        new Handler().postDelayed(new Runnable(){
            @Override
            public void run() {
                Intent homeintent = new Intent(splashActivity.this,MainActivity.class);
                startActivity(homeintent);
                finish();
            }
        },SPLASH_TIME_OUT);
    }
}
