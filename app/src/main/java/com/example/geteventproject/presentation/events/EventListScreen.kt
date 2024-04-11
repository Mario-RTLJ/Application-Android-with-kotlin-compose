package com.example.geteventproject.presentation.events

import androidx.compose.foundation.layout.*
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Divider
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.geteventproject.data.local.database.EventEntity
import androidx.navigation.compose.rememberNavController

@Composable
fun EventListScreen(
    navController: NavController,
    events: List<EventEntity>,
    onAddEventClick: () -> Unit
) {
    Column(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxSize()
    ) {
        Text(
            text = "GET_events",
            modifier = Modifier
                .padding(8.dp)
                .align(Alignment.CenterHorizontally)
        )

        events.forEach { event ->
            EventCard(event)
        }

        FloatingActionButton(
            onClick = {
                // Naviguer vers l'écran d'ajout d'événement
                navController.navigate("addEventScreen")
            },
            modifier = Modifier
                .padding(8.dp)
                .align(Alignment.End)
        ) {
            Text(text = "+")
        }
    }
}

@Composable
fun EventCard(event: EventEntity) {
    Column(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth()
    ) {
        Text(text = "Titre: ${event.title}")
        Text(text = "Description: ${event.description}")
        Text(text = "Lieu: ${event.place}")
        Text(text = "Date: ${event.date}")
        Divider()
    }
}


@Composable
fun EventList(events: List<EventEntity>) {
    Column(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxSize()
    ) {
        events.forEach { event ->
            EventCard(event)
        }
    }
}




