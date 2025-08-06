package com.example.ppmlab4

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.ppmlab4.ui.theme.PPMLAB4Theme
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.ui.res.painterResource
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import androidx.compose.material3.Surface
import androidx.compose.material3.MaterialTheme
import androidx.compose.foundation.layout.fillMaxWidth
import android.content.res.Configuration // para configurar el modo oscuro
import androidx.compose.material3.Card // para crear tarjetas
import androidx.compose.material3.CardDefaults // para definir los colores de la tarjeta
// para listar elementos
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items


// para animar elementos hecer que se pueda hacer clic en ellos
import androidx.compose.foundation.clickable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.layout.ContentScale


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PPMLAB4Theme {
                Scaffold { paddingValues ->

                    Surface(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(paddingValues),
                        color = MaterialTheme.colorScheme.background
                    ) {
                        DogList(
                            listOf(
                                Pet(R.drawable.dog1, "Dog", "Breed", false),
                                Pet(R.drawable.dog2, "Dog2", "Breed2", false),
                                Pet(R.drawable.dog1, "Dog3", "Breed3", false)
                            )
                        )
                    }

                }

            }
        }
    }
}


data class Pet (val pictureId: Int, val name: String, val breed: String, var isAdopted: Boolean){}


@Composable
fun PetCard(pet:Pet){
    var isAdopted by remember { mutableStateOf(pet.isAdopted) }
    if (isAdopted) {pet.isAdopted = true}
    Card (colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant),
          modifier = Modifier.fillMaxWidth().padding(8.dp).clickable {if (!isAdopted) isAdopted = true} ) {

        Row(modifier = Modifier.padding(10.dp)) {
            Image(
                painter = painterResource(id = pet.pictureId),
                contentDescription = "Dog Image",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(120.dp)
                    .clip(CircleShape)


            )

            Spacer(modifier = Modifier.width(25.dp))

            Column  {
                Spacer(modifier = Modifier.height(15.dp))


                Column {
                    Text(
                        text = pet.name,
                        color = MaterialTheme.colorScheme.primary,
                        modifier = Modifier.padding(all = 1.dp),
                        style = MaterialTheme.typography.titleSmall

                    )

                    Text(
                        text = pet.breed,
                        color = MaterialTheme.colorScheme.secondary,
                        style = MaterialTheme.typography.bodyLarge
                    )

                    Spacer(modifier = Modifier.height(15.dp))

                    Text(
                        if (isAdopted) "¡Adoptado! ♥" else "¿Adoptar?",
                        color = MaterialTheme.colorScheme.secondary,
                        style = MaterialTheme.typography.bodyLarge
                    )
                }


            }

        }
    }
}

@Composable
fun DogList(pets: List<Pet>) {
    LazyColumn {
        items(pets) { pet ->
            PetCard(pet)
        }
    }
}

@Preview (name = "Light Mode")
@Preview (
    uiMode = Configuration.UI_MODE_NIGHT_YES,
    showBackground = true,
    name = "Dark Mode"
)

@Preview
@Composable
fun PreviewPetCard() {
    PPMLAB4Theme {
        Scaffold { paddingValues ->

            Surface(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues),
                color = MaterialTheme.colorScheme.background
            ) {
                DogList(
                    listOf(
                        Pet(R.drawable.dog1, "Dog", "Breed", false),
                        Pet(R.drawable.dog2, "Dog2", "Breed2", false),
                        Pet(R.drawable.dog3, "Dog3", "Breed3", false),
                        Pet(R.drawable.dog4, "Dog", "Breed", false),
                        Pet(R.drawable.dog5, "Dog2", "Breed2", false),
                        Pet(R.drawable.dog6, "Dog3", "Breed3", false),
                        Pet(R.drawable.dog7, "Dog", "Breed", false),
                        Pet(R.drawable.dog8, "Dog2", "Breed2", false)
                    )
                )
            }

        }
    }
}





