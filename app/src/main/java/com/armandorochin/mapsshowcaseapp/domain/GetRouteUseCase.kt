package com.armandorochin.mapsshowcaseapp.domain

import com.armandorochin.mapsshowcaseapp.data.remote.RemoteDataSource
import com.armandorochin.mapsshowcaseapp.data.response.RouteResponse
import retrofit2.Response
import javax.inject.Inject

class GetRouteUseCase @Inject constructor(
    private val remoteDataSource: RemoteDataSource
){
    suspend operator fun invoke(start:String, end:String):Response<RouteResponse> {
        return remoteDataSource.getRoute(start, end)
    }
}