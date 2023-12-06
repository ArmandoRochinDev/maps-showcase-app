package com.armandorochin.mapsshowcaseapp.data.response

data class Segment(
    val distance: Double,
    val duration: Double,
    val steps: List<Step>
)