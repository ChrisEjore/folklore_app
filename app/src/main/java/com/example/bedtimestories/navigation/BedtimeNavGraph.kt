package com.example.bedtimestories.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.bedtimestories.ui.creation.StoryCreationScreen
import com.example.bedtimestories.ui.reader.StoryLibraryScreen
import com.example.bedtimestories.ui.recording.VoiceRecorderScreen

sealed class NavRoute(val route: String) {
    object Library : NavRoute("story_library")
    object StoryCreation : NavRoute("story_creation")
    object VoiceRecorder : NavRoute("voice_recorder")
}

@Composable
fun BedtimeNavGraph() {
    val navController = rememberNavController()

    Scaffold { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = NavRoute.Library.route,
            modifier = Modifier.padding(innerPadding)
        ) {
            // Main Folklore & Story Hub
            composable(NavRoute.Library.route) {
                StoryLibraryScreen(
                    onStoryClick = { story ->
                        navController.navigate(NavRoute.VoiceRecorder.route)
                    },
                    onNavigateToCreate = {
                        navController.navigate(NavRoute.StoryCreation.route)
                    },
                    onNavigateToRecord = {
                        navController.navigate(NavRoute.VoiceRecorder.route)
                    }
                )
            }

            // AI Generator Screen
            composable(NavRoute.StoryCreation.route) {
                StoryCreationScreen(
                    onStoryGenerated = { storyId ->
                        navController.navigate(NavRoute.VoiceRecorder.route)
                    }
                )
            }

            // Parental Voice Studio Screen
            composable(NavRoute.VoiceRecorder.route) {
                VoiceRecorderScreen(
                    onRecordingFinished = {
                        navController.popBackStack()
                    }
                )
            }
        }
    }
}