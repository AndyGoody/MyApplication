package com.startiasoft.googlemap;

import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.util.Log;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.GoogleMapOptions;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.GroundOverlayOptions;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.Polyline;
import com.google.android.gms.maps.model.PolylineOptions;

public class MapsActivity extends FragmentActivity {

    private GoogleMap mMap; // Might be null if Google Play services APK is not available.

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);


        // LatLng target, float zoom, float tilt, float bearing

        setUpMapIfNeeded();

//        MapFragment.newInstance(options);
//        cameraTargetLat
//        mMap.setLocationSource();


//        LatLngBounds newarkBounds = new LatLngBounds(
//                new LatLng(40.712216, -74.22655),       // South west corner
//                new LatLng(40.773941, -74.12544));      // North east corner
//        GroundOverlayOptions newarkMap = new GroundOverlayOptions()
//                .image(BitmapDescriptorFactory.fromResource(R.drawable.cast_ic_notification_2))
//                .positionFromBounds(newarkBounds);
//
//
//        Polyline line = mMap.addPolyline(new PolylineOptions()
//                .add(new LatLng(-37.81319, 144.96298), new LatLng(-31.95285, 115.85734))
//                .width(25)
//                .color(Color.BLUE)
//                .geodesic(true));
//
//
//        PolylineOptions rectOptions = new PolylineOptions()
//                .add(new LatLng(-34.35, 155))
//                .add(new LatLng(-34.45, 155))  // North of the previous point, but at the same longitude
//                .add(new LatLng(-34.45, 155.2))  // Same latitude, and 30km to the west
//                .add(new LatLng(-34.35, 155.2))  // Same longitude, and 16km to the south
//                .add(new LatLng(-34.35, 155.0)); // Closes the polyline.
// Get back the mutable Polyline
//        Polyline polyline = mMap.addPolyline(rectOptions);
        mMap.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
            @Override
            public boolean onMarkerClick(Marker marker) {
//                marker.setTitle("ABC");
                Log.i("lipan", "id : " + marker.getId());


                return false;
            }
        });

        mMap.setOnMapClickListener(new GoogleMap.OnMapClickListener() {


            @Override
            public void onMapClick(LatLng latLng) {
                Log.i("lipan", "dsd" + latLng.toString());
                mMap.addMarker(new MarkerOptions().position(new LatLng(latLng.latitude, latLng.longitude))
                                .title("Marker")
                                .icon(BitmapDescriptorFactory.defaultMarker(290)
                                )
                );
            }
        });

    }

    @Override
    protected void onResume() {
        super.onResume();
        setUpMapIfNeeded();
    }

    /**
     * Sets up the map if it is possible to do so (i.e., the Google Play services APK is correctly
     * installed) and the map has not already been instantiated.. This will ensure that we only ever
     * call {@link #setUpMap()} once when {@link #mMap} is not null.
     * <p/>
     * If it isn't installed {@link SupportMapFragment} (and
     * {@link com.google.android.gms.maps.MapView MapView}) will show a prompt for the user to
     * install/update the Google Play services APK on their device.
     * <p/>
     * A user can return to this FragmentActivity after following the prompt and correctly
     * installing/updating/enabling the Google Play services. Since the FragmentActivity may not
     * have been completely destroyed during this process (it is likely that it would only be
     * stopped or paused), {@link #onCreate(Bundle)} may not be called again so we should call this
     * method in {@link #onResume()} to guarantee that it will be called.
     */
    private void setUpMapIfNeeded() {
        // Do a null check to confirm that we have not already instantiated the map.
        if (mMap == null) {
            // Try to obtain the map from the SupportMapFragment.

            mMap = ((SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map))
                    .getMap();

            mMap.setMyLocationEnabled(true);
//            LatLng latLng = new LatLng(-35, 152);
            LatLng latLng = new LatLng(34.195022, 108.887694);
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng, 14));


            // Check if we were successful in obtaining the map.
            if (mMap != null) {
                setUpMap();
            }
        }
    }

    /**
     * This is where we can add markers or lines, add listeners or move the camera. In this case, we
     * just add a marker near Africa.
     * <p/>
     * This should only be called once and when we are sure that {@link #mMap} is not null.
     */
    private void setUpMap() {
//        mMap.addMarker(new MarkerOptions().position(new LatLng(-34, 151)).title("Marker").icon(BitmapDescriptorFactory.defaultMarker(240)));
        MarkerOptions sdsd = new MarkerOptions().position(new LatLng(34.1982218, 108.8826048)).
                title("都市之门B座11201").icon(BitmapDescriptorFactory.defaultMarker(130)).snippet("大家好");


        mMap.addMarker(sdsd);
        mMap.addMarker(new MarkerOptions().position(new LatLng(34.195022, 108.887694)).
                title("都市之门B座11202").icon(BitmapDescriptorFactory.defaultMarker(30)));
        mMap.addMarker(new MarkerOptions().position(new LatLng(34.199022, 108.897694)).
                title("都市之门B座11203").icon(BitmapDescriptorFactory.defaultMarker(30)));
        mMap.addMarker(new MarkerOptions().position(new LatLng(34.192022, 108.857694)).
                title("都市之门B座11204").icon(BitmapDescriptorFactory.defaultMarker(30)));
//        mMap.addMarker(new MarkerOptions().position(new LatLng(-35, 152)).title("Markerdsd").icon(BitmapDescriptorFactory.defaultMarker(240)));
//        mMap.addMarker(new MarkerOptions().position(new LatLng(-35.1, 152.2)).title("Markerd1").icon(BitmapDescriptorFactory.defaultMarker(240)));
//        mMap.addMarker(new MarkerOptions().position(new LatLng(-35.2, 152.1)).title("Markerd2").icon(BitmapDescriptorFactory.defaultMarker(240)));
//        mMap.addMarker(new MarkerOptions().position(new LatLng(40.712216, -74.22655)).title("Markerd2").icon(BitmapDescriptorFactory.defaultMarker(240)));
    }
}
