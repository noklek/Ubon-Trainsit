package com.app1.paded.myapplication;


import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class LineActivity extends AppCompatActivity {
    String busID,linename;


    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_homeRoute:
                    HomeFlagment f = new HomeFlagment();
                    Bundle bundle = new Bundle();
                    bundle.putString("busID", busID);
                    bundle.putString("linename", linename);
                    f.setArguments(bundle);
                    getFragmentManager().beginTransaction().replace(R.id.content,f).commit();
                    return true;
                case R.id.navigation_picRoute:
                    LineImageFragment pR = new LineImageFragment();
                    Bundle gh = new Bundle();
                    gh.putString("busID", busID);
                    gh.putString("linename", linename);
                    pR.setArguments(gh);
                    getFragmentManager().beginTransaction().replace(R.id.content,pR).commit();
                    return true;
            }
            return false;
        }

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bt_layout);

        busID = getIntent().getStringExtra("Bus_ID");
       linename = getIntent().getStringExtra("NameOFBus");


        HomeFlagment f = new HomeFlagment();
        Bundle bundle = new Bundle();
        bundle.putString("busID", busID);
        bundle.putString("linename", linename);
       f.setArguments(bundle);
        getFragmentManager().beginTransaction().replace(R.id.content,f).commit();

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.right_button,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
//        if(item.getItemId()==android.R.id.home){
//            finish();
//        }else if(item.getItemId()==R.id.action_name){
//
//        }
        switch(item.getItemId()){
            case android.R.id.home:
               finish();
                break;
            case R.id.action_name:
                Intent intent = new Intent();
                intent.putExtra("Bus_ID",busID);
                intent.putExtra("linename",linename);
                intent.setClass(LineActivity.this,MapsActivity.class);
                startActivity(intent);
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
