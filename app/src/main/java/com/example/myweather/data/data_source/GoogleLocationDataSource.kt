package com.example.myweather.data.data_source

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import android.location.Geocoder
import android.os.Looper
import androidx.core.app.ActivityCompat
import com.example.myweather.data.dto.LocationDataDto
import com.google.android.gms.location.*
import kotlinx.coroutines.suspendCancellableCoroutine
import java.util.*
import kotlin.coroutines.resume

class GoogleLocationDataSource(private val context: Context)  {

    private val fusedClient = LocationServices.getFusedLocationProviderClient(context)

     suspend fun getLocationDetails(): LocationDataDto? = suspendCancellableCoroutine { cont ->

        val request = LocationRequest.Builder(Priority.PRIORITY_HIGH_ACCURACY, 1000L).build()

        val callback = object : LocationCallback() {
            override fun onLocationResult(result: LocationResult) {
                fusedClient.removeLocationUpdates(this)
                val loc = result.lastLocation ?: return cont.resume(null)

                val city = Geocoder(context, Locale.getDefault())
                    .getFromLocation(loc.latitude, loc.longitude, 1)
                    ?.firstOrNull()?.locality

                cont.resume(LocationDataDto(loc.latitude, loc.longitude, city))
            }
        }

        if (ActivityCompat.checkSelfPermission(
                context,
                Manifest.permission.ACCESS_FINE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(
                context,
                Manifest.permission.ACCESS_COARSE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED
        ) {
           throw Exception("there is a problem with permissions")
        }
        fusedClient.requestLocationUpdates(request, callback, Looper.getMainLooper())
        cont.invokeOnCancellation { fusedClient.removeLocationUpdates(callback) }
    }
}
