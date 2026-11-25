package com.example.time_zone_clock

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun ChoiceButton(
    city: String,
    country: String,
    selectedCities: Set<String>,
    onSelectionChange: (Set<String>) -> Unit
) {
    val selected = city in selectedCities

    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .height(85.dp),
        onClick = {
            val newSelection =
                if (selected) {
                    selectedCities - city
                } else {
                    selectedCities + city
                }

            onSelectionChange(newSelection)
        },
        shape = RoundedCornerShape(10.dp),
        color = Color(0xFFE8D9BF),
        border = BorderStroke(
            width = if (selected) 3.dp else 1.dp,
            color = if (selected)
                Color(0xFF604832)
            else
                Color(0xFFB7A58B)
        )
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = city,
                fontSize = 21.sp,
                fontWeight = FontWeight.SemiBold,
                fontFamily = FontFamily.Serif,
                color = Color(0xFF493725)
            )

            Text(
                text = country,
                fontSize = 13.sp,
                fontFamily = FontFamily.Serif,
                color = Color(0xFF755C43)
            )
        }
    }
}