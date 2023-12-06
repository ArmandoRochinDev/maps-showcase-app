package com.armandorochin.mapsshowcaseapp.data.response

data class RouteResponse(
    val bbox: List<Double>,
    val features: List<Feature>,
    val metadata: Metadata,
    val type: String
)