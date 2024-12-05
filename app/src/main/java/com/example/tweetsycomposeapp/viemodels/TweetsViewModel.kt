package com.example.tweetsycomposeapp.viemodels

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tweetsycomposeapp.models.TweetListItem
import com.example.tweetsycomposeapp.repository.TweetRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TweetsViewModel @Inject constructor(private val repository: TweetRepository,val savedStateHandle: SavedStateHandle) : ViewModel() {

    val tweets: StateFlow<List<TweetListItem>> get() = repository.tweets

    init {
        viewModelScope.launch {
            repository.getTweets(savedStateHandle.get<String>("category")?:"Android")
        }
    }
}