package com.tbd.servicemanager.service

//class ServiceResult {
//    fun success(networkObject: NetworkObject)
//    fun error(networkObject: NetworkObject)
//}

sealed class ServiceResult<out R> {
    data class Success<out T>(val data: T) : ServiceResult<T>()
    data class Error<out T>(val data: T) : ServiceResult<T>()
}
