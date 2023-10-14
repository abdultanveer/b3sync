package com.example.b3sync

import android.Manifest
import android.annotation.SuppressLint
import android.content.pm.PackageManager
import android.location.Location
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Looper
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.core.app.ActivityCompat
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationCallback
import com.google.android.gms.location.LocationRequest
import com.google.android.gms.location.LocationResult
import com.google.android.gms.location.LocationServices
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class LocationActivity : AppCompatActivity() {
    val TAG = LocationActivity::class.java.simpleName

    val db = Firebase.firestore
    private lateinit var fusedLocationClient: FusedLocationProviderClient
    lateinit var tvLocation:TextView
    lateinit var tvLocationUpdates:TextView

    lateinit var btnLocation:Button
    lateinit var btnSend : Button
    lateinit var btnGet: Button
    private lateinit var locationCallback: LocationCallback
    var requestingLocationUpdates : Boolean = false
    lateinit var  locationRequest : LocationRequest


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_location)
        tvLocation = findViewById(R.id.tvLocation)
        tvLocationUpdates = findViewById(R.id.tvLocationUpdates)

        btnLocation = findViewById(R.id.btnLocation)
        btnSend = findViewById(R.id.btnSend)
        btnGet = findViewById(R.id.btnGet)
        btnSend.setOnClickListener { sendDataFireStore() }
        btnGet.setOnClickListener { getDataFireStore() }

        fusedLocationClient = LocationServices.getFusedLocationProviderClient(this)
        btnLocation.setOnClickListener { getLocation() }

        locationCallback = object  :LocationCallback(){
            override fun onLocationResult(locationResult: LocationResult) {
                locationResult ?: return
                for (location in locationResult.locations){
                    tvLocationUpdates.setText("lat ="+location.latitude+"\nlong ="+location.longitude+"\naltitude ="+location.altitude)

                }
            }
        }



    }

    private fun getDataFireStore() {
        db.collection("users")
            .get()
            .addOnSuccessListener { result ->
                for (document in result) {
                    Log.d(TAG, "${document.id} => ${document.data}")
                }
            }
            .addOnFailureListener { exception ->
                Log.w(TAG, "Error getting documents.", exception)
            }
    }

    private fun sendDataFireStore() {
        val user = hashMapOf(
            "first" to "Ada",
            "last" to "Lovelace",
            "born" to 1815
        )

// Add a new document with a generated ID
        db.collection("users")
            .add(user)
            .addOnSuccessListener { documentReference ->
                Log.d(TAG, "DocumentSnapshot added with ID: ${documentReference.id}")
            }
            .addOnFailureListener { e ->
                Log.w(TAG, "Error adding document", e)
            }
    }

    override fun onStart() {
        super.onStart()
        locationRequest = LocationRequest()
    }


    override fun onResume() {
        super.onResume()

        if (requestingLocationUpdates) startLocationUpdates()

    }

    override fun onPause() {
        super.onPause()
        stopLocationUpdates()
    }

    private fun stopLocationUpdates() {
        fusedLocationClient.removeLocationUpdates(locationCallback)
    }

    @SuppressLint("MissingPermission")
    private fun startLocationUpdates() {
        fusedLocationClient.requestLocationUpdates(locationRequest,
            locationCallback,
            Looper.getMainLooper())
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
                  tvLocation.text = "lat = "+location?.latitude.toString() + "\n long = " + location?.longitude + "altitude ="+ location?.altitude
              }
      }
  }
}