package com.example.time_zone_clock

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ActivityButton(
    text: String,
    onClick: () -> Unit = {}
) {
    Button(
        onClick = onClick,
        modifier = Modifier.fillMaxWidth().padding(10.dp)
    ) {
        Text(
            text = text,
            fontSize = 25.sp,
            fontWeight = FontWeight.Bold
        )
    }
}