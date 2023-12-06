package com.armandorochin.mapsshowcaseapp.ui

import android.Manifest
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.viewModels
import androidx.core.app.ActivityCompat
import com.armandorochin.mapsshowcaseapp.R
import com.armandorochin.mapsshowcaseapp.data.response.RouteResponse
import com.armandorochin.mapsshowcaseapp.databinding.ActivityMainBinding
import com.armandorochin.mapsshowcaseapp.ui.model.RouteCoordenates
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.PolygonOptions
import com.google.android.gms.maps.model.Polyline
import com.google.android.gms.maps.model.PolylineOptions
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Response

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var map:GoogleMap
    private val mainViewModel: MainViewModel by viewModels()
    private var poly:Polyline? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupMap()
        //setupListeners()
    }

    private fun setupListeners() {
        with(binding){
            if(::map.isInitialized){
                map.setOnMapClickListener {
                    if(mainViewModel.coordenates.start.isNullOrEmpty()){
                        mainViewModel.coordenates.start = mainViewModel.coordenates.getCoordenateFormatted(it)
                    }else if (mainViewModel.coordenates.end.isNullOrEmpty()){
                        mainViewModel.coordenates.end = mainViewModel.coordenates.getCoordenateFormatted(it)

                        CoroutineScope(Dispatchers.IO).launch {
                            createRoute(mainViewModel.getRoute())
                        }
                    }else{
                        mainViewModel.coordenates.start = null
                        mainViewModel.coordenates.end = null
                    }
                }
            }
        }
    }

    private fun setupMap() {
        val mapFragment = supportFragmentManager.findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync {googleMap ->
            map = googleMap

            if (ActivityCompat.checkSelfPermission(
                    this,
                    Manifest.permission.ACCESS_FINE_LOCATION
                ) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(
                    this,
                    Manifest.permission.ACCESS_COARSE_LOCATION
                ) != PackageManager.PERMISSION_GRANTED
            ) {
                locationPermissionRequest()
            }
            map.isMyLocationEnabled = true

            if(::map.isInitialized){
                map.setOnMapClickListener {
                    if(mainViewModel.coordenates.start.isNullOrEmpty()){
                        mainViewModel.coordenates.start = mainViewModel.coordenates.getCoordenateFormatted(it)
                    }else if (mainViewModel.coordenates.end.isNullOrEmpty()){
                        mainViewModel.coordenates.end = mainViewModel.coordenates.getCoordenateFormatted(it)

                        CoroutineScope(Dispatchers.IO).launch {
                            createRoute(mainViewModel.getRoute())
                        }
                    }else{
                        mainViewModel.coordenates.start = null
                        mainViewModel.coordenates.end = null
                        poly!!.remove()
                    }
                }
            }
        }
    }

    private fun locationPermissionRequest() {
        val requestPermissionLauncher = registerForActivityResult(ActivityResultContracts.RequestPermission()){}
        requestPermissionLauncher.launch(Manifest.permission.ACCESS_FINE_LOCATION)
        requestPermissionLauncher.launch(Manifest.permission.ACCESS_COARSE_LOCATION)
    }

    private fun createRoute(result: Response<RouteResponse>){
        if(result.isSuccessful){
            drawRoute(result.body()!!)
        }else{
            Log.d("test", "KO")
        }
    }

    private fun drawRoute(routeResponse: RouteResponse) {
        val polyLineOptions = PolylineOptions()
        routeResponse.features[0].geometry.coordinates.forEach {
            polyLineOptions.add(LatLng(it[1], it[0]))
        }

        runOnUiThread{
            poly = map.addPolyline(polyLineOptions)
        }
    }
}