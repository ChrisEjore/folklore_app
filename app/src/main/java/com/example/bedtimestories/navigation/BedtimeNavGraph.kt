package com.example.bedtimestories.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.bedtimestories.data.local.FolkloreLibrary
import com.example.bedtimestories.ui.creation.StoryCreationScreen
import com.example.bedtimestories.ui.reader.StoryDetailScreen
import com.example.bedtimestories.ui.reader.StoryLibraryScreen
import com.example.bedtimestories.ui.recording.VoiceRecorderScreen

sealed class NavRoute(val route: String) {
    object Library : NavRoute("story_library")
    object StoryDetail : NavRoute("story_detail/{storyId}") {
        fun createRoute(storyId: String) = "story_detail/$storyId"
    }
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
            // Story Library Feed
            composable(NavRoute.Library.route) {
                StoryLibraryScreen(
                    onStoryClick = { story ->
                        navController.navigate(NavRoute.StoryDetail.createRoute(story.id))
                    },
                    onNavigateToCreate = {
                        navController.navigate(NavRoute.StoryCreation.route)
                    },
                    onNavigateToRecord = {
                        navController.navigate(NavRoute.VoiceRecorder.route)
                    }
                )
            }

            // Reader & Narrator View
            composable(
                route = NavRoute.StoryDetail.route,
                arguments = listOf(navArgument("storyId") { type = NavType.StringType })
            ) { backStackEntry ->
                val storyId = backStackEntry.arguments?.getString("storyId")
                val story = FolkloreLibrary.stories.find { it.id == storyId }
                    ?: FolkloreLibrary.stories.first()

                StoryDetailScreen(
                    story = story,
                    onBackClick = { navController.popBackStack() },
                    onRecordOwnVoice = { navController.navigate(NavRoute.VoiceRecorder.route) }
                )
            }

            // AI Generator Screen
            composable(NavRoute.StoryCreation.route) {
                StoryCreationScreen(
                    onStoryGenerated = { storyId ->
                        navController.navigate(NavRoute.StoryDetail.createRoute(storyId))
                    }
                )
            }

            // Voice Studio Screen
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