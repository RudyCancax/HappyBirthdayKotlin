package com.example.happybirthday

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

import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape

import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.happybirthday.ui.theme.HappyBirthdayTheme

class BusinessCard : ComponentActivity() {
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
fun BusinessScreen(){
    val image = painterResource(id = R.drawable.ic_launcher_foreground)

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Bottom
    ) {
        TopSection(image)
        val imageBottomSection = painterResource(id = R.drawable.ic_task_completed)
        BottomSection(
            image = imageBottomSection
        )
    }
}

@Composable
fun TopSection(image: Painter){
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 120.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = image,
            contentDescription = "Header screen image.",
            contentScale = ContentScale.FillWidth,
            modifier = Modifier
                .padding(16.dp)
                .background(Color.Green)
                .fillMaxWidth()
        )
        Text(
            text = "Jenifer Doe",
            fontSize = 46.sp,
            fontWeight = FontWeight.SemiBold
        )
        Text(
            text = "Android Developer Extraordinaire",
            fontSize = 15.sp,
            color = Color(0xFF3ddc84),
            fontWeight = FontWeight.Bold
        )
    }
}

@Composable
fun BottomSection(image: Painter){
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(10.dp))
            .background(Color.DarkGray)
    ){
        Column(
            modifier = Modifier
                .align(Alignment.Center)
                .padding(bottom = 20.dp)
        ) {
            BottomItem(image, "+ 11 (123) 444 555 666")
            BottomItem(image, "@AndroidDev")
            BottomItem(image, "jenifer.doe@gmail.com")
        }
    }
}

@Composable
fun BottomItem( image : Painter, content: String){
    Row(
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = image,
            contentDescription = "Header screen image.",
            contentScale = ContentScale.FillWidth,
            modifier = Modifier
                .padding(16.dp)
                .width(30.dp)

        )
        Text(text = content, color = Color.White, fontWeight = FontWeight.ExtraBold)
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview4() {
    HappyBirthdayTheme {
        BusinessScreen()
    }
}