package com.app1.paded.myapplication;

import android.content.Intent;
import android.content.res.Resources;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.SearchView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
public class MainActivity extends AppCompatActivity  {

    List<DataItem> IstData;
    ArrayAdapter<String> adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.all_bus_fragment_layout);
        IstData = new ArrayList<>();

        String [] bus_ID = getResources().getStringArray(R.array.Bus_ID);
        String [] bus_start_stop = getResources().getStringArray(R.array.Bus_Start_Stop);

        for(int i=0; i<bus_ID.length; i++){
            if(i==0){
                IstData.add(new DataItem(R.drawable.line0,bus_ID[i],"BUS"+i,bus_start_stop[i]));
            }else if(i==1){
                IstData.add(new DataItem(R.drawable.line1,bus_ID[i],"BUS"+i,bus_start_stop[i]));
            }else if(i==2){
                IstData.add(new DataItem(R.drawable.line2,bus_ID[i],"BUS"+i,bus_start_stop[i]));
            }else if(i==3){
                IstData.add(new DataItem(R.drawable.line3,bus_ID[i],"BUS"+i,bus_start_stop[i]));
            }else if(i==4){
                IstData.add(new DataItem(R.drawable.line4,bus_ID[i],"BUS"+i,bus_start_stop[i]));
            }else if(i==5){
                IstData.add(new DataItem(R.drawable.line7,bus_ID[i],"BUS"+i,bus_start_stop[i]));
            }else if(i==6){
                IstData.add(new DataItem(R.drawable.line8,bus_ID[i],"BUS"+i,bus_start_stop[i]));
            }else if(i==7){
                IstData.add(new DataItem(R.drawable.line9,bus_ID[i],"BUS"+i,bus_start_stop[i]));
            }else if(i==8){
                IstData.add(new DataItem(R.drawable.line10,bus_ID[i],"BUS"+i,bus_start_stop[i]));
            }else if(i==9){
                IstData.add(new DataItem(R.drawable.line11,bus_ID[i],"BUS"+i,bus_start_stop[i]));
            }

        }

        ListView listView = (ListView)findViewById(R.id.listView);



        CustomAdpter adpter = new CustomAdpter(MainActivity.this,R.layout.row_layout,IstData);
        listView.setAdapter(adpter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent();
                intent.putExtra("Bus_ID",IstData.get(position).Bus_ID);
                intent.putExtra("NameOFBus",IstData.get(position).linename);
                intent.setClass(MainActivity.this,LineActivity.class);
                startActivity(intent);
            }
        });

    }

}
