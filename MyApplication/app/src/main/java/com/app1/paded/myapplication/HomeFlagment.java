package com.app1.paded.myapplication;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Paded on 5/16/2017.
 */

public class HomeFlagment extends Fragment {
    String busID, linename;
    List<DataItemRoute> IstData;
    String[] bus_line;
    private TextView smallbar_text;
    private TextView defLine;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.home_flagment_layout, container, false);

        busID = getArguments().getString("busID");
        linename = getArguments().getString("linename");
        smallbar_text = (TextView)v.findViewById(R.id.toolbar_title);
        defLine = (TextView)v.findViewById(R.id.textdefLine);
        smallbar_text.setText("เส้นทางการเดินรถ"+linename);

        IstData = new ArrayList<>();

        if (busID.equalsIgnoreCase("BUS0")) {
            bus_line = getResources().getStringArray(R.array.BUS0);

        } else if (busID.equalsIgnoreCase("BUS1")) {
            bus_line = getResources().getStringArray(R.array.BUS1);
        } else if (busID.equalsIgnoreCase("BUS2")) {
            bus_line = getResources().getStringArray(R.array.BUS2);
        } else if (busID.equalsIgnoreCase("BUS3")) {
            bus_line = getResources().getStringArray(R.array.BUS3);
        } else if (busID.equalsIgnoreCase("BUS4")) {
            bus_line = getResources().getStringArray(R.array.BUS4);
        } else if (busID.equalsIgnoreCase("BUS5")) {
            bus_line = getResources().getStringArray(R.array.BUS5);
        } else if (busID.equalsIgnoreCase("BUS6")) {
            bus_line = getResources().getStringArray(R.array.BUS6);
        } else if (busID.equalsIgnoreCase("BUS7")) {
            bus_line = getResources().getStringArray(R.array.BUS7);
        } else if (busID.equalsIgnoreCase("BUS8")) {
            bus_line = getResources().getStringArray(R.array.BUS8);
        } else if (busID.equalsIgnoreCase("BUS9")) {
            bus_line = getResources().getStringArray(R.array.BUS9);
        }
        for (int i = 0; i < bus_line.length; i++) {
            if(i==0 || i==bus_line.length-1){
                if(i==0){
                    IstData.add(new DataItemRoute(R.drawable.beginxxxhdpi, bus_line[i],"ต้นสาย"));
                }else{
                    IstData.add(new DataItemRoute(R.drawable.beginxxxhdpi, bus_line[i],"ปลายสาย"));
                }

            }else{
                IstData.add(new DataItemRoute(R.drawable.endxxxhdpi, bus_line[i],""));
            }

        }
        ListView listView = (ListView) v.findViewById(R.id.listView);
        CustomAdpterRoute adpter = new CustomAdpterRoute(getActivity(),R.layout.row_layout_route,IstData);
        listView.setAdapter(adpter);
        return v;



    }
}


