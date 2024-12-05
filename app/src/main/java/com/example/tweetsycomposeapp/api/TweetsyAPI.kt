package com.example.tweetsycomposeapp.api

import com.example.tweetsycomposeapp.models.TweetListItem
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers

interface TweetsyAPI {

    //https://api.jsonbin.io/v3/b/6731a9f0e41b4d34e4521c4f?meta=false
    @GET("v3/b/6731a9f0e41b4d34e4521c4f?meta=false")
    suspend fun getTweets(@Header("X-JSON-Path") category:String):Response<List<TweetListItem>>

    @GET("v3/b/6731a9f0e41b4d34e4521c4f?meta=false")
    @Headers("X-JSON-Path:tweets..category")
    suspend fun getCategories() :Response<List<String>>
}