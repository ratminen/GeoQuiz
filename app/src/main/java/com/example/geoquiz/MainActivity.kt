package com.example.geoquiz

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.view.WindowCompat
import com.example.geoquiz.ui.theme.GeoQuizTheme

val Purple700 = Color(0xFF6200EE)

val quizData = listOf(
    mapOf("question" to "Canberra is the capital of Australia.", "answer" to true),
    mapOf("question" to "The Pacific Ocean is larger than the Atlantic Ocean.", "answer" to true),
    mapOf("question" to "The Suez Canal connects the Red Sea and the Indian Ocean.", "answer" to false),
    mapOf("question" to "The source of the Nile River is in Egypt.", "answer" to false),
    mapOf("question" to "The Amazon River is the longest river in the Americas.", "answer" to true),
    mapOf("question" to "Lake Baikal is the world's oldest and deepest freshwater lake.", "answer" to true)
)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        WindowCompat.getInsetsController(window, window.decorView).apply {
            isAppearanceLightStatusBars = false
        }
        setContent {
            GeoQuizTheme {
                GeoQuizApp()
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GeoQuizApp(modifier: Modifier = Modifier) {
    val appBarColors = TopAppBarDefaults.centerAlignedTopAppBarColors(
        containerColor = Purple700,
        titleContentColor = Color.White
    )

    val currentQuestion = quizData[0]["question"].toString()

    Scaffold(
        modifier = modifier.fillMaxSize(),
        topBar = {
            CenterAlignedTopAppBar(
                title = { Text("GeoQuiz") },
                colors = appBarColors
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .background(Color.White)
                .padding(horizontal = 24.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Вопрос
            Text(
                text = currentQuestion,
                textAlign = TextAlign.Center,
                fontSize = 18.sp,
                modifier = Modifier.padding(bottom = 48.dp)
            )

            // Кнопки
            QuizButtons()
        }
    }
}

@Composable
fun QuizButtons() {
    Column(
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row (modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Button(onClick = { /* без логики */ }) {
                Text("TRUE")
            }

            Button(onClick = { /* без логики */ }) {
                Text("FALSE")
            }
        }

        Button(
            onClick = { /* без логики */ },
            enabled = false
        ) {
            Text("NEXT")
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GeoQuizAppPreview() {
    GeoQuizTheme {
        GeoQuizApp()
    }
}