package com.example.tweetsycomposeapp.repository

import com.example.tweetsycomposeapp.api.TweetsyAPI
import com.example.tweetsycomposeapp.models.TweetListItem
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

class TweetRepository @Inject constructor(private val tweetsyAPI: TweetsyAPI) {

    private val _getCategories = MutableStateFlow<List<String>>(emptyList())
    val categories:StateFlow<List<String>> get() = _getCategories

    private val _getTweets = MutableStateFlow<List<TweetListItem>>(emptyList())
    val tweets:StateFlow<List<TweetListItem>> get() = _getTweets

    suspend fun getCategories() {
        val response= tweetsyAPI.getCategories()
        if(response.isSuccessful && response.body()!=null){
            _getCategories.emit(response.body()!!)
        }
    }

    suspend fun getTweets(category:String) {
        val response= tweetsyAPI.getTweets("tweets[?(@.category==\"$category\")]")
        if(response.isSuccessful && response.body()!=null){
            _getTweets.emit(response.body()!!)
        }
    }

}