package com.example.bedtimestories

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.bedtimestories.navigation.BedtimeNavGraph
import com.example.bedtimestories.ui.theme.BedtimeStoriesTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BedtimeStoriesTheme {
                BedtimeNavGraph()
            }
        }
    }
}