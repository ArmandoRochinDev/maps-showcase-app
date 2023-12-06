package com.armandorochin.mapsshowcaseapp.data.remote

import com.armandorochin.mapsshowcaseapp.BuildConfig
import com.armandorochin.mapsshowcaseapp.data.response.RouteResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface OpenRouteService {

    @GET("driving-car?api_key=${BuildConfig.OPEN_ROUTE_KEY}")
    suspend fun getRoute(@Query("start", encoded = true)start:String, @Query("end", encoded = true)end:String): Response<RouteResponse>
}