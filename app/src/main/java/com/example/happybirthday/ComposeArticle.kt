package com.example.happybirthday

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.happybirthday.ui.theme.HappyBirthdayTheme

class ComposeArticle : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            HappyBirthdayTheme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    Column {
                        TitleSection()
                    }
                }
            }
        }
    }
}

@Composable
fun TitleSection(
    titleContent: String = "Jetpack Compose tutorial"
) {
    Text(
        text = titleContent,
        fontSize = 24.sp,
        modifier = Modifier.padding(16.dp)
    )
}

@Composable
fun ParagraphSection(
    content: String = "Lorem Ipsum..."
) {
    Text(
        text = content,
        textAlign = TextAlign.Justify,
        modifier = Modifier.padding(16.dp)
    )
}

@Composable
fun ImageSection( imageId : Int, imageDescription : String? ) {
    val image = painterResource(id = imageId)
    Image(
        painter = image,
        contentDescription = imageDescription,
        contentScale = ContentScale.FillWidth,
        modifier = Modifier.padding(16.dp)
    )
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingPreview() {
    val content =
        "Jetpack Compose is a modern toolkit for building native Android UI. Compose simplifies and accelerates UI development on Android with less code, powerful tools, and intuitive Kotlin APIs."
    HappyBirthdayTheme {
        Column {
            val image = R.drawable.bg_compose_background
            ImageSection(image, null)
            TitleSection()
            ParagraphSection(
                content = content
            )
            ParagraphSection(
                content = "In this tutorial, you build a simple UI component with declarative functions. You call Compose functions to say what elements you want and the Compose compiler does the rest. Compose is built around Composable functions. These functions let you define your app\\'s UI programmatically because they let you describe how it should look and provide data dependencies, rather than focus on the process of the UI\\'s construction, such as initializing an element and then attaching it to a parent. To create a Composable function, you add the @Composable annotation to the function name."
            )
        }
    }
}