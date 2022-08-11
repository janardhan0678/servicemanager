package com.tbd.servicemanager.network.data

class ResponseObject {

    lateinit var serviceName: String
    lateinit var url: String
    lateinit var responseStr: String
    //lateinit var response: Response
    var statusCode: Int = 0
    var responseCookies: HashMap<String,String> = hashMapOf<String, String>()
    var responseHeaders: HashMap<String,String> = hashMapOf<String, String>()
    var isSuccess: Boolean = false
}