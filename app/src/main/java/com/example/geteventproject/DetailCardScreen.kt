import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.example.geteventproject.MyApp
import com.example.geteventproject.data.local.database.EventEntity

@Composable
fun DetailCardScreen(navController: NavHostController) {
    val titreState = remember { mutableStateOf("") }
    val descriptionState = remember { mutableStateOf("") }
    val dateState = remember { mutableStateOf("") }
    val placeState = remember { mutableStateOf("") }

    // Variable pour stocker le message d'erreur
    var errorMessage by remember { mutableStateOf<String?>(null) }

    Column(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxSize(),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Start
        ) {
            IconButton(
                onClick = {
                    navController.popBackStack()
                },
                modifier = Modifier.padding(8.dp)
            ) {
                Icon(Icons.Filled.ArrowBack, contentDescription = "Retour")
            }
        }

        Spacer(modifier = Modifier.height(16.dp)) // Ajout d'un espace vertical entre la flèche retour et les champs

        TextField(
            value = titreState.value,
            onValueChange = { titreState.value = it },
            label = { Text("Titre") },
            modifier = Modifier
                .padding(8.dp)
                .clip(MaterialTheme.shapes.medium)
        )
        TextField(
            value = descriptionState.value,
            onValueChange = { descriptionState.value = it },
            label = { Text("Description") },
            modifier = Modifier
                .padding(8.dp)
                .clip(MaterialTheme.shapes.medium)
        )
        TextField(
            value = dateState.value,
            onValueChange = { dateState.value = it },
            label = { Text("Date") },
            modifier = Modifier
                .padding(8.dp)
                .clip(MaterialTheme.shapes.medium)
        )
        TextField(
            value = placeState.value,
            onValueChange = { placeState.value = it },
            label = { Text("Place") },
            modifier = Modifier
                .padding(8.dp)
                .clip(MaterialTheme.shapes.medium)
        )

        errorMessage?.let { message ->
            Text(
                text = message,
                color = MaterialTheme.colorScheme.error,
                modifier = Modifier.padding(8.dp),
            )
        }

        Button(
            onClick = {
                if (titreState.value.isEmpty() || descriptionState.value.isEmpty() || dateState.value.isEmpty() || placeState.value.isEmpty()) {
                    errorMessage = "Veuillez remplir tous les champs."
                } else {
                    navController.navigate("home")
                }
            },
            modifier = Modifier.padding(8.dp)
        ) {
            Text("Modifier")
        }
    }
}
