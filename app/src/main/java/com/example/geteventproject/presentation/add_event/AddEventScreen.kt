package com.example.geteventproject.presentation.add_event

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.geteventproject.data.local.database.EventEntity


@Composable
fun AddEventScreen(
    navController: NavController,
    //viewModel: AddEventViewModel = viewModel()
) {
    Column(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Add Event")

        // Ajouter des champs de saisie pour les détails de l'événement (title, description, place, date)

        Button(
            onClick = {
                // Créer un nouvel EventEntity avec les détails saisis

                // Appeler la méthode addEvent du viewModel pour ajouter l'événement
               //val event = EventEntity()
               //viewModel.addEvent(event)
                //Naviguer de retour à la liste des événements
                      navController.popBackStack()
            },
            modifier = Modifier.padding(16.dp)
        ) {
            Text(text = "Save")
        }
    }
}
