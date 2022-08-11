package com.tbd.servicemanager.network.client

import com.tbd.servicemanager.configs.NetworkConfig
import io.ktor.client.HttpClient
import io.ktor.client.plugins.*
import io.ktor.client.plugins.logging.*

class MHttpClient() {
      fun getClient(): HttpClient {

        return HttpClient(HttpClientEngine().getClientEngine()) {
             install(Logging) {
              level = LogLevel.ALL
             }
             install(HttpTimeout) {
                requestTimeoutMillis = NetworkConfig.networkConfig.getLong("requestTimeoutMillis")
                connectTimeoutMillis = NetworkConfig.networkConfig.getLong("connectTimeoutMillis")
                socketTimeoutMillis = NetworkConfig.networkConfig.getLong("socketTimeoutMillis")
            }
//            engine {
//                connectTimeout = 100_000
//                socketTimeout = 100_000
//            }
        }
      }
}