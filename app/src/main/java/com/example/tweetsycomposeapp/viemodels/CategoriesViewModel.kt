package com.example.tweetsycomposeapp.viemodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tweetsycomposeapp.repository.TweetRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CategoriesViewModel @Inject constructor(private val categoriesRepository: TweetRepository) : ViewModel() {

    val categories: StateFlow<List<String>> get() = categoriesRepository.categories

    init {
        viewModelScope.launch {
            categoriesRepository.getCategories()
        }
    }
}