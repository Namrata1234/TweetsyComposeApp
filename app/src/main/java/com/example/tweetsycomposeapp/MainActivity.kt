package com.example.tweetsycomposeapp

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.tweetsycomposeapp.api.TweetsyAPI
import com.example.tweetsycomposeapp.screens.CategoryScreen
import com.example.tweetsycomposeapp.screens.DetailsScreen
import com.example.tweetsycomposeapp.ui.theme.TweetsyComposeAppTheme
import com.google.gson.Gson
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

//    @Inject
//    lateinit var tweetsyAPI: TweetsyAPI

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

//        GlobalScope.launch {
//           val response= tweetsyAPI.getCategories()
//            Log.d("MYAPP", response.body()?.distinct().toString() )
//        }


        setContent {
           // CategoryScreen()
            //DetailsScreen()
            App()
        }
    }
}

@Composable
fun App(){
    val navController= rememberNavController()
    NavHost(navController = navController, startDestination ="category") {
        composable(route = "category"){
            CategoryScreen{
                navController.navigate("details/${it}")
            }
        }
        composable(route = "details/{category}", listOf(navArgument("category"){
            type= NavType.StringType
        })){
            DetailsScreen()
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    TweetsyComposeAppTheme {
        Greeting("Android")
    }
}