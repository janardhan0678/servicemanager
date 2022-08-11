package com.tbd.servicemanager.network.client

import io.ktor.client.*
import io.ktor.client.engine.*

@Suppress("NO_ACTUAL_FOR_EXPECT")
expect class HttpClientEngine() {
    fun getClientEngine(): HttpClientEngineFactory<HttpClientEngineConfig>
}