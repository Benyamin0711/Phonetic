package com.benyaminrasouli.phonetic.ui.kaypad

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun KaypadScreen() {
    // Sample ViewModel usage (can be extended)
    // val viewModel: ProfileViewModel = ...

    Surface(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxSize()
        ) {
            Text(text = "صفحه پروفایل", style = MaterialTheme.typography.headlineMedium)
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = "نام کاربر: تستی", style = MaterialTheme.typography.bodyLarge)
        }
    }
}