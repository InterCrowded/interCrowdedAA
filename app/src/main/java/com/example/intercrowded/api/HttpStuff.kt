package com.example.intercrowded.api

import android.util.Log
import com.example.intercrowded.api.model.ApiResponse
import com.example.intercrowded.api.model.GPSPoint
import com.example.intercrowded.api.model.Timespan
import com.example.intercrowded.api.model.UserRequestData
import com.google.gson.GsonBuilder
import okhttp3.*
import java.io.IOException
import java.net.URL
import kotlin.concurrent.thread

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

            val jsonbody = "{\"routes\": [{\"route_id\": \"00001a\", \"paths\": [{\"timespan\": {\"start\": \"2019-01-02 00:00:00\", \"end\": \"2019-01-02 01:30:00\"}, \"startpoint\": {\"longitude\": 0, \"lattitude\": 0}, \"vehicle_type\": \"Bus_Lijn_808\", \"rating\": 4.5, \"occupancy\": 43, \"endpoint\": {\"longitude\": 1, \"lattitude\": 1}}, {\"timespan\": {\"start\": \"2019-01-01 05:00:00\", \"end\": \"2019-01-01 12:00:00\"}, \"startpoint\": {\"longitude\": 1.2, \"lattitude\": 1.2}, \"vehicle_type\": \"Scooter_Lime_10a4b\", \"rating\": 3.4, \"occupancy\": 0, \"endpoint\": {\"longitude\": 2, \"lattitude\": 2}}]}, {\"route_id\": \"00001b\", \"paths\": [{\"timespan\": {\"start\": \"2019-01-01 00:00:00\", \"end\": \"2019-01-01 01:00:00\"}, \"startpoint\": {\"longitude\": 3.74, \"lattitude\": 5}, \"vehicle_type\": \"Bus_GoGo_112\", \"rating\": 2, \"occupancy\": 21, \"endpoint\": {\"longitude\": 8, \"lattitude\": 6}}, {\"timespan\": {\"start\": \"2019-01-03 00:00:00\", \"end\": \"2019-01-03 01:00:00\"}, \"startpoint\": {\"longitude\": 8, \"lattitude\": 7}, \"vehicle_type\": \"Scooter_Oceania_bca77\", \"rating\": 3.4, \"occupancy\": 0, \"endpoint\": {\"longitude\": 8.1, \"lattitudetitude\": 7.1}}]}]}"

            val gson = GsonBuilder().create()

            val cast = gson.fromJson(jsonbody, ApiResponse::class.java)

            Log.d("debug",cast.toString())


        }

        fun createPostBody(){

            val start = GPSPoint(51.558018,5.095678,"start")
            val end = GPSPoint(52.558018,6.095678,"end")
            val data = UserRequestData("1234",start,end, Timespan())

            println(data.toString())
        }

        fun sendRequest():ApiResponse {
            val start = GPSPoint(51.558018,5.095678,"start")
            val end = GPSPoint(52.558018,6.095678,"end")
            val data = UserRequestData("1234",start,end, Timespan())
            val client = RetrofitClient.getInstance()

            var json_respond:ApiResponse? = null
            val url = "http://18.203.246.79:8080/api/routes" + "?" + data.user_id + "&&" + start.toString() + "&&" + end.toString() + "&&" + data.timespan.toString()

            thread {
                val result = URL(url).readText()

                val gson = GsonBuilder().create()

                val cast = gson.fromJson(result, ApiResponse::class.java)

                json_respond = cast ?: ApiResponse(arrayListOf())

            }

            while (json_respond == null){
                Thread.sleep(200)
            }

            return json_respond!!


        }
    }
}