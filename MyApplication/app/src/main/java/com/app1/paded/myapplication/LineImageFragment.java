package com.app1.paded.myapplication;

import android.app.Fragment;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Paded on 5/16/2017.
 */

public class LineImageFragment extends Fragment{

    private TextView smallbar_text;
    String linename,busID;
    Bitmap bitmap;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.line_image_fragment_layout,container,false);

          linename = getArguments().getString("linename");
        busID = getArguments().getString("busID");
        smallbar_text = (TextView)v.findViewById(R.id.toolbar_title);
        smallbar_text.setText("แผนภาพเส้นทางการเดินรถ"+linename);
        if(busID.equalsIgnoreCase("BUS0")){
           bitmap= BitmapFactory.decodeResource(getActivity().getResources(),
                    R.drawable.picbus0xxhdpi);
        }else if(busID.equalsIgnoreCase("BUS1")){
          bitmap= BitmapFactory.decodeResource(getActivity().getResources(),
                    R.drawable.picbus1xxhdpi);
        }else if(busID.equalsIgnoreCase("BUS2")){
           bitmap= BitmapFactory.decodeResource(getActivity().getResources(),
                    R.drawable.picbus2xxhdpi);
        }else if(busID.equalsIgnoreCase("BUS3")){
           bitmap= BitmapFactory.decodeResource(getActivity().getResources(),
                    R.drawable.picbus3xxhdpi);
        }else{
            bitmap= BitmapFactory.decodeResource(getActivity().getResources(),
                    R.drawable.picbus0xxhdpi);
        }

        ZoomableImageView touch = (ZoomableImageView)v.findViewById(R.id.IMAGEID);
        touch.setImageBitmap(bitmap);

        return v;
    }
}
