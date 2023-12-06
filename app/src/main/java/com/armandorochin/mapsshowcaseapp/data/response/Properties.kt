package com.armandorochin.mapsshowcaseapp.data.response

data class Properties(
    val fare: Int,
    val segments: List<Segment>,
    val summary: Summary,
    val transfers: Int,
    val way_points: List<Int>
)