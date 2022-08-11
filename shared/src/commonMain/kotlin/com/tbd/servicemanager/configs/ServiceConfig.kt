package com.tbd.servicemanager.configs

import org.json.JSONObject

object ServiceConfig {
    lateinit var serviceConfig:JSONObject


    fun getServiceConfigForService(serviceName:String):JSONObject{

        return serviceConfig.getJSONObject(serviceName)
    }
}