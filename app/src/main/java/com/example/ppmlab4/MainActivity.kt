package com.example.ppmlab4

import android.os.Bundle
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
import com.example.ppmlab4.ui.theme.PPMLAB4Theme
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.ui.res.painterResource
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp


data class Pet (val pictureId: Int, val name: String, val breed: String, val isAdopted: Boolean){}

@Composable
fun Message(pet:Pet){

    Row {
        Spacer(modifier = Modifier.width(20.dp))
        Image(
            painter = painterResource(id = pet.pictureId),
            contentDescription = "Dog Image",
            modifier = Modifier
                .size(100.dp)
                .clip(CircleShape)

        )

        Spacer(modifier = Modifier.width(10.dp))

        Column {
            Spacer(modifier = Modifier.height(20.dp))
            Text(pet.name)
            Text(pet.breed)
            Text(pet.isAdopted.toString())
        }

    }
}


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        enableEdgeToEdge()
        setContent {
            PPMLAB4Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(innerPadding)
                    ) {
                        Message(Pet(R.drawable.dog1, "Buddy", "Golden Retriever", true))
                        Message(Pet(R.drawable.dog2, "Max", "Beagle", false))

                    }
                }
            }
        }
    }
}



