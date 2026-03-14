package com.example.android_course_3


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.android_course_3.ui.theme.Android_course_3Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Android_course_3Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Quad_Screen(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Quad_Screen( modifier: Modifier = Modifier) {

    Column(modifier = modifier.fillMaxSize()) {

        Row (modifier = Modifier.weight(1f)){
            Text_Format(
                stringResource(R.string.first_quad),
                stringResource(R.string.content_1),
                backgroundColor = Color(0xFFEADDFF),
                modifier = Modifier.weight(1f)
            )

            Text_Format(
                stringResource(R.string.second_quad),
                stringResource(R.string.content_2),
                backgroundColor = Color(0xFFD0BCFF),
                modifier = Modifier.weight(1f)
            )
        }

        Row (modifier = Modifier.weight(1f)){
            Text_Format(
                stringResource(R.string.third_quad),
                stringResource(R.string.content_3),
                backgroundColor = Color(0xFFD0BCFF),
                modifier = Modifier.weight(1f)

                )

            Text_Format(
                stringResource(R.string.fourth_quad),
                stringResource(R.string.content_4),
                backgroundColor = Color(0xFFF6EDFF),
                modifier = Modifier.weight(1f)

                )
        }
    }
}

@Composable
fun Text_Format(title: String, text: String, backgroundColor: Color, modifier: Modifier = Modifier){
    Column (
        modifier = modifier
        .fillMaxSize()
        .background(backgroundColor)
        .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Text(
            text = title,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 16.dp)
        )
        Text(
            text = text,
            textAlign = TextAlign.Justify,
        )
    }

}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Android_course_3Theme {
        Quad_Screen()
    }
}