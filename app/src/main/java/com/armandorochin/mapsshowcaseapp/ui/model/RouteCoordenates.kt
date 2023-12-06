package com.armandorochin.mapsshowcaseapp.ui.model

import com.google.android.gms.maps.model.LatLng

data class RouteCoordenates(
    var start:String?,
    var end:String?
){
    fun getCoordenateFormatted(coor:LatLng):String{
        return "${coor.longitude}, ${coor.latitude}"
    }
}