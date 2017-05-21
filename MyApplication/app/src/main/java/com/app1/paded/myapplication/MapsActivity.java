package com.app1.paded.myapplication;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolylineOptions;

public class MapsActivity extends AppCompatActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private String getBusID,linename;
    private TextView smallbar_text;
    private String [] bus_title;
    private String [] busMark;
    private String [] latlng;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps_layout);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        linename = getIntent().getStringExtra("linename");
        smallbar_text = (TextView)findViewById(R.id.toolbar_title);
        smallbar_text.setText("แผนที่เส้นทางการเดินรถ"+linename);
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        int height = 150;
        int width = 105;
        BitmapDrawable bitmapdraw=(BitmapDrawable)getResources().getDrawable(R.drawable.pinstart);
        Bitmap b=bitmapdraw.getBitmap();
        Bitmap smallMarkerStart = Bitmap.createScaledBitmap(b, width, height, false);

        BitmapDrawable bitmapdraw2=(BitmapDrawable)getResources().getDrawable(R.drawable.pinstop);
        Bitmap b22=bitmapdraw2.getBitmap();
        Bitmap smallMarkerStop = Bitmap.createScaledBitmap(b22, width, height, false);

        BitmapDrawable bitmapdraw3=(BitmapDrawable)getResources().getDrawable(R.drawable.pinpass);
        Bitmap b33=bitmapdraw3.getBitmap();
        Bitmap smallMarkerPass = Bitmap.createScaledBitmap(b33, width, height, false);

        mMap = googleMap;
