package com.benyaminrasouli.phonetic

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.benyaminrasouli.phonetic.navigation.AppNavigation
import com.benyaminrasouli.phonetic.ui.theme.PhoneticTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PhoneticTheme {
                AppNavigation()
            }
        }
    }
}