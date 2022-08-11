package com.tbd.network.manager


import com.tbd.servicemanager.network.data.RequestObject
import com.tbd.servicemanager.network.data.ResponseObject
import io.ktor.client.*
import io.ktor.client.engine.*
import io.ktor.client.plugins.logging.*


interface INetworkManager {

    suspend fun  makeNetworkCall(requestObject: RequestObject): ResponseObject;

}

//TODO: Cookie management

//Layer/dependency direction - every layer is independent
//UI -> ViewModel -> StateManager -> Repository -> ServiceManager -> NetworkManger -> ktor