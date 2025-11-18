package com.example.a1000sabores

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.a1000sabores.ui.navigation.AppNav
import com.example.a1000sabores.ui.theme._1000saboresTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            _1000saboresTheme {
                AppNav()
            }
        }
    }
}
