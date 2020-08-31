package com.example.socketdemo

import androidx.lifecycle.ViewModel
import okhttp3.*

class MainViewModel : ViewModel(){

    private val client = OkHttpClient()

    fun start(){
        val request = Request.Builder().url("ws://echo.websocket.org").build()
        val webSocketListener = EchoWebSocket()
        val webSocket = client.newWebSocket(request,webSocketListener)
        

        client.dispatcher.executorService.shutdown()
    }



}