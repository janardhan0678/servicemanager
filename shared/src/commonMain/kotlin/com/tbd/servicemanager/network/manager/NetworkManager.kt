package com.tbd.network.manager


import com.tbd.servicemanager.network.ServiceConstatnts
import com.tbd.servicemanager.network.data.RequestObject
import com.tbd.servicemanager.network.data.RequestType
import com.tbd.servicemanager.network.data.ResponseObject
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.engine.*
import io.ktor.client.plugins.*
import io.ktor.client.plugins.logging.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.http.*
import io.ktor.util.*

class NetworkManager(): INetworkManager {
// need to add the client config

    private lateinit var client: HttpClient

    constructor(config:String): this() {
    }

    constructor(httpClient: HttpClient) : this() {
        client = httpClient
    }

    constructor(networkManager:NetworkManager) : this() {
        client = networkManager.getClient()
    }

    //TODO network config clientEngine,RetryRequired

    @OptIn(InternalAPI::class)
    override suspend fun makeNetworkCall(requestObject: RequestObject):ResponseObject {

        var responseObject = ResponseObject()
        try {
            val httpResponse: HttpResponse = client.request{
                url(requestObject.url)
             // contentType(getContentType(requestObject.contentType))//TODO need to fix contentType issue
              if(requestObject.requestType == RequestType.POST || requestObject.requestType == RequestType.PUT)   body = requestObject.requestStr
                method = getMethodType(requestObject.requestType)
                //TODO implement cookies and headers
                //TODO cookie rotation
                // headers = requestObject.requetHeaders
            }
            responseObject.responseStr = httpResponse.body()
            responseObject.isSuccess = httpResponse.status.isSuccess()

            return responseObject
        } catch(e: RedirectResponseException) {
            responseObject.statusCode = e.response.status.value
            responseObject.responseStr = "Error: ${e.message}"
            return responseObject
        } catch(e: ClientRequestException) {
            responseObject.statusCode = e.response.status.value
            responseObject.responseStr = "Error: ${e.message}"
            return responseObject
        } catch(e: ServerResponseException) {
            responseObject.statusCode = e.response.status.value
            responseObject.responseStr = "Error: ${e.message}"
            return responseObject
        } catch(e: Exception) {
            responseObject.statusCode = ServiceConstatnts.SERVICE_EXCEPTION_CODE
            responseObject.responseStr = "Error: ${e.message}"
            return responseObject
        }
    }

    private fun getMethodType(requestMethod:RequestType):HttpMethod {

        return HttpMethod.parse(requestMethod.toString())
    }

    private fun getContentType(contentType:String):ContentType{

        return ContentType.parse(contentType)
//
//      return  when(contentType)
//        {
//            "*"-> ContentType.Application.Any
//          "atom+xml"-> ContentType.Application.Atom
//          "cbor"-> ContentType.Application.Cbor
//          "json"-> ContentType.Application.Json
//          "hal+json"-> ContentType.Application.HalJson
//          "javascript"-> ContentType.Application.JavaScript
//          "octet-stream"-> ContentType.Application.OctetStream
//          "font-woff"-> ContentType.Application.FontWoff
//          "rss+xm"-> ContentType.Application.Rss
//          "xml"-> ContentType.Application.Xml
//          "xml-dtd"-> ContentType.Application.Xml_Dtd
//          "zip"-> ContentType.Application.Zip
//          "gzip"-> ContentType.Application.GZip
//          "x-www-form-urlencoded"-> ContentType.Application.FormUrlEncoded
//          "pdf"-> ContentType.Application.Pdf
//          "vnd.openxmlformats-officedocument.spreadsheetml.sheet"-> ContentType.Application.Xlsx
//          "vnd.openxmlformats-officedocument.wordprocessingml.document"-> ContentType.Application.Docx
//          "vnd.openxmlformats-officedocument.presentationml.presentation"-> ContentType.Application.Pptx
//          "protobuf"-> ContentType.Application.ProtoBuf
//          "wasm"-> ContentType.Application.Wasm
//          "problem+json"-> ContentType.Application.ProblemJson
//          "problem+xml"-> ContentType.Application.ProblemXml
//          else -> ContentType.Application.Json
//
//        }
    }

    public fun setClient(httpClient: HttpClient){
        client = httpClient
    }

    public fun getClient():HttpClient{
        return client
    }

//    companion object {
//        fun create(engine: HttpClientEngineFactory<HttpClientEngineConfig>): HttpClient {
//            return   HttpClient(engine) {
//                install(Logging) {
//                    level = LogLevel.ALL
//                }
//            }
//        }
//    }
}