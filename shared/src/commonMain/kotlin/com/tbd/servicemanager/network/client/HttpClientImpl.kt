//package com.tbd.servicemanager.network.client
//
//import com.tbd.servicemanager.service.data.ServiceObject
//import com.tbd.servicemanager.service.manager.ServiceManager
//
//
//class HttpClientImpl(private val client: io.ktor.client.HttpClient):HttpClient {
//
//    /*
//     * This class will responsible for making http calls.
//     *
//     * Transformers
//     * Caching
//     * Headers
//     * Cookie management
//     * Cert pinning
//     *
//     */
//    private val serviceManager: ServiceManager
//        get() {
//          return ServiceManager(client)
//        }
//
//    /*
//     *
//     *
//     */
//    override suspend fun get(serviceObject: ServiceObject) {
//        val serviceResult =  serviceManager.makeServiceCall(serviceObject)
////        when (serviceResult) {
////
////            is ServiceResult.Success -> {
////
////
////                println("success")
////               serviceResult.data.responseStr
////            } else   ->{
////                println("Error")
////               serviceResult.data.responseStr
////                //  tv.setText(ServiceResult.Error.responseStr)
////            }
////
////        }
//
//    }
//
//    override suspend fun post(serviceObject: ServiceObject) {
//        serviceManager.makeServiceCall(serviceObject)
//    }
//}