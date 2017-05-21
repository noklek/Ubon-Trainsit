package com.app1.paded.myapplication;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Paded on 5/14/2017.
 */

public class CustomAdpter extends ArrayAdapter<DataItem> {
    Context context;
    int layoutResourceId;
    List<DataItem> data=null;
    public CustomAdpter(@NonNull Context context, @LayoutRes int resource, @NonNull List<DataItem> objects) {
        super(context, resource, objects);
        this.layoutResourceId = resource;
        this.context = context;
        this.data=objects;
    }
    static class DataHolder{
        ImageView icn;
        TextView busnam;
        TextView STbus;
    }
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        DataHolder holder = null;
        if(convertView==null){
            LayoutInflater inflater = ((Activity)context).getLayoutInflater();
            convertView = inflater.inflate(layoutResourceId,parent,false);
            holder = new DataHolder();
            holder.icn = (ImageView)convertView.findViewById(R.id.imageView);
            holder.busnam = (TextView)convertView.findViewById(R.id.title);
            holder.STbus = (TextView)convertView.findViewById(R.id.def);
            convertView.setTag(holder);
        }else{
            holder = (DataHolder)convertView.getTag();
        }
        DataItem dataItem = data.get(position);
        holder.busnam.setText(dataItem.linename);
        holder.STbus.setText(dataItem.STbus);
        holder.icn.setImageResource(dataItem.resIdThum);
        return convertView;
    }

}
