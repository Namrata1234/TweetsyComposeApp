package com.example.tweetsycomposeapp.screens

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.tweetsycomposeapp.viemodels.CategoriesViewModel

@Composable
fun CategoryScreen(onClickListener: (String) -> Unit){

    val categoriesViewModel:CategoriesViewModel = hiltViewModel()
    val categories:State<List<String>> = categoriesViewModel.categories.collectAsState()

    LazyVerticalGrid(columns = GridCells.Fixed(2),
        contentPadding = PaddingValues(8.dp),
        verticalArrangement = Arrangement.SpaceAround
    ) {
        items(categories.value.distinct()) {
            CategoryItem(category = it,onClickListener)
        }
    }
}

@Composable
fun CategoryItem(category:String,onClickListener:(String)->Unit){

    Box(modifier = Modifier
        .padding(4.dp)
        .size(160.dp)
        .clickable {
            onClickListener(category)
        }
        .clip(RoundedCornerShape(8.dp))
        .border(1.dp, color = Color(0xFFEEEEEE)),
        contentAlignment = Alignment.BottomCenter
      ){
        Text(text = category,
            color = Color.Black,
            modifier = Modifier.padding(0.dp,20.dp),
            style = MaterialTheme.typography.bodyLarge)
    }
}
