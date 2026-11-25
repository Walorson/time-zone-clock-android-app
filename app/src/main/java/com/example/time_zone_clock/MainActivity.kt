package com.example.time_zone_clock

import android.content.Intent
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
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.graphics.component1
import androidx.core.graphics.component2
import com.example.time_zone_clock.ui.theme.TimezoneclockTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TimezoneclockTheme {
                val context = LocalContext.current

                // Przechowujemy zaznaczone miasta
                var selectedCities by rememberSaveable {
                    mutableStateOf(setOf<String>())
                }

                // Lista dostępnych miast
                val cities = listOf(
                    "Warsaw" to "Poland",
                    "London" to "United Kingdom",
                    "New York" to "United States",
                    "Los Angeles" to "United States",
                    "Lisbon" to "Portugal",
                    "Sydney" to "Australia",
                    "Tokyo" to "Japan",
                )

                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(Color(0xFFEDE3D0))
                        .safeDrawingPadding()
                        .padding(
                            horizontal = 16.dp,
                            vertical = 20.dp
                        )
                ) {

                    // TYTUŁ
                    Text(
                        text = "Strefy Czasowe",
                        fontSize = 30.sp,
                        fontWeight = FontWeight.Bold,
                        fontFamily = FontFamily.Serif,
                        color = Color(0xFF493725)
                    )

                    Spacer(modifier = Modifier.height(6.dp))

                    // PODTYTUŁ
                    Text(
                        text = "Wybierz strefy czasowe, które chcesz zobaczyć",
                        fontSize = 15.sp,
                        fontFamily = FontFamily.Serif,
                        color = Color(0xFF755C43)
                    )

                    Spacer(modifier = Modifier.height(20.dp))

                    // LISTA MIAST
                    LazyColumn(
                        modifier = Modifier
                            .fillMaxWidth()
                            .weight(1f),
                        verticalArrangement = Arrangement.spacedBy(12.dp)
                    ) {

                        items(cities) { (city, country) ->

                            ChoiceButton(
                                city = city,
                                country = country,
                                selectedCities = selectedCities,
                                onSelectionChange = {
                                    selectedCities = it
                                }
                            )
                        }
                    }

                    Spacer(modifier = Modifier.height(16.dp))

                    ActivityButton(
                        onClick = {
                            val intent = Intent(
                                context,
                                TimeActivity::class.java
                            )

                            context.startActivity(intent)
                        }
                    )
                }
            }
        }
    }
}