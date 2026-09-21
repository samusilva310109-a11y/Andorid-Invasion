package com.example.andoridinvasion

import androidx.compose.ui.graphics.Color
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.andoridinvasion.ui.theme.AndoridInvasionTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AndoridInvasionTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Column(
                        modifier = Modifier
                            .padding(innerPadding)
                            .fillMaxSize()
                            .background(Color.Black)
                    ) {
                        ScoreAndLives()
                        AndroidRow()
                        ContentContainer(
                            Modifier
                                .weight(0.5f)
                        )

//                        GameOverScreen()
                    }
                }
            }
        }
    }

    @Composable
    fun ScoreAndLives(modifier: Modifier = Modifier) {
        Row(
            modifier = modifier
                .padding(5.dp, 0.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ){
            Text(
                text = "SCORE: 0050",
                fontSize = 20.sp,
                color = Color.White,
                fontWeight = FontWeight.Bold
            )

            Row(

            ) {
                Text(
                    text = "LIVES: ",
                    fontSize = 20.sp,
                    color = Color.White,
                    fontWeight = FontWeight.Bold
                )

                for (numero in 1..3){
                    AndroidIcon(
                        modifier = Modifier
                            .size(20.dp),
                        color = Color.Green
                    )
                }
            }
        }
    }

    @Composable
    fun AndroidIcon(
        modifier: Modifier = Modifier,
        color: Color,
    ) {
      Image(
          modifier = modifier,
          painter = painterResource(R.drawable.image_removebg_preview),
          colorFilter = ColorFilter.tint(color),
          contentDescription = "Icone Android Pixelado"
      )
    }

    @Composable
    fun AndroidRow(modifier: Modifier = Modifier) {
        Row(
            modifier = modifier
                .padding(20.dp, 0.dp)
                .padding(top = 20.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {

            val cores: List<Color> = listOf(
                Color.Green, Color.Red, Color.Blue, Color.Yellow, Color.Green
            )

            for (cor in cores){
                AndroidIcon(
                    modifier = Modifier
                        .size(70.dp),
                    color = cor
                )
            }
        }
    }

    @Composable
    fun ContentContainer(modifier: Modifier = Modifier) {
        Column(
            modifier = modifier,
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Bottom
        ) {
            Image(
                modifier = Modifier
                    .size(200.dp),
                painter = painterResource(R.drawable.nave),
                contentDescription = "Nave de Combate"
            )

            Botao(
                modifier = Modifier
                    .fillMaxWidth()
                    .size(50.dp)
                    .clip(RoundedCornerShape(6.dp))
                    .padding(bottom = 2.dp)
                    .background(Color(0x45FFFCFC))
                ,
                text = "PRESS START",
                corTexto = Color.White
            )
        }
    }

    @Composable
    fun Botao(
        modifier: Modifier = Modifier,
        text: String,
        corTexto: Color
    ) {
        Row(
            modifier = modifier,
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = text,
                fontWeight = FontWeight.Bold,
                color = corTexto,
                textAlign = TextAlign.Center
            )
        }
    }

    @Composable
    fun GameOverScreen(modifier: Modifier = Modifier) {
        Box(
            modifier = modifier
                .fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            AndroidRow()
            Text(
                modifier = Modifier
                    .align(Alignment.Center)
                    .padding(0.dp, 40.dp, 0.dp, 0.dp),
                text= "GAME OVER",
                fontSize = 73.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White
            )
        }
    }
}

