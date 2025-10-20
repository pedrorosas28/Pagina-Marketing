package com.example.hotellopesan

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.google.android.material.button.MaterialButton

class MapActivity : AppCompatActivity(), OnMapReadyCallback {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_map)

        val mapFragment = supportFragmentManager.findFragmentById(R.id.mapFragment) as? SupportMapFragment
        mapFragment?.getMapAsync(this)

        findViewById<MaterialButton>(R.id.openMapsAppButton).setOnClickListener {
            openInGoogleMaps()
        }
    }

    override fun onMapReady(map: GoogleMap) {
        val hotelLocation = LatLng(HOTEL_LATITUDE, HOTEL_LONGITUDE)
        map.uiSettings.apply {
            isZoomControlsEnabled = true
            isMapToolbarEnabled = true
        }
        map.moveCamera(CameraUpdateFactory.newLatLngZoom(hotelLocation, 17f))
        map.addMarker(
            MarkerOptions()
                .position(hotelLocation)
                .title(getString(R.string.hotel_map_marker_title))
        )
    }

    private fun openInGoogleMaps() {
        val hotelLabel = getString(R.string.hotel_map_marker_title)
        val geoUri = Uri.parse("geo:$HOTEL_LATITUDE,$HOTEL_LONGITUDE?q=${Uri.encode(hotelLabel)}")
        val mapsIntent = Intent(Intent.ACTION_VIEW, geoUri).apply {
            setPackage("com.google.android.apps.maps")
        }

        if (mapsIntent.resolveActivity(packageManager) != null) {
            startActivity(mapsIntent)
        } else {
            val browserUri = Uri.parse("https://www.google.com/maps/search/?api=1&query=$HOTEL_LATITUDE,$HOTEL_LONGITUDE")
            startActivity(Intent(Intent.ACTION_VIEW, browserUri))
        }
    }

    companion object {
        private const val HOTEL_LATITUDE = 27.7359
        private const val HOTEL_LONGITUDE = -15.5980
    }
}
