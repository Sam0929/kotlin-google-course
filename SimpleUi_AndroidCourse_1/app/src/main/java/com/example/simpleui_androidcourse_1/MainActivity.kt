package com.example.simpleui_androidcourse_1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.simpleui_androidcourse_1.ui.theme.SimpleUi_AndroidCourse_1Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SimpleUi_AndroidCourse_1Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Background(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Background(modifier: Modifier = Modifier) {

    Column(){
        Image(
            painter = painterResource(R.drawable.bg_compose_background),
            contentDescription = null
        )
        BodyText(modifier)
    }

}

@Composable
fun BodyText(modifier: Modifier = Modifier){

    Column (modifier = Modifier.padding(10.dp)){
        Text(
            text = stringResource(R.string.title),
            color = Color.Black,
            fontSize = 24.sp,
            modifier = Modifier.padding(8.dp)

        )
        Text(
            text = stringResource(R.string.subtitile),
            color = Color.Black,
            textAlign = TextAlign.Justify,

            modifier = Modifier.padding(8.dp)
        )
        Text(
            text = stringResource(R.string.description),
            color = Color.Black,
            textAlign = TextAlign.Justify,
            modifier = Modifier.padding(8.dp)
        )
    }

}

@Preview(showBackground = true)
@Composable
fun BackgroundPreview() {
    SimpleUi_AndroidCourse_1Theme {
        Background()
    }
}