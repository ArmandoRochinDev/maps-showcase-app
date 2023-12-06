package com.armandorochin.mapsshowcaseapp.data.remote

import com.armandorochin.mapsshowcaseapp.data.response.RouteResponse
import retrofit2.Response
import retrofit2.http.Query
import javax.inject.Inject

class RemoteDataSource @Inject constructor(
    private val openRouteService: OpenRouteService
) {

    suspend fun getRoute(start:String, end:String): Response<RouteResponse>{
        return openRouteService.getRoute(start,end)
    }
}