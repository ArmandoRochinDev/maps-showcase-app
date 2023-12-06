package com.armandorochin.mapsshowcaseapp.ui

import androidx.lifecycle.ViewModel
import com.armandorochin.mapsshowcaseapp.data.response.RouteResponse
import com.armandorochin.mapsshowcaseapp.domain.GetRouteUseCase
import com.armandorochin.mapsshowcaseapp.ui.model.RouteCoordenates
import dagger.hilt.android.lifecycle.HiltViewModel
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val getRouteUseCase: GetRouteUseCase
):ViewModel(){

    var coordenates:RouteCoordenates = RouteCoordenates(null,null)

    suspend fun getRoute():Response<RouteResponse>{
        return getRouteUseCase(coordenates.start!!, coordenates.end!!)
    }
}