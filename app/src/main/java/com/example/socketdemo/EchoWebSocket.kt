package com.example.socketdemo

import android.util.Log
import okhttp3.Response
import okhttp3.WebSocket
import okhttp3.WebSocketListener
import okio.ByteString
import okio.ByteString.Companion.decodeHex

class EchoWebSocket : WebSocketListener() {

    private val NormalClosureStatus: Int = 1000

    override fun onOpen(webSocket: WebSocket, response: Response) {
//        super.onOpen(webSocket, response)
        webSocket.send("Hello it's socket")
        webSocket.send("What's up")
        webSocket.send("DeefBeef".decodeHex())
        webSocket.close(NormalClosureStatus, "GoodBye...")
    }

    override fun onMessage(webSocket: WebSocket, bytes: ByteString) {
        Log.d("onMessage[ByteString]",bytes.hex())
    }

    override fun onMessage(webSocket: WebSocket, text: String) {
        Log.d("onMessage[text]",text)
    }

    override fun onClosing(webSocket: WebSocket, code: Int, reason: String) {
        webSocket.close(NormalClosureStatus,reason)
        Log.d("onClosing","closing $code / $reason")
    }

    override fun onFailure(webSocket: WebSocket, t: Throwable, response: Response?) {
        Log.d("onFailure",t.message)

    }
}