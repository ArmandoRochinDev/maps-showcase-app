package com.armandorochin.mapsshowcaseapp.data.response

data class Query(
    val coordinates: List<List<Double>>,
    val format: String,
    val profile: String
)