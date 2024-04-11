package com.example.geteventproject

import AddEventItemScreen
import AddEventViewModel
import DetailCardScreen
import HomeScreen
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.room.Room
import com.example.geteventproject.data.local.EventDao
import com.example.geteventproject.data.local.database.EventDatabase
import com.example.geteventproject.data.local.database.EventEntity
import com.example.geteventproject.data.repository.EventRepositoryImpl
import com.example.geteventproject.domain.AddEventUseCase
import com.example.geteventproject.presentation.add_event.AddEventScreen
import com.example.geteventproject.presentation.add_event.AddEventViewModelFactory
import com.example.geteventproject.presentation.events.EventList
import com.example.geteventproject.presentation.events.EventListScreen
import com.example.geteventproject.ui.theme.GetEventProjectTheme


class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
                setContent {
            GetEventProjectTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()
                    NavHost(navController = navController, startDestination = "login") {
                        composable("login") {
                            LoginScreen(navController = navController)
                        }
                        composable("pagePrincipale") {
                            PagePrincipaleScreen(navController = navController)
                        }
                        composable("home") {
                            HomeScreen(navController = navController)
                        }
                        composable("addEventScreen") {
                            AddEventItemScreen(navController = navController)
                        }
                        composable("detailCardScreen") {
                            DetailCardScreen(navController = navController)
                        }
                    }
                }
            }
        }
    }
}
