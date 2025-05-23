package com.example.multipageapp.ui

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.ui.unit.dp

@Composable
fun DashboardScreen() {
    Text(
        text = "This is the Dashboard Page",
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp)
    )
}
