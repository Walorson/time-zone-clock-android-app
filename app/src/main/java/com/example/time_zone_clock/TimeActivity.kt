package com.example.time_zone_clock

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.time_zone_clock.ui.theme.TimezoneclockTheme

class TimeActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TimezoneclockTheme {
                val cities = listOf(
                    Triple("Sydney", "Australia", "+10h"),
                    Triple("London", "United Kingdom", "-1h"),
                    Triple("Tokyo", "Japan", "+8h"),
                    Triple("New York", "United States", "-6h")
                )

                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(Color(0xFFEDE3D0))
                        .safeDrawingPadding()
                        .padding(16.dp)
                ) {

                    // CZAS LOKALNY
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 24.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {

                        Text(
                            text = "Czas lokalny",
                            fontSize = 18.sp,
                            fontFamily = FontFamily.Serif,
                            color = Color(0xFF755C43)
                        )

                        Spacer(modifier = Modifier.height(8.dp))

                        Text(
                            text = "12:00:00",
                            fontSize = 48.sp,
                            fontWeight = FontWeight.Bold,
                            fontFamily = FontFamily.Serif,
                            color = Color(0xFF493725)
                        )

                        Spacer(modifier = Modifier.height(6.dp))

                        Text(
                            text = "środa, 25 listopada 2026",
                            fontSize = 15.sp,
                            fontFamily = FontFamily.Serif,
                            color = Color(0xFF755C43)
                        )
                    }

                    // SEPARATOR
                    HorizontalDivider(
                        thickness = 1.dp,
                        color = Color(0xFFB7A58B)
                    )

                    Spacer(modifier = Modifier.height(18.dp))

                    // TYTUŁ LISTY
                    Text(
                        text = "Wybrane miasta",
                        fontSize = 22.sp,
                        fontWeight = FontWeight.Bold,
                        fontFamily = FontFamily.Serif,
                        color = Color(0xFF493725)
                    )

                    Spacer(modifier = Modifier.height(14.dp))

                    // LISTA MIAST
                    LazyColumn(
                        modifier = Modifier.fillMaxWidth(),
                        verticalArrangement = Arrangement.spacedBy(12.dp)
                    ) {

                        items(cities) { city ->

                            TimeZoneButton(
                                city = city.first,
                                country = city.second,
                                time = "6:00:00",
                                offset = city.third
                            )
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting2(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview2() {
    TimezoneclockTheme {
        Greeting2("Android")
    }
}