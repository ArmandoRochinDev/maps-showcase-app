package com.armandorochin.mapsshowcaseapp.data.response

data class Feature(
    val bbox: List<Double>,
    val geometry: Geometry,
    val properties: Properties,
    val type: String
)