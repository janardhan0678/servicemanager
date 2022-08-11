package com.tbd.servicemanager

class Greeting {
    fun greeting(): String {
        return "Hello, ${Platform().platform}!"
    }
}