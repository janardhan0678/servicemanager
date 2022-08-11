package com.tbd.servicemanager.service.data

import com.tbd.servicemanager.network.data.RequestType

class ServiceObject {

    constructor(serviceName: String){
        this.serviceName = serviceName
    }

    lateinit var serviceName: String
    lateinit var url: String
    val requestStr: String = ""
    lateinit var responseStr: String
    //lateinit var request: Request
    //lateinit var response: Response
    var statusCode: Int = 0
    lateinit var contentType: String
    var requetCookies: HashMap<String,String>  = hashMapOf<String, String>()
    var responseCookies: HashMap<String,String> = hashMapOf<String, String>()

    var requetHeaders: HashMap<String,String> = hashMapOf<String, String>()
    var responseHeaders: HashMap<String,String> = hashMapOf<String, String>()
    var isSuccess: Boolean = false
    lateinit var requestType: RequestType
}