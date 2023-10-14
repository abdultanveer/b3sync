package com.example.b3sync

import android.Manifest
import android.content.pm.PackageManager
import android.location.Location
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.core.app.ActivityCompat
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices

class LocationActivity : AppCompatActivity() {

    private lateinit var fusedLocationClient: FusedLocationProviderClient
    lateinit var tvLocation:TextView
    lateinit var btnLocation:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_location)
        tvLocation = findViewById(R.id.tvLocation)
        btnLocation = findViewById(R.id.btnLocation)

        fusedLocationClient = LocationServices.getFusedLocationProviderClient(this)
        btnLocation.setOnClickListener { getLocation() }

    }

  fun getLocation(){
      if (ActivityCompat.checkSelfPermission(
              this,
              Manifest.permission.ACCESS_FINE_LOCATION
          ) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(
              this,
              Manifest.permission.ACCESS_COARSE_LOCATION
          ) != PackageManager.PERMISSION_GRANTED
      ) {
          // TODO: Consider calling
          //    ActivityCompat#requestPermissions
          // here to request the missing permissions, and then overriding
          //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
          //                                          int[] grantResults)
          // to handle the case where the user grants the permission. See the documentation
          // for ActivityCompat#requestPermissions for more details.
          return
      } else {
          fusedLocationClient.lastLocation
              .addOnSuccessListener { location: Location? ->
                  tvLocation.text = location?.latitude.toString() + "\n" + location?.longitude
              }
      }
  }
}