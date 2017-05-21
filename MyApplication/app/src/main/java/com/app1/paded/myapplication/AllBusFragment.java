package com.app1.paded.myapplication;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Paded on 5/16/2017.
 */

public class AllBusFragment extends Fragment {
    List<DataItem> IstData;
    ArrayAdapter<String> adapter;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.all_bus_fragment_layout, container, false);

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

        ListView listView = (ListView)v.findViewById(R.id.listView);



        CustomAdpter adpter = new CustomAdpter(getActivity(),R.layout.row_layout,IstData);
        listView.setAdapter(adpter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent();
                intent.putExtra("Bus_ID",IstData.get(position).Bus_ID);
                intent.putExtra("NameOFBus",IstData.get(position).linename);
                intent.setClass(getActivity(),LineActivity.class);
                startActivity(intent);
            }
        });

        return v;
    }
}
