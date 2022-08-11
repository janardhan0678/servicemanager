package com.tbd.servicemanager.android.application

import android.app.Application
import android.content.Context
import android.util.Log
import java.io.ByteArrayOutputStream
import java.io.IOException
import java.io.InputStream
import com.tbd.servicemanager.android.R
import com.tbd.servicemanager.configs.NetworkConfig
import com.tbd.servicemanager.configs.ServiceConfig
import org.json.JSONObject

class MainApplication:Application() {


    override fun onCreate() {
        super.onCreate()

        setServiceConfig()
        setNetworkConfig()
    }

    fun setServiceConfig(){

        val serviceConfig: String = getConfig(applicationContext,R.raw.service_config)
        Log.d("ServiceConfig",serviceConfig)
        val  serviceConfigJson = JSONObject(serviceConfig)

        Log.d("ServiceConfig",serviceConfigJson.toString(4))

        ServiceConfig.serviceConfig = serviceConfigJson

        Log.d("ServiceConfig",ServiceConfig.serviceConfig.toString(4))
    }


    fun setNetworkConfig(){

        val networkConfig: String = getConfig(applicationContext,R.raw.network_config)
        Log.d("networkConfig",networkConfig)

        val  networkeConfigJson = JSONObject(networkConfig)

        Log.d("NetworkConfig",networkeConfigJson.toString(4))

        NetworkConfig.networkConfig = networkeConfigJson

        Log.d("NetworkConfig", NetworkConfig.networkConfig.toString(4))
    }

    fun getConfig(ctx: Context,id:Int): String {
        val inputStream: InputStream = ctx.getResources().openRawResource(id)
        val byteArrayOutputStream = ByteArrayOutputStream()
        var i: Int
        try {
            i = inputStream.read()
            while (i != -1) {
                byteArrayOutputStream.write(i)
                i = inputStream.read()
            }
            inputStream.close()
        } catch (e: IOException) {
            return "{}"
        }
        return byteArrayOutputStream.toString()
    }


}