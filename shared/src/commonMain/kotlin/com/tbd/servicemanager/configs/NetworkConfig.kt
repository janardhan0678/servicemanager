package com.tbd.servicemanager.configs

import org.json.JSONObject

object NetworkConfig {
    lateinit var networkConfig: JSONObject

    fun getNetworkConfigForService(serviceName:String): JSONObject {

        return networkConfig.getJSONObject(serviceName)
    }
}