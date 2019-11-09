package com.example.intercrowded.api

import android.util.Log
import com.example.intercrowded.api.model.ApiResponse
import com.google.gson.GsonBuilder
import okhttp3.*
import java.io.IOException

class HttpStuff {

    var url:String = "com.blabla"

    fun sendRequest(){
        var request = Request.Builder().url(url).build()
        var client = OkHttpClient()
        client.newCall(request).enqueue(object:Callback {

            override fun onResponse(call: Call, response: Response) {
                 val body = response?.body()?.toString()
                println(body)
            }

            override fun onFailure(call: Call, e: IOException) {
              Log.d("debug","failed to execute http")
            }
        })
    }

    companion object testcode {

        fun testResponseDecode(){

            val jsonbody = "{routes:[{route_id:\"1234\",paths:[{time_span:{start:\"yyyy-mm-ddThh:mm:ssZ\",end:\"yyyy-mm-ddThh:mm:ssZ\"},startpoint:{lat:0.0,lon:0.0,name:\"Amsterdam\"},endpoint:{lat:0.0,lon:0.0,name:\"Rotterdam\"},occupancy:0.5,rating:3,vehicle_type:\"Bus_801\"}]}]}"

            val gson = GsonBuilder().create()

            val cast = gson.fromJson(jsonbody, ApiResponse::class.java)


        }
    }
}