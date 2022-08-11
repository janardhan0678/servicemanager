package com.tbd.servicemanager.service.manager


import com.tbd.network.manager.NetworkManager
import com.tbd.servicemanager.configs.ServiceConfig
import com.tbd.servicemanager.network.client.MHttpClient
import com.tbd.servicemanager.network.data.RequestObject
import com.tbd.servicemanager.network.data.RequestType
import com.tbd.servicemanager.network.data.ResponseObject
import com.tbd.servicemanager.service.ServiceResult
import com.tbd.servicemanager.service.data.ServiceObject
import com.tbd.servicemanager.utils.JsonUtils
import io.ktor.client.*


class ServiceManager:IServiceManager {

    private lateinit var client: HttpClient

    constructor() {
        client = MHttpClient().getClient()
    }

    override suspend fun makeServiceCall(serviceObject: ServiceObject): ServiceResult<ServiceObject> {

        updateServiceDetails(serviceObject)
        var requestObject = prepareRequest(serviceObject)
        var networkManager = NetworkManager(client)
        var responseObject = networkManager.makeNetworkCall(requestObject)
        updateServiceResponse(responseObject,serviceObject)

        when {
            serviceObject.isSuccess -> { return ServiceResult.Success(serviceObject) }
            else -> { return ServiceResult.Error(serviceObject)}
        }
    }

    private fun updateServiceDetails(serviceObject: ServiceObject){

        var serviceConfig = ServiceConfig.getServiceConfigForService(serviceObject.serviceName)

        serviceObject.url = serviceConfig.getString("url")
      //  serviceObject.requestStr = serviceConfig.getString("request")//TODO need deserialize
        serviceObject.contentType = serviceConfig.getString("contentType")
        serviceObject.requestType = RequestType.valueOf(serviceConfig.getString("requestType"))
        serviceObject.requetCookies = JsonUtils().toMap(serviceConfig.getJSONObject("requestCookies"))
        serviceObject.requetHeaders = JsonUtils().toMap(serviceConfig.getJSONObject("requestHeaders"))

    }


    private fun prepareRequest(serviceObject: ServiceObject):RequestObject{

        var requestObject = RequestObject()
        requestObject.serviceName = serviceObject.serviceName
        requestObject.url = serviceObject.url
        requestObject.requestStr = serviceObject.requestStr
        requestObject.contentType = serviceObject.contentType
        requestObject.requestType = serviceObject.requestType
        requestObject.requetCookies = serviceObject.requetCookies
        requestObject.requetHeaders = serviceObject.requetHeaders

       return requestObject
    }

    private fun updateServiceResponse(responseObject: ResponseObject,serviceObject: ServiceObject):ServiceObject{

        serviceObject.responseStr = responseObject.responseStr
        serviceObject.statusCode = responseObject.statusCode
        serviceObject.responseCookies = responseObject.responseCookies
        serviceObject.responseHeaders = responseObject.responseHeaders
        serviceObject.isSuccess = responseObject.isSuccess

        return serviceObject
    }

//    companion object {
//        fun create(engine: HttpClientEngineFactory<HttpClientEngineConfig>): ServiceManager {
//            return  ServiceManager(HttpClient(engine) {
//                install(Logging) {
//                    level = LogLevel.ALL
//                }
//            })
//        }
//    }
}