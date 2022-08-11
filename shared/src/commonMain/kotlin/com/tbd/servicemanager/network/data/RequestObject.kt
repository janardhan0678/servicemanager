package com.tbd.servicemanager.network.data

class RequestObject {
    lateinit var serviceName: String
    lateinit var url: String
    lateinit var requestStr: String
    //lateinit var request: Request
    lateinit var contentType: String
    var requetCookies: HashMap<String,String> = hashMapOf<String, String>()
    var requetHeaders: HashMap<String,String> = hashMapOf<String, String>()
    lateinit var requestType:RequestType
}