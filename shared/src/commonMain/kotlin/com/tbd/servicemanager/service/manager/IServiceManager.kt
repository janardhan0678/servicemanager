package com.tbd.servicemanager.service.manager

import com.tbd.servicemanager.service.ServiceResult
import com.tbd.servicemanager.service.data.ServiceObject


interface IServiceManager {

    suspend fun  makeServiceCall(serviceObject: ServiceObject): ServiceResult<ServiceObject>

}