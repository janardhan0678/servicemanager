package com.tbd.servicemanager.android.home



import com.tbd.servicemanager.network.data.RequestType
import com.tbd.servicemanager.service.ServiceResult
import com.tbd.servicemanager.service.data.ServiceObject
import com.tbd.servicemanager.service.manager.ServiceManager
import io.ktor.client.engine.android.*


class HomeRepository {

     private val serviceManager = ServiceManager()

     suspend fun makeHomeServiceRequest():ServiceResult<ServiceObject>{

        val serviceObject = ServiceObject("PlaceHolderService1")

        return serviceManager.makeServiceCall(serviceObject)
    }



}