//        double total = Double.parseDouble(jlbTotal.getText());
        getBusID = getIntent().getStringExtra("Bus_ID");
        if (getBusID.equalsIgnoreCase("BUS0")) {

            //map ม.อุบล
            LatLng Pubu = new LatLng(15.118272, 104.900128);
            mMap.addMarker(new MarkerOptions().position(Pubu).title("มหาวิทยาลัยอุบลราชธานี").icon(BitmapDescriptorFactory.fromBitmap(smallMarkerStart)));
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(Pubu,12));

            //map ตลาดเจริญศรี
            LatLng s1 = new LatLng(15.173187, 104.873668);
            mMap .addMarker(new MarkerOptions().position(s1).title("ตลาดเจริญศรี").icon(BitmapDescriptorFactory.fromBitmap(smallMarkerPass)));
            mMap.moveCamera(CameraUpdateFactory.newLatLng(s1));

            //map ตลาดวาริน
            LatLng s3 = new LatLng(15.199762, 104.865608);
            mMap.addMarker(new MarkerOptions().position(s3).title("ตลาดวาริน").icon(BitmapDescriptorFactory.fromBitmap(smallMarkerPass)));
            mMap.moveCamera(CameraUpdateFactory.newLatLng(s3));

            //map ทุ่งศรีเมือง
            LatLng s4 = new LatLng(15.199345, 104.861509);
            mMap.addMarker(new MarkerOptions().position(s4).title("ทุ่งศรีเมือง").icon(BitmapDescriptorFactory.fromBitmap(smallMarkerPass)));
            mMap.moveCamera(CameraUpdateFactory.newLatLng(s4));

            //map อุบลวัสดุ
            LatLng s5 = new LatLng(15.212742, 104.860670);
            mMap.addMarker(new MarkerOptions().position(s5).title("อุบลวัสดุ").icon(BitmapDescriptorFactory.fromBitmap(smallMarkerPass)));
            mMap.moveCamera(CameraUpdateFactory.newLatLng(s5));

            //map ตลาดใหญ่
            LatLng s6 = new LatLng(15.224811, 104.858792);
            mMap.addMarker(new MarkerOptions().position(s6).title("ตลาดใหญ่").icon(BitmapDescriptorFactory.fromBitmap(smallMarkerPass)));
            mMap.moveCamera(CameraUpdateFactory.newLatLng(s6));

            //map สำนักงานสาธารณสุขจังหวัดอุบลราชธานี
            LatLng s7 = new LatLng(15.224907, 104.855252);
            mMap.addMarker(new MarkerOptions().position(s7).title("สำนักงานสาธารณสุขจังหวัดอุบลราชธานี").icon(BitmapDescriptorFactory.fromBitmap(smallMarkerPass)));
            mMap.moveCamera(CameraUpdateFactory.newLatLng(s7));

            //map วิทยาลัยอาชีวศึกษาอุบลราชธานี
            LatLng s8 = new LatLng(15.224907, 104.855252);
            mMap.addMarker(new MarkerOptions().position(s8).title("วิทยาลัยอาชีวศึกษาอุบลราชธานี").icon(BitmapDescriptorFactory.fromBitmap(smallMarkerPass)));
            mMap.moveCamera(CameraUpdateFactory.newLatLng(s8));

            //map ทุ่งศรีเมือง
            LatLng s9 = new LatLng(15.229722, 104.856822);
            mMap.addMarker(new MarkerOptions().position(s9).title("ทุ่งศรีเมือง").icon(BitmapDescriptorFactory.fromBitmap(smallMarkerPass)));
            mMap.moveCamera(CameraUpdateFactory.newLatLng(s9));

            //map โรงเรียนนารีนุกุล
            LatLng s10 = new LatLng(15.241472, 104.847495);
            mMap.addMarker(new MarkerOptions().position(s10).title("โรงเรียนนารีนุกุล").icon(BitmapDescriptorFactory.fromBitmap(smallMarkerPass)));
            mMap.moveCamera(CameraUpdateFactory.newLatLng(s10));

            //map วิทยาลัยเทคนิคอุบลราชธานี
            LatLng s11 = new LatLng(15.241740, 104.845551);
            mMap.addMarker(new MarkerOptions().position(s11).title("วิทยาลัยเทคนิคอุบลราชธานี").icon(BitmapDescriptorFactory.fromBitmap(smallMarkerPass)));
            mMap.moveCamera(CameraUpdateFactory.newLatLng(s11));

            //map มหาวิทยาลัยราชภฏอุบลราชธานี
            LatLng s12 = new LatLng(15.246873, 104.848005);
            mMap.addMarker(new MarkerOptions().position(s12).title("มหาวิทยาลัยราชภฏอุบลราชธานี").icon(BitmapDescriptorFactory.fromBitmap(smallMarkerPass)));
            mMap.moveCamera(CameraUpdateFactory.newLatLng(s12));

            //map โรงพยาบาลพระศรีมหาโพธิ์
            LatLng s13 = new LatLng(15.250455, 104.840795);
            mMap.addMarker(new MarkerOptions().position(s13).title("โรงพยาบาลพระศรีมหาโพธิ์").icon(BitmapDescriptorFactory.fromBitmap(smallMarkerPass)));
            mMap.moveCamera(CameraUpdateFactory.newLatLng(s13));

            //map แมคโคร
            LatLng s14 = new LatLng(15.241740, 104.845551);
            mMap.addMarker(new MarkerOptions().position(s14).title("แมคโคร").icon(BitmapDescriptorFactory.fromBitmap(smallMarkerPass)));
            mMap.moveCamera(CameraUpdateFactory.newLatLng(s14));

            //map สถานีขนส่งอุบลราชธานี
            LatLng s15 = new LatLng(15.272672, 104.837359);
            mMap.addMarker(new MarkerOptions().position(s15).title("สถานีขนส่งอุบลราชธานี").icon(BitmapDescriptorFactory.fromBitmap(smallMarkerStop)));
            mMap.moveCamera(CameraUpdateFactory.newLatLng(s15));
            //

            //  way the bus pass
            LatLng busM = new LatLng(15.118450, 104.899864);//start
            // add line in google map
            mMap.addPolyline(new PolylineOptions().add(
                    busM,
                    new LatLng(15.118337, 104.899330),
                    new LatLng(15.128965, 104.897171),
                    new LatLng(15.135263, 104.895311),
                    new LatLng(15.135884, 104.895408),
                    new LatLng(15.137003, 104.895783),
                    new LatLng(15.137417, 104.895740),
                    new LatLng(15.141168, 104.894262),
                    new LatLng(15.141732, 104.894092),
                    new LatLng(15.147793, 104.892798),
                    new LatLng(15.148220, 104.892632),
                    new LatLng(15.167263, 104.882030),
                    new LatLng(15.168046, 104.881385),
                    new LatLng(15.170021, 104.878932),
                    new LatLng(15.170929, 104.877807),
                    new LatLng(15.171836, 104.876277),
                    new LatLng(15.174203, 104.872847),
                    new LatLng(15.182033, 104.869344),
                    new LatLng(15.187461, 104.867980),
                    new LatLng(15.189379, 104.867781),
                    new LatLng(15.192163, 104.867356),
                    new LatLng(15.192452, 104.867188),
                    new LatLng(15.193699, 104.866245),
                    new LatLng(15.195211, 104.865508),
                    new LatLng(15.195986, 104.865405),
                    new LatLng(15.197892, 104.865312),
                    new LatLng(15.198369, 104.865192),
                    new LatLng(15.198842, 104.864999),
                    new LatLng(15.198621, 104.864092),
                    new LatLng(15.199310, 104.863957),
                    new LatLng(15.200044, 104.863946),
                    new LatLng(15.200361, 104.861762),
                    new LatLng(15.201779, 104.862143),
                    new LatLng(15.202016, 104.862101),
                    new LatLng(15.204802, 104.863738),
                    new LatLng(15.205411, 104.863957),
                    new LatLng(15.205818, 104.864009),
                    new LatLng(15.209464, 104.863613),
                    new LatLng(15.210042, 104.863253),
                    new LatLng(15.210324, 104.863003),
                    new LatLng(15.215645, 104.857968),
                    new LatLng(15.216651, 104.857426),
                    new LatLng(15.217325, 104.857239),
                    new LatLng(15.217978, 104.857134),
                    new LatLng(15.218722, 104.857122),
                    new LatLng(15.224825, 104.857342),
                    new LatLng(15.224918, 104.855534),
                    new LatLng(15.226942, 104.855905),
                    new LatLng(15.227894, 104.855910),
                    new LatLng(15.227832, 104.855373),
                    new LatLng(15.228681, 104.855320),
                    new LatLng(15.228707, 104.856516),
                    new LatLng(15.230902, 104.856130),
                    new LatLng(15.231378, 104.855953),
                    new LatLng(15.231514, 104.855862),
                    new LatLng(15.231507, 104.855225),
                    new LatLng(15.231878, 104.851699),
                    new LatLng(15.236429, 104.846874),
                    new LatLng(15.237183, 104.846904),
                    new LatLng(15.237584, 104.846912),
                    new LatLng(15.240117, 104.847064),
                    new LatLng(15.242750, 104.847223),
                    new LatLng(15.244806, 104.847351),
                    new LatLng(15.257914, 104.831318),
                    new LatLng(15.258995, 104.831706),
                    new LatLng(15.259160, 104.831646),
                    new LatLng(15.259325, 104.831700),
                    new LatLng(15.261605, 104.832404),
                    new LatLng(15.261989, 104.832552),
                    new LatLng(15.263146, 104.833007),
                    new LatLng(15.269653, 104.835208),
                    new LatLng(15.270442, 104.835627),
                    new LatLng(15.271012, 104.836072),
                    new LatLng(15.271546, 104.836614),
                    new LatLng(15.271853, 104.837040),
                    new LatLng(15.272170, 104.837444),
                    new LatLng(15.272570, 104.837182)
                    ).color(Color.RED)
            );

        } else if (getBusID.equalsIgnoreCase("BUS1")) {
            //สาย1 สีน้ำเงิน
            //add mark in map
            //map ม.อุบล
            LatLng a0 = new LatLng(15.118272, 104.900128);
            mMap.addMarker(new MarkerOptions().position(a0).title("มหาวิทยาลัยอุบลราชธานี").icon(BitmapDescriptorFactory.fromBitmap(smallMarkerStart)));
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(a0,12));

            //map ตลาดเจริญศรี
            LatLng a1 = new LatLng(15.173187, 104.873668);
            mMap .addMarker(new MarkerOptions().position(a1).title("ตลาดเจริญศรี").icon(BitmapDescriptorFactory.fromBitmap(smallMarkerPass)));
            mMap.moveCamera(CameraUpdateFactory.newLatLng(a1));



            //map อุบลวัสดุ
            LatLng a5 = new LatLng(15.212742, 104.860670);
            mMap.addMarker(new MarkerOptions().position(a5).title("อุบลวัสดุ").icon(BitmapDescriptorFactory.fromBitmap(smallMarkerPass)));
            mMap.moveCamera(CameraUpdateFactory.newLatLng(a5));

            //map ตลาดใหญ่
            LatLng a6 = new LatLng(15.224811, 104.858792);
            mMap.addMarker(new MarkerOptions().position(a6).title("ตลาดใหญ่").icon(BitmapDescriptorFactory.fromBitmap(smallMarkerPass)));
            mMap.moveCamera(CameraUpdateFactory.newLatLng(a6));

            //map วัดใต้พระเจ้าใหญ่องค์ตื้อ
            LatLng a7 = new LatLng(15.227290, 104.866313);
            mMap.addMarker(new MarkerOptions().position(a7).title("วัดใต้พระเจ้าใหญ่องค์ตื้อ").icon(BitmapDescriptorFactory.fromBitmap(smallMarkerPass)));
            mMap.moveCamera(CameraUpdateFactory.newLatLng(a7));

            //map โรงพยาบาลอุบลรักษ์
            LatLng a8 = new LatLng(15.231335, 104.871434);
            mMap.addMarker(new MarkerOptions().position(a8).title("โรงพยาบาลอุบลรักษ์ ").icon(BitmapDescriptorFactory.fromBitmap(smallMarkerPass)));
            mMap.moveCamera(CameraUpdateFactory.newLatLng(a8));

            //map โรงพยาบาลสรรพสิทธิประสงค์
            LatLng a9 = new LatLng(15.236081, 104.865131);
            mMap.addMarker(new MarkerOptions().position(a9).title("โรงพยาบาลสรรพสิทธิประสงค์ ").icon(BitmapDescriptorFactory.fromBitmap(smallMarkerPass)));
            mMap.moveCamera(CameraUpdateFactory.newLatLng(a9));

            //map โรงเรียนนารีนุกุล
            LatLng a10 = new LatLng(15.241472, 104.847495);
            mMap.addMarker(new MarkerOptions().position(a10).title("โรงเรียนนารีนุกุล").icon(BitmapDescriptorFactory.fromBitmap(smallMarkerPass)));
            mMap.moveCamera(CameraUpdateFactory.newLatLng(a10));

            //map วิทยาลัยเทคนิคอุบลราชธานี
            LatLng a11 = new LatLng(15.241740, 104.845551);
            mMap.addMarker(new MarkerOptions().position(a11).title("วิทยาลัยเทคนิคอุบลราชธานี").icon(BitmapDescriptorFactory.fromBitmap(smallMarkerPass)));
            mMap.moveCamera(CameraUpdateFactory.newLatLng(a11));

            //map มหาวิทยาลัยราชภฏอุบลราชธานี
            LatLng a12 = new LatLng(15.246873, 104.848005);
            mMap.addMarker(new MarkerOptions().position(a12).title("มหาวิทยาลัยราชภฏอุบลราชธานี").icon(BitmapDescriptorFactory.fromBitmap(smallMarkerPass)));
            mMap.moveCamera(CameraUpdateFactory.newLatLng(a12));

            //map โรงพยาบาลพระศรีมหาโพธิ์
            LatLng a13 = new LatLng(15.250455, 104.840795);
            mMap.addMarker(new MarkerOptions().position(a13).title("โรงพยาบาลพระศรีมหาโพธิ์").icon(BitmapDescriptorFactory.fromBitmap(smallMarkerPass)));
            mMap.moveCamera(CameraUpdateFactory.newLatLng(a13));

            //map แมคโคร
            LatLng a14 = new LatLng(15.241740, 104.845551);
            mMap.addMarker(new MarkerOptions().position(a14).title("แมคโคร").icon(BitmapDescriptorFactory.fromBitmap(smallMarkerPass)));
            mMap.moveCamera(CameraUpdateFactory.newLatLng(a14));

            //map สถานีขนส่งอุบลราชธานี
            LatLng a15 = new LatLng(15.272672, 104.837359);
            mMap.addMarker(new MarkerOptions().position(a15).title("สถานีขนส่งอุบลราชธานี").icon(BitmapDescriptorFactory.fromBitmap(smallMarkerStop)));
            mMap.moveCamera(CameraUpdateFactory.newLatLng(a15));
            //

            //Mark place at way bus pass

            LatLng starta = new LatLng(15.117126, 104.912633);//start
            LatLng stopa = new LatLng(15.272672, 104.837359);//stop

            mMap.addPolyline(new PolylineOptions().add(

                    starta,
                    new LatLng(15.118676, 104.912575),
                    new LatLng(15.118696, 104.911429),
                    new LatLng(15.120148, 104.911402),
                    new LatLng(15.120556, 104.911233),
                    new LatLng(15.120982, 104.910836),
                    new LatLng(15.122998, 104.908659),
                    new LatLng(15.123120, 104.908201),
                    new LatLng(15.123094, 104.905231),
                    new LatLng(15.122814, 104.904751),
                    new LatLng(15.121157, 104.902817),
                    new LatLng(15.119008, 104.901529),
                    new LatLng(15.118705, 104.901103),
                    new LatLng(15.118609, 104.900717),
                    new LatLng(15.118338, 104.899312),//หน้ามอ
                    new LatLng(15.128965, 104.897171),
                    new LatLng(15.135263, 104.895311),
                    new LatLng(15.135884, 104.895408),
                    new LatLng(15.137003, 104.895783),
                    new LatLng(15.137417, 104.895740),
                    new LatLng(15.141168, 104.894262),
                    new LatLng(15.141732, 104.894092),
                    new LatLng(15.147793, 104.892798),
                    new LatLng(15.148220, 104.892632),
                    new LatLng(15.167263, 104.882030),
                    new LatLng(15.168046, 104.881385),
                    new LatLng(15.170021, 104.878932),
                    new LatLng(15.170929, 104.877807),
                    new LatLng(15.171836, 104.876277),
                    new LatLng(15.172648, 104.874882),
                    new LatLng(15.173660, 104.873249),
                    new LatLng(15.174153, 104.872769),//ตลาดเจริญศรี
                    new LatLng(15.174623, 104.872552),
                    new LatLng(15.176343, 104.871730),
                    new LatLng(15.177386, 104.871343),
                    new LatLng(15.179662, 104.870326),
                    new LatLng(15.181902, 104.869370),
                    new LatLng(15.182005, 104.869366),
                    new LatLng(15.187395, 104.868009),
                    new LatLng(15.188372, 104.867839),
                    new LatLng(15.189396, 104.867785),//ซืนวาน
                    new LatLng(15.190949, 104.867540),
                    new LatLng(15.192235, 104.867305),
                    new LatLng(15.192489, 104.867146),
                    new LatLng(15.193728, 104.866217),
                    new LatLng(15.195405, 104.865430),
                    new LatLng(15.196178, 104.865354),
                    new LatLng(15.197921, 104.865302),
                    new LatLng(15.198837, 104.865005),
                    new LatLng(15.198607, 104.864093),
                    new LatLng(15.199311, 104.863946),
                    new LatLng(15.200033, 104.863955),
                    new LatLng(15.200351, 104.861763),
                    new LatLng(15.201703, 104.862132),
                    new LatLng(15.202006, 104.862118),
                    new LatLng(15.203024, 104.862668),
                    new LatLng(15.204771, 104.863753),
                    new LatLng(15.205562, 104.864001),
                    new LatLng(15.205903, 104.863995),
                    new LatLng(15.209439, 104.863615),
                    new LatLng(15.209754, 104.863432),
                    new LatLng(15.210101, 104.863203),
                    new LatLng(15.215672, 104.857968),
                    new LatLng(15.216251, 104.857593),
                    new LatLng(15.216878, 104.857347),
                    new LatLng(15.217639, 104.857176),
                    new LatLng(15.218327, 104.857152),
                    new LatLng(15.220666, 104.857258),
                    new LatLng(15.223975, 104.857357),
                    new LatLng(15.225086, 104.857359),
                    new LatLng(15.225667, 104.857333),
                    new LatLng(15.225985, 104.858620),
                    new LatLng(15.226059, 104.859171),
                    new LatLng(15.226115, 104.859889),
                    new LatLng(15.226082, 104.861381),
                    new LatLng(15.226055, 104.862053),
                    new LatLng(15.225887, 104.862897),
                    new LatLng(15.225755, 104.863764),
                    new LatLng(15.225825, 104.864385),
                    new LatLng(15.226366, 104.866197),
                    new LatLng(15.226630, 104.867163),
                    new LatLng(15.227022, 104.868560),
                    new LatLng(15.227817, 104.868237),
                    new LatLng(15.227982, 104.868813),
                    new LatLng(15.228357, 104.869888),
                    new LatLng(15.228725, 104.870625),
                    new LatLng(15.229066, 104.871088),
                    new LatLng(15.229159, 104.871284),
                    new LatLng(15.230067, 104.871099),
                    new LatLng(15.230798, 104.870883),
                    new LatLng(15.233712, 104.870236),
                    new LatLng(15.233771, 104.870177),
                    new LatLng(15.235957, 104.869674),
                    new LatLng(15.235865, 104.868028),
                    new LatLng(15.235728, 104.865255),
                    new LatLng(15.235730, 104.864500),
                    new LatLng(15.235652, 104.862382),
                    new LatLng(15.235668, 104.860683),
                    new LatLng(15.235716, 104.859292),
                    new LatLng(15.235766, 104.857392),
                    new LatLng(15.235745, 104.855891),
                    new LatLng(15.235699, 104.854467),//โรงแรมรายทอง
                    new LatLng(15.235699, 104.852510),
                    new LatLng(15.235867, 104.850656),
                    new LatLng(15.236395, 104.846889),
                    new LatLng(15.236429, 104.846874),
                    new LatLng(15.237183, 104.846904),
                    new LatLng(15.237584, 104.846912),
                    new LatLng(15.240080, 104.847049),
                    new LatLng(15.242893, 104.847257),
                    new LatLng(15.244769, 104.847360),//หอนาฬิกา
                    new LatLng(15.244806, 104.847351),
                    new LatLng(15.257914, 104.831318),
                    new LatLng(15.258995, 104.831706),
                    new LatLng(15.259160, 104.831646),
                    new LatLng(15.259325, 104.831700),
                    new LatLng(15.261605, 104.832404),
                    new LatLng(15.261989, 104.832552),
                    new LatLng(15.263146, 104.833007),
                    new LatLng(15.269653, 104.835208),
                    new LatLng(15.270442, 104.835627),
                    new LatLng(15.271012, 104.836072),
                    new LatLng(15.271546, 104.836614),
                    new LatLng(15.271853, 104.837040),
                    new LatLng(15.272170, 104.837444),
                    new LatLng(15.272570, 104.837182)

                    ).color(Color.BLUE)
            );

        } else if (getBusID.equalsIgnoreCase("BUS2")) {
            //สาย 2 เขียวเข้ม
            //Mark place of way number3
            // สถานีรถไฟอุบลราชธานี
            LatLng b0 = new LatLng(15.200409, 104.858653);
            mMap.addMarker(new MarkerOptions().position(b0).title("สถานีรถไฟอุบลราชธานี").icon(BitmapDescriptorFactory.fromBitmap(smallMarkerStart)));
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(b0,12));
            //ทุ่งน้ำแซบ
            LatLng b1 = new LatLng(15.199573, 104.860519);
            mMap.addMarker(new MarkerOptions().position(b1).title("ทุ่งน้ำแซบ").icon(BitmapDescriptorFactory.fromBitmap(smallMarkerPass)));
            mMap.moveCamera(CameraUpdateFactory.newLatLng(b1));
            //ไปรษณีย์วารินชำราบ
            LatLng b2 = new LatLng(15.201642, 104.864259);
            mMap.addMarker(new MarkerOptions().position(b2).title("ไปรษณีย์วารินชำราบ ").icon(BitmapDescriptorFactory.fromBitmap(smallMarkerPass)));
            mMap.moveCamera(CameraUpdateFactory.newLatLng(b2));
            //map อุบลวัสดุ
            LatLng b3 = new LatLng(15.212742, 104.860670);
            mMap.addMarker(new MarkerOptions().position(b3).title("อุบลวัสดุ").icon(BitmapDescriptorFactory.fromBitmap(smallMarkerPass)));
            mMap.moveCamera(CameraUpdateFactory.newLatLng(b3));
            //map ตลาดใหญ่
            LatLng b4 = new LatLng(15.224811, 104.858792);
            mMap.addMarker(new MarkerOptions().position(b4).title("ตลาดใหญ่").icon(BitmapDescriptorFactory.fromBitmap(smallMarkerPass)));
            mMap.moveCamera(CameraUpdateFactory.newLatLng(b4));
            //วัดทุ่งศรีเมือง
            LatLng b5 = new LatLng(15.230283, 104.861050);
            mMap.addMarker(new MarkerOptions().position(b5).title("วัดทุ่งศรีเมือง ").icon(BitmapDescriptorFactory.fromBitmap(smallMarkerPass)));
            mMap.moveCamera(CameraUpdateFactory.newLatLng(b5));
            //วัดมหาวนาราม
            LatLng b6 = new LatLng(15.234947, 104.863388);
            mMap.addMarker(new MarkerOptions().position(b6).title("วัดมหาวนาราม ").icon(BitmapDescriptorFactory.fromBitmap(smallMarkerPass)));
            mMap.moveCamera(CameraUpdateFactory.newLatLng(b6));
            //สถานีตำรวจภูธรเมืองอุบลราชธานี
            LatLng b7 = new LatLng(15.236549, 104.862957);
            mMap.addMarker(new MarkerOptions().position(b7).title("สถานีตำรวจภูธรเมืองอุบลราชธานี").icon(BitmapDescriptorFactory.fromBitmap(smallMarkerPass)));
            mMap.moveCamera(CameraUpdateFactory.newLatLng(b7));
            //วัดแจ้ง
            LatLng b8 = new LatLng(15.237007, 104.859845);
            mMap.addMarker(new MarkerOptions().position(b8).title("วัดแจ้ง").icon(BitmapDescriptorFactory.fromBitmap(smallMarkerPass)));
            mMap.moveCamera(CameraUpdateFactory.newLatLng(b8));
            //โรบินสันยิ่งยง
            LatLng b9 = new LatLng(15.240893, 104.852227);
            mMap.addMarker(new MarkerOptions().position(b9).title("โรบินสันยิ่งยง").icon(BitmapDescriptorFactory.fromBitmap(smallMarkerPass)));
            mMap.moveCamera(CameraUpdateFactory.newLatLng(b9));
            //โรงแรมปทุมรัตน์
            LatLng b10 = new LatLng(15.243255, 104.851156);
            mMap.addMarker(new MarkerOptions().position(b10).title("โรงแรมปทุมรัตน์").icon(BitmapDescriptorFactory.fromBitmap(smallMarkerPass)));
            mMap.moveCamera(CameraUpdateFactory.newLatLng(b10));
            //โรงแรมเนวด้า
            LatLng b11 = new LatLng(15.247163, 104.852166);
            mMap.addMarker(new MarkerOptions().position(b11).title("โรงแรมเนวด้า").icon(BitmapDescriptorFactory.fromBitmap(smallMarkerPass)));
            mMap.moveCamera(CameraUpdateFactory.newLatLng(b11));
            //โลตัส
            LatLng b12 = new LatLng(15.252894, 104.849916);
            mMap.addMarker(new MarkerOptions().position(b12).title("โลตัส อุบลราชธานี").icon(BitmapDescriptorFactory.fromBitmap(smallMarkerPass)));
            mMap.moveCamera(CameraUpdateFactory.newLatLng(b12));
            //โรงเรียนอัสสัมชัญอุบลราชธานี
            LatLng b13 = new LatLng(15.254174, 104.848946);
            mMap.addMarker(new MarkerOptions().position(b13).title("โรงเรียนอัสสัมชัญอุบลราชธานี").icon(BitmapDescriptorFactory.fromBitmap(smallMarkerPass)));
            mMap.moveCamera(CameraUpdateFactory.newLatLng(b13));
            //สุนีย์แกรนด์
            LatLng b14 = new LatLng(15.256326, 104.848179);
            mMap.addMarker(new MarkerOptions().position(b14).title("สุนีย์แกรนด์ ").icon(BitmapDescriptorFactory.fromBitmap(smallMarkerPass)));
            mMap.moveCamera(CameraUpdateFactory.newLatLng(b14));
            //อุบลสแควร์
            LatLng b15 = new LatLng(15.269197, 104.840414);
            mMap.addMarker(new MarkerOptions().position(b15).title("อุบลสแควร์ ").icon(BitmapDescriptorFactory.fromBitmap(smallMarkerPass)));
            mMap.moveCamera(CameraUpdateFactory.newLatLng(b15));
            //บิ๊กซีอุบล
            LatLng b16 = new LatLng(15.270484, 104.839998);
            mMap.addMarker(new MarkerOptions().position(b16).title("บิ๊กซีอุบล").icon(BitmapDescriptorFactory.fromBitmap(smallMarkerPass)));
            mMap.moveCamera(CameraUpdateFactory.newLatLng(b16));
            //วัดหนองบัว
            LatLng b17 = new LatLng(15.263319, 104.839018);
            mMap.addMarker(new MarkerOptions().position(b17).title("วัดหนองบัว").icon(BitmapDescriptorFactory.fromBitmap(smallMarkerPass)));
            mMap.moveCamera(CameraUpdateFactory.newLatLng(b17));
            //สถานีขนส่งอุบลราชธานี
            LatLng b18 = new LatLng(15.272656, 104.837359);
            mMap.addMarker(new MarkerOptions().position(b18).title("สถานีขนส่งอุบลราชธานี").icon(BitmapDescriptorFactory.fromBitmap(smallMarkerStop)));
            mMap.moveCamera(CameraUpdateFactory.newLatLng(b18));

            //Mark line at way bus pass

            mMap.addPolyline(new PolylineOptions().add(
                    new LatLng(15.200325, 104.858755),
                    new LatLng(15.199729, 104.859238),
                    new LatLng(15.198937, 104.861404),
                    new LatLng(15.200350, 104.861787),
                    new LatLng(15.201772, 104.862137),
                    new LatLng(15.201989, 104.862124),
                    new LatLng(15.203072, 104.862698),
                    new LatLng(15.204720, 104.863722),
                    new LatLng(15.205218, 104.863911),
                    new LatLng(15.205663, 104.864009),
                    new LatLng(15.205738, 104.864001),
                    new LatLng(15.209110, 104.863683),
                    new LatLng(15.209355, 104.863627),
                    new LatLng(15.209526, 104.863567),
                    new LatLng(15.209596, 104.863521),
                    new LatLng(15.210058, 104.863239),
                    new LatLng(15.215127, 104.858428),
                    new LatLng(15.215681, 104.857930),
                    new LatLng(15.216246, 104.857609),
                    new LatLng(15.216789, 104.857373),
                    new LatLng(15.217297, 104.857241),
                    new LatLng(15.217840, 104.857161),
                    new LatLng(15.218392, 104.857138),
                    new LatLng(15.221850, 104.857284),
                    new LatLng(15.223123, 104.857298),
                    new LatLng(15.224043, 104.857370),
                    new LatLng(15.225045, 104.857364),
                    new LatLng(15.225658, 104.857345),
                    new LatLng(15.225872, 104.858254),
                    new LatLng(15.225976, 104.858614),
                    new LatLng(15.226040, 104.859051),
                    new LatLng(15.226098, 104.859833),
                    new LatLng(15.226092, 104.860465),
                    new LatLng(15.227585, 104.860473),
                    new LatLng(15.227662, 104.860439),
                    new LatLng(15.227656, 104.860580),
                    new LatLng(15.227634, 104.860718),
                    new LatLng(15.227668, 104.861197),
                    new LatLng(15.228651, 104.861190),
                    new LatLng(15.228719, 104.861189),
                    new LatLng(15.228687, 104.861280),
                    new LatLng(15.228731, 104.861408),//
                    new LatLng(15.229652, 104.861708),
                    new LatLng(15.230817, 104.862159),
                    new LatLng(15.230986, 104.862259),
                    new LatLng(15.231596, 104.862487),
                    new LatLng(15.233093, 104.862951),
                    new LatLng(15.233204, 104.863720),
                    new LatLng(15.233242, 104.864145),
                    new LatLng(15.233295, 104.864680),
                    new LatLng(15.234484, 104.864612),
                    new LatLng(15.235738, 104.864500),
                    new LatLng(15.235694, 104.863335),
                    new LatLng(15.235640, 104.862359),
                    new LatLng(15.235666, 104.860686),
                    new LatLng(15.235718, 104.859302),
                    new LatLng(15.235759, 104.857390),
                    new LatLng(15.235772, 104.856902),
                    new LatLng(15.235736, 104.855904),
                    new LatLng(15.235700, 104.854474),
                    new LatLng(15.237625, 104.853861),
                    new LatLng(15.237770, 104.853786),
                    new LatLng(15.238861, 104.853394),
                    new LatLng(15.239790, 104.853102),
                    new LatLng(15.241897, 104.852387),
                    new LatLng(15.243443, 104.851879),
                    new LatLng(15.245882, 104.851043),
                    new LatLng(15.254421, 104.848153),
                    new LatLng(15.256050, 104.847631),
                    new LatLng(15.256364, 104.847524),
                    new LatLng(15.256609, 104.847424),
                    new LatLng(15.256849, 104.847347),
                    new LatLng(15.257545, 104.847108),
                    new LatLng(15.262583, 104.845399),
                    new LatLng(15.264963, 104.844595),
                    new LatLng(15.266592, 104.844047),
                    new LatLng(15.267192, 104.843861),
                    new LatLng(15.268354, 104.843465),
                    new LatLng(15.269502, 104.843059),
                    new LatLng(15.272336, 104.842083),
                    new LatLng(15.273194, 104.841846),
                    new LatLng(15.273976, 104.841547),
                    new LatLng(15.274088, 104.841316),
                    new LatLng(15.274185, 104.841131),
                    new LatLng(15.274190, 104.840966),
                    new LatLng(15.274187, 104.840778),
                    new LatLng(15.274204, 104.840680),
                    new LatLng(15.273486, 104.839724),
                    new LatLng(15.273098, 104.839191),
                    new LatLng(15.273042, 104.839114),
                    new LatLng(15.272337, 104.838204),
                    new LatLng(15.272012, 104.837758),
                    new LatLng(15.271003, 104.836491),
                    new LatLng(15.270459, 104.835995),
                    new LatLng(15.269845, 104.835625),
                    new LatLng(15.268067, 104.834936),
                    new LatLng(15.266766, 104.834498),
                    new LatLng(15.266812, 104.834338),
                    new LatLng(15.267791, 104.834672),
                    new LatLng(15.267837, 104.834591),
                    new LatLng(15.269638, 104.835219),
                    new LatLng(15.270370, 104.835586),
                    new LatLng(15.270916, 104.835988),
                    new LatLng(15.271287, 104.836355),
                    new LatLng(15.271699, 104.836830),
                    new LatLng(15.272164, 104.837443),
                    new LatLng(15.272635, 104.837140)


                    ).color(Color.GREEN)
            );
        } else if (getBusID.equalsIgnoreCase("BUS3")) {
            //สาย 3 ชมพู
            //add mark in map
            //บ้านก่อ
            LatLng c1 = new LatLng(15.163233, 104.854693);
            mMap.addMarker(new MarkerOptions().position(c1).title("บ้านก่อ").icon(BitmapDescriptorFactory.fromBitmap(smallMarkerStart)));
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(c1,12));
            //บิ๊กซีวารินชำราบ
            LatLng c2 = new LatLng(15.165549, 104.8540740);
            mMap.addMarker(new MarkerOptions().position(c2).title("บิ๊กซีวารินชำราบ").icon(BitmapDescriptorFactory.fromBitmap(smallMarkerPass)));
            mMap.moveCamera(CameraUpdateFactory.newLatLng(c2));
            //โลตัสวารินชำราบ
            LatLng c3 = new LatLng(15.181694, 104.856456);
            mMap.addMarker(new MarkerOptions().position(c3).title("โลตัสวารินชำราบ").icon(BitmapDescriptorFactory.fromBitmap(smallMarkerPass)));
            mMap.moveCamera(CameraUpdateFactory.newLatLng(c3));
            //ทุ่งน้ำแซบ
            LatLng c4 = new LatLng(15.199567, 104.860524);
            mMap.addMarker(new MarkerOptions().position(c4).title("ทุ่งน้ำแซบ").icon(BitmapDescriptorFactory.fromBitmap(smallMarkerPass)));
            mMap.moveCamera(CameraUpdateFactory.newLatLng(c4));
            //map อุบลวัสดุ
            LatLng c5 = new LatLng(15.212742, 104.860670);
            mMap.addMarker(new MarkerOptions().position(c5).title("อุบลวัสดุ").icon(BitmapDescriptorFactory.fromBitmap(smallMarkerPass)));
            mMap.moveCamera(CameraUpdateFactory.newLatLng(c5));
            //map ตลาดใหญ่
            LatLng c6 = new LatLng(15.224811, 104.858792);
            mMap.addMarker(new MarkerOptions().position(c6).title("ตลาดใหญ่").icon(BitmapDescriptorFactory.fromBitmap(smallMarkerPass)));
            mMap.moveCamera(CameraUpdateFactory.newLatLng(c6));
            //วัดมหาวนาราม
            LatLng c7 = new LatLng(15.235133, 104.863377);
            mMap.addMarker(new MarkerOptions().position(c7).title("วัดมหาวนาราม ").icon(BitmapDescriptorFactory.fromBitmap(smallMarkerPass)));
            mMap.moveCamera(CameraUpdateFactory.newLatLng(c7));
            //โรงเรียนอุบลวิทยาคม
            LatLng c8 = new LatLng(15.235404, 104.856671);
            mMap.addMarker(new MarkerOptions().position(c8).title("โรงเรียนอุบลวิทยาคม ").icon(BitmapDescriptorFactory.fromBitmap(smallMarkerPass)));
            mMap.moveCamera(CameraUpdateFactory.newLatLng(c8));
            //โรบินสันยิ่งยง
            LatLng c9 = new LatLng(15.240893, 104.852227);
            mMap.addMarker(new MarkerOptions().position(c9).title("โรบินสันยิ่งยง").icon(BitmapDescriptorFactory.fromBitmap(smallMarkerPass)));
            mMap.moveCamera(CameraUpdateFactory.newLatLng(c9));
            //โรงแรมปทุมรัตน์
            LatLng c10 = new LatLng(15.243255, 104.851156);
            mMap.addMarker(new MarkerOptions().position(c10).title("โรงแรมปทุมรัตน์").icon(BitmapDescriptorFactory.fromBitmap(smallMarkerPass)));
            mMap.moveCamera(CameraUpdateFactory.newLatLng(c10));
            //โรงแรมเนวด้า
            LatLng c11 = new LatLng(15.247163, 104.852166);
            mMap.addMarker(new MarkerOptions().position(c11).title("โรงแรมเนวด้า").icon(BitmapDescriptorFactory.fromBitmap(smallMarkerPass)));
            mMap.moveCamera(CameraUpdateFactory.newLatLng(c11));
            //โลตัส
            LatLng c12 = new LatLng(15.252894, 104.849916);
            mMap.addMarker(new MarkerOptions().position(c12).title("โลตัส อุบลราชธานี").icon(BitmapDescriptorFactory.fromBitmap(smallMarkerPass)));
            mMap.moveCamera(CameraUpdateFactory.newLatLng(c12));
            //โรงเรียนอัสสัมชัญอุบลราชธานี
            LatLng c13 = new LatLng(15.254174, 104.848946);
            mMap.addMarker(new MarkerOptions().position(c13).title("โรงเรียนอัสสัมชัญอุบลราชธานี").icon(BitmapDescriptorFactory.fromBitmap(smallMarkerPass)));
            mMap.moveCamera(CameraUpdateFactory.newLatLng(c13));
            //สุนีย์แกรนด์
            LatLng c14 = new LatLng(15.256326, 104.848179);
            mMap.addMarker(new MarkerOptions().position(c14).title("สุนีย์แกรนด์ ").icon(BitmapDescriptorFactory.fromBitmap(smallMarkerPass)));
            mMap.moveCamera(CameraUpdateFactory.newLatLng(c14));
            //อุบลสแควร์
            LatLng c15 = new LatLng(15.269197, 104.840414);
            mMap.addMarker(new MarkerOptions().position(c15).title("อุบลสแควร์ ").icon(BitmapDescriptorFactory.fromBitmap(smallMarkerPass)));
            mMap.moveCamera(CameraUpdateFactory.newLatLng(c15));
            //บิ๊กซีอุบล
            LatLng c16 = new LatLng(15.270484, 104.839998);
            mMap.addMarker(new MarkerOptions().position(c16).title("บิ๊กซีอุบล").icon(BitmapDescriptorFactory.fromBitmap(smallMarkerPass)));
            mMap.moveCamera(CameraUpdateFactory.newLatLng(c16));
            //วัดหนองบัว
            LatLng c17 = new LatLng(15.263319, 104.839018);
            mMap.addMarker(new MarkerOptions().position(c17).title("วัดหนองบัว").icon(BitmapDescriptorFactory.fromBitmap(smallMarkerPass)));
            mMap.moveCamera(CameraUpdateFactory.newLatLng(c17));
            //สถานีขนส่งอุบลราชธานี
            LatLng c18 = new LatLng(15.272656, 104.837359);
            mMap.addMarker(new MarkerOptions().position(c18).title("สถานีขนส่งอุบลราชธานี").icon(BitmapDescriptorFactory.fromBitmap(smallMarkerStop)));
            mMap.moveCamera(CameraUpdateFactory.newLatLng(c18));
            //U-Park
            LatLng c19 = new LatLng(15.278212, 104.841197);
            mMap.addMarker(new MarkerOptions().position(c19).title("U-Park"));
            mMap.moveCamera(CameraUpdateFactory.newLatLng(c19));
            //เทคโนโลยีอาชีวศึกษาอุบลราชธานี
            LatLng c20 = new LatLng(15.288274, 104.846519);
            mMap.addMarker(new MarkerOptions().position(c20).title("เทคโนโลยีอาชีวศึกษาอุบลราชธานี"));
            mMap.moveCamera(CameraUpdateFactory.newLatLng(c20));

            //add line in way at bus pass
            mMap.addPolyline(new PolylineOptions().add(
                    new LatLng(15.160290, 104.854163),
                    new LatLng(15.163463, 104.854994),
                    new LatLng(15.165864, 104.855593),
                    new LatLng(15.167721, 104.856042),
                    new LatLng(15.169764, 104.856574),
                    new LatLng(15.171607, 104.856981),
                    new LatLng(15.173102, 104.857181),
                    new LatLng(15.174520, 104.857234),
                    new LatLng(15.175816, 104.857370),
                    new LatLng(15.176925, 104.857387),
                    new LatLng(15.178934, 104.857577),
                    new LatLng(15.180003, 104.857714),
                    new LatLng(15.181339, 104.858016),
                    new LatLng(15.182026, 104.858192),
                    new LatLng(15.182140, 104.858258),
                    new LatLng(15.183268, 104.858473),
                    new LatLng(15.185016, 104.858866),
                    new LatLng(15.186425, 104.859161),
                    new LatLng(15.188044, 104.859497),
                    new LatLng(15.188999, 104.859692),
                    new LatLng(15.189712, 104.859888),
                    new LatLng(15.190530, 104.860021),
                    new LatLng(15.191799, 104.860421),
                    new LatLng(15.193609, 104.861006),
                    new LatLng(15.194580, 104.861405),
                    new LatLng(15.196062, 104.861893),
                    new LatLng(15.198532, 104.862835),
                    new LatLng(15.198952, 104.861389),
                    new LatLng(15.200339, 104.861782),
                    new LatLng(15.201783, 104.862137),
                    new LatLng(15.202015, 104.862131),
                    new LatLng(15.203099, 104.862720),
                    new LatLng(15.204692, 104.863698),
                    new LatLng(15.205111, 104.863875),
                    new LatLng(15.205749, 104.864005),
                    new LatLng(15.209335, 104.863636),
                    new LatLng(15.209655, 104.863497),
                    new LatLng(15.210107, 104.863197),
                    new LatLng(15.215671, 104.857935),
                    new LatLng(15.216319, 104.857570),
                    new LatLng(15.217006, 104.857297),
                    new LatLng(15.217700, 104.857167),
                    new LatLng(15.218454, 104.857138),
                    new LatLng(15.222799, 104.857310),
                    new LatLng(15.223938, 104.857348),
                    new LatLng(15.224824, 104.857357),
                    new LatLng(15.225137, 104.857379),//ตลาดใหญ่
                    new LatLng(15.225653, 104.857332),
                    new LatLng(15.225956, 104.858496),
                    new LatLng(15.226051, 104.859090),
                    new LatLng(15.226106, 104.860153),
                    new LatLng(15.226086, 104.861362),
                    new LatLng(15.227673, 104.861205),
                    new LatLng(15.228717, 104.861178),
                    new LatLng(15.228685, 104.861278),
                    new LatLng(15.228732, 104.861401),
                    new LatLng(15.228740, 104.861883),
                    new LatLng(15.228840, 104.863453),
                    new LatLng(15.228895, 104.865026),
                    new LatLng(15.231895, 104.864795),
                    new LatLng(15.233303, 104.864677),
                    new LatLng(15.234542, 104.864615),
                    new LatLng(15.235738, 104.864505),
                    new LatLng(15.235642, 104.862381),
                    new LatLng(15.235676, 104.860391),
                    new LatLng(15.235746, 104.858366),
                    new LatLng(15.235777, 104.857357),
                    new LatLng(15.235779, 104.856832),
                    new LatLng(15.235704, 104.854468),
                    new LatLng(15.237642, 104.853856),
                    new LatLng(15.238949, 104.853338),
                    new LatLng(15.240737, 104.852779),
                    new LatLng(15.245924, 104.851024),
                    new LatLng(15.252223, 104.848904),
                    new LatLng(15.256603, 104.847419),
                    new LatLng(15.259251, 104.846544),
                    new LatLng(15.263285, 104.845177),
                    new LatLng(15.265648, 104.844381),
                    new LatLng(15.269866, 104.842951),
                    new LatLng(15.272355, 104.842093),
                    new LatLng(15.273954, 104.841543),//แยกอำนาจ
                    new LatLng(15.274088, 104.841316),
                    new LatLng(15.274185, 104.841131),
                    new LatLng(15.274190, 104.840966),
                    new LatLng(15.274187, 104.840778),
                    new LatLng(15.274204, 104.840680),
                    new LatLng(15.273486, 104.839724),
                    new LatLng(15.273098, 104.839191),
                    new LatLng(15.273042, 104.839114),
                    new LatLng(15.272337, 104.838204),
                    new LatLng(15.272012, 104.837758),
                    new LatLng(15.271003, 104.836491),
                    new LatLng(15.270459, 104.835995),
                    new LatLng(15.269845, 104.835625),
                    new LatLng(15.268067, 104.834936),
                    new LatLng(15.266766, 104.834498),
                    new LatLng(15.266812, 104.834338),
                    new LatLng(15.267791, 104.834672),
                    new LatLng(15.267837, 104.834591),
                    new LatLng(15.269638, 104.835219),
                    new LatLng(15.270370, 104.835586),
                    new LatLng(15.270916, 104.835988),
                    new LatLng(15.271287, 104.836355),
                    new LatLng(15.271699, 104.836830),
                    new LatLng(15.272164, 104.837443),
                    new LatLng(15.272375, 104.837287),
                    new LatLng(15.272611, 104.837663),
                    new LatLng(15.272430, 104.837822),
                    new LatLng(15.273032, 104.838650),
                    new LatLng(15.273725, 104.839538),
                    new LatLng(15.274113, 104.840045),
                    new LatLng(15.274851, 104.840929),
                    new LatLng(15.275634, 104.841028),
                    new LatLng(15.278649, 104.840024),
                    new LatLng(15.280130, 104.839515),
                    new LatLng(15.280950, 104.839233),
                    new LatLng(15.283102, 104.838487),
                    new LatLng(15.284115, 104.838155),
                    new LatLng(15.284527, 104.838030),
                    new LatLng(15.285126, 104.837930),
                    new LatLng(15.286013, 104.837891),
                    new LatLng(15.286415, 104.837876),
                    new LatLng(15.286405, 104.838011),
                    new LatLng(15.285906, 104.837987),
                    new LatLng(15.285087, 104.838039),
                    new LatLng(15.284687, 104.838101),
                    new LatLng(15.284267, 104.838250),
                    new LatLng(15.284397, 104.839237),
                    new LatLng(15.284681, 104.841772),
                    new LatLng(15.284706, 104.842192),
                    new LatLng(15.284614, 104.842607),
                    new LatLng(15.284564, 104.843180),
                    new LatLng(15.284760, 104.844884),
                    new LatLng(15.284844, 104.845673),
                    new LatLng(15.285073, 104.846985),
                    new LatLng(15.285076, 104.847665)

                    ).color(Color.parseColor("#ff6a80"))
            );
            //สาย 3 ชมพู

        } else if (getBusID.equalsIgnoreCase("BUS4")) {
            bus_title = getResources().getStringArray(R.array.BUS4);
        } else if (getBusID.equalsIgnoreCase("BUS5")) {
            bus_title = getResources().getStringArray(R.array.BUS5);
        } else if (getBusID.equalsIgnoreCase("BUS6")) {
            bus_title = getResources().getStringArray(R.array.BUS6);
        } else if (getBusID.equalsIgnoreCase("BUS7")) {
            bus_title = getResources().getStringArray(R.array.BUS7);
        } else if (getBusID.equalsIgnoreCase("BUS8")) {
            bus_title = getResources().getStringArray(R.array.BUS8);
        } else if (getBusID.equalsIgnoreCase("BUS9")) {
            bus_title = getResources().getStringArray(R.array.BUS9);
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()){
            case android.R.id.home:
               finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
