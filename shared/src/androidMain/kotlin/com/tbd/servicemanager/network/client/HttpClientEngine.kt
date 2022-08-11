package com.tbd.servicemanager.network.client

import com.tbd.servicemanager.configs.NetworkConfig
import io.ktor.client.engine.*
import io.ktor.client.engine.android.*
import io.ktor.client.engine.okhttp.*

actual class HttpClientEngine actual constructor() {

    actual fun getClientEngine():HttpClientEngineFactory<HttpClientEngineConfig>{

        if(ClientEngineType.valueOf(NetworkConfig.networkConfig.getString("ClientEngineType"))
            ==ClientEngineType.Android)
       return Android
       else if(ClientEngineType.valueOf(NetworkConfig.networkConfig.getString("ClientEngineType"))
            ==ClientEngineType.Okhttp)
       return OkHttp
        else
        return OkHttp //default network engine okhttp
    }
}