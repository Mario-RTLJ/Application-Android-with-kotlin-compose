import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.geteventproject.R

@Composable
fun HomeScreen(navController: NavHostController) {
    val eventList = listOf(
        Event(1, "Titre 1", "Description 1", "Date 1","Place 1"),
        Event(2, "Titre 2", "Description 2", "Date 2","Place 2"),
        Event(3, "Titre 3", "Description 3", "Date 3","Place 3"),
        Event(4, "Titre 4", "Description 4", "Date 4","Place 4"),
        Event(5, "Titre 5", "Description 5", "Date 5","Place 5"),
        Event(6, "Titre 6", "Description 6", "Date 6","Place 6"),
    )

    Column(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxSize()
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxWidth()
        ) {
            Image(
                painter = painterResource(id = R.drawable.logo),
                contentDescription = "Logo",
                modifier = Modifier.size(60.dp)
            )
            Text(
                text = "GET",
                modifier = Modifier.padding(start = 8.dp),
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold,
                fontFamily = FontFamily(Font(R.font.gothicb)),

            )
        }

        Box(
            modifier = Modifier
                .weight(1f)
                .padding(vertical = 8.dp)
        ) {
            EventList(eventList, navController)
        }
        FloatingActionButton(
            onClick = {
                navController.navigate("addEventScreen")
            },
            modifier = Modifier
                .padding(8.dp)
                .align(Alignment.CenterHorizontally)
        ) {
            Text(text = "+", fontSize = 30.sp)
        }
    }
}

@Composable
fun EventList(eventList: List<Event>, navController: NavHostController) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
    ) {
        items(eventList) { event ->
            EventCard(event = event, navController)
        }
    }
}

@Composable
fun EventCard(event: Event, navController: NavHostController) {
    var showDialog by remember { mutableStateOf(false) }

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
            .clickable {
                navController.navigate("detailCardScreen")
            },
    ) {
        Box(
            modifier = Modifier.padding(16.dp)
        ) {
            Column {
                Text(text = "Titre: ${event.title}")
                Text(text = "Description: ${event.description}")
                Text(text = "Date: ${event.date}")
                Text(text = "Place: ${event.place}")
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = "Delete",
                    style = MaterialTheme.typography.bodyLarge,
                    color = Color.Red,
                    modifier = Modifier.clickable {
                        showDialog = true
                    }
                )

            }
        }
    }

    if (showDialog) {
        AlertDialog(
            onDismissRequest = { showDialog = false },
            title = { Text(text = "Suppression") },
            text = { Text(text = "Êtes-vous sûr de vouloir supprimer cet événement ?") },
            confirmButton = {
                Button(
                    onClick = {
                        // Action de suppression
                        showDialog = false
                    }
                ) {
                    Text(text = "OK")
                }
            },
            dismissButton = {
                Button(
                    onClick = { showDialog = false }
                ) {
                    Text(text = "Annuler")
                }
            }
        )
    }
}


data class Event(
    val id: Int,
    val title: String,
    val description: String,
    val date: String,
    val place: String
)
