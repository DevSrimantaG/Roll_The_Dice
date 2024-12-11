package com.example.dicegame


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.dicegame.ui.theme.DiceGameTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            DiceGameTheme {
               DiceRoller()
            }
        }
    }
}


@Composable
fun DiceRoller() {
    var diceNumber by remember { mutableStateOf(1) }

    val diceImage = when (diceNumber){
      1-> painterResource(id = R.drawable.dice_1)
      2-> painterResource(id = R.drawable.dice_2)
      3-> painterResource(id = R.drawable.dice_3)
      4-> painterResource(id = R.drawable.dice_4)
      5-> painterResource(id = R.drawable.dice_5)
        else -> painterResource(id = R.drawable.dice_6)
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center)
    {
        Text(text = "ROLL THE DICE", fontSize = 24.sp, color = Color.Red)

        Spacer(modifier = Modifier.height(20.dp))
        
        Image(
            painter = diceImage, 
            contentDescription ="Dice",
            modifier = Modifier
                .size(150.dp),
            contentScale = ContentScale.Fit
        )
        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = { diceNumber = (1..6).random() }) {

            Text(
                text = "Change",
                fontSize = 18.sp,
                color = Color.White
            )
        }
    }
}
@Preview(showBackground = true)
@Composable
fun DefaultPreview(){
    DiceGameTheme {
        DiceRoller()
    }
}