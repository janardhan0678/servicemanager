package com.tbd.servicemanager.network.client

import io.ktor.client.engine.*
import io.ktor.client.engine.darwin.*

actual class HttpClientEngine actual constructor() {
    actual fun getClientEngine(): HttpClientEngineFactory<HttpClientEngineConfig> {
       return Darwin
    }
}