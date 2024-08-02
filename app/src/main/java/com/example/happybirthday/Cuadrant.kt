package com.example.happybirthday

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.happybirthday.ui.theme.HappyBirthdayTheme

class Cuadrant : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            HappyBirthdayTheme {
                Surface(modifier = Modifier.fillMaxSize()) {

                }
            }
        }
    }
}

@Composable
fun CuadrantScreen() {
    Column(modifier = Modifier.fillMaxSize()) {
        CuadrantRow(
            0.5F,
            stringResource(R.string.text_composable),
            stringResource(R.string.content_cuadrant_1),
            stringResource(R.string.image_composable),
            stringResource(R.string.content_cuadrant_2),
            backgroundColorC1 = Color(0xFFEADDFF),
            backgroundColorC2 = Color(0xFFD0BCFF)
        )
        CuadrantRow(
            titleC1 = stringResource(R.string.row_composable),
            contentC1 = stringResource(R.string.content_cuadrant_3),
            titleC2 = stringResource(R.string.column_composable),
            contentC2 = stringResource(R.string.content_cuadrant_4),
            backgroundColorC1 = Color(0xFFB69DF8),
            backgroundColorC2 = Color(0xFFF6EDFF)
        )
    }
}

@Composable
fun CuadrantRow(
    cuadrantHeigth: Float = 1F,
    titleC1: String,
    contentC1: String,
    titleC2: String,
    contentC2: String,
    backgroundColorC1 : Color,
    backgroundColorC2 : Color
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(cuadrantHeigth)
    ) {
        CuadrantContent(
            titleC1,
            contentC1,
            backgroundColorC1,
            0.5F
        )
        CuadrantContent(
            titleC2,
            contentC2,
            backgroundColorC2
        )
    }
}

@Composable
fun CuadrantContent( title: String, content: String, backgroundColor: Color, width: Float = 1F){
    Column(
        modifier = Modifier
            .background(backgroundColor)
            .fillMaxWidth(width)
            .fillMaxHeight()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Text(
            text = title,
            fontWeight = FontWeight.Bold,
            modifier =  Modifier.padding(bottom = 16.dp)
        )
        Text(
            text = content,
            textAlign = TextAlign.Justify
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview3() {
    HappyBirthdayTheme {
        CuadrantScreen()
    }
}