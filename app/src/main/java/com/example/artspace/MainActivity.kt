package com.example.artspace

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.artspace.ui.theme.ArtSpaceTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ArtSpaceTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    HomeScreen()
                    ArtSpace()
                }
            }
        }
    }
}

@Composable
fun HomeScreen() {
    Image(
        painter = painterResource(id = R.drawable.pokedex),
        contentDescription = "backgroud",
        contentScale = ContentScale.FillBounds,
        modifier = Modifier.fillMaxSize()
    )
}

@Composable
fun ArtSpace() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        var artID by remember { mutableStateOf(1) }
        val imageResource = when (artID) {
            1 -> R.drawable.bulbasaur
            2 -> R.drawable.ivysaur
            3 -> R.drawable.venusaur
            4 -> R.drawable.charmander
            5 -> R.drawable.charmeleon
            6 -> R.drawable.charizard
            7 -> R.drawable.squirtle
            8 -> R.drawable.wartortle
            else -> R.drawable.blastoise

        }

        val scriptResource = when (artID) {
            1 -> "Bulbasaur"
            2 -> "Ivysaur"
            3 -> "Venusaur"
            4 -> "Charmander"
            5 -> "Charmeleon"
            6 -> "Charizard"
            7 -> "Squirtle"
            8 -> "Wartortle"
            else -> "Blastoise"
        }

        val numberResource = when (artID) {
            1 -> "Pokedex #1"
            2 -> "Pokedex #2"
            3 -> "Pokedex #3"
            4 -> "Pokedex #4"
            5 -> "Pokedex #5"
            6 -> "Pokedex #6"
            7 -> "Pokedex #7"
            8 -> "Pokedex #8"
            else -> "Pokedex #9"
        }

        ArtImage(imageResource)

        ArtDescript(scriptResource, numberResource)

        Spacer(modifier = Modifier.height(22.dp))

        Row(
            horizontalArrangement = Arrangement.SpaceEvenly,
            modifier = Modifier.fillMaxWidth()
        ) {
            Button(
                onClick = {
                    artID -= 1
                    when (artID) {
                        0 -> {
                            artID = 9
                        }
                    }
                },
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF8B0000))
            ) {
                Text(text = "Previous")
            }
            Button(
                onClick = {
                    artID += 1
                    when (artID) {
                        10 -> {
                            artID = 1
                        }
                    }
                },
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF228B22))
            ) {
                Text(
                    text = "Next", color = Color.Black, modifier = Modifier
                        .padding(horizontal = 10.dp)


                )
            }
        }
    }
}

@Composable
fun ArtImage(artID: Int) {

    Spacer(modifier = Modifier.height(150.dp))
    Image(
        painter = painterResource(id = artID),
        contentDescription = null,
        modifier = Modifier
            .background(color = Color(0xFFADD8E6), shape = RoundedCornerShape(20.dp))
            .clip(shape = RoundedCornerShape(20.dp))
            .size(320.dp)
            .border(width = 7.dp, color = Color.Black, shape = RoundedCornerShape(20.dp))
            .padding(10.dp),
    )
}

@Composable
fun ArtDescript(title: String, pokedex: String) {
    Spacer(modifier = Modifier.height(30.dp))
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,

        modifier = Modifier

            .clip(shape = RoundedCornerShape(20.dp))
            .background(Color.LightGray)
            .padding(20.dp)

    ) {
        Text(text = title, fontWeight = FontWeight.Bold, fontSize = 40.sp)
        Text(text = pokedex, fontSize = 20.sp)
        Text(text = "Ken Sugimori (1996)", fontSize = 20.sp, fontStyle = FontStyle.Italic)
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingPreview() {
    ArtSpaceTheme {
        HomeScreen()
        ArtSpace()
    }
}