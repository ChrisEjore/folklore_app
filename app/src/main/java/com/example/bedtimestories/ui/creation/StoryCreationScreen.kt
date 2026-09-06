package com.example.bedtimestories.ui.creation

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.AutoAwesome
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.bedtimestories.data.local.FolkloreLibrary
import com.example.bedtimestories.data.local.SampleStory
import com.example.bedtimestories.ui.theme.*

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun StoryCreationScreen(
    onBackClick: () -> Unit,
    onStoryGenerated: (String) -> Unit
) {
    var childName by remember { mutableStateOf("") }
    var selectedTheme by remember { mutableStateOf("Savannah Safari") }
    var customPrompt by remember { mutableStateOf("") }
    var isGenerating by remember { mutableStateOf(false) }

    val themes = listOf("Savannah Safari", "Magic Forest", "Starlight Space", "Underwater Kingdom")

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("AI Story Writer", color = WarmAmber, fontWeight = FontWeight.Bold) },
                navigationIcon = {
                    IconButton(onClick = onBackClick) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Back", tint = CreamPaper)
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(containerColor = MidnightSky)
            )
        },
        containerColor = MidnightSky
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .verticalScroll(rememberScrollState())
                .padding(20.dp),
            verticalArrangement = Arrangement.spacedBy(20.dp)
        ) {
            // Notebook Card Form
            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(20.dp),
                colors = CardDefaults.cardColors(containerColor = CreamPaper)
            ) {
                Column(
                    modifier = Modifier.padding(20.dp),
                    verticalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    Text("📖 Bedtime Story Notebook", color = MidnightSky, fontSize = 20.sp, fontWeight = FontWeight.Bold)

                    OutlinedTextField(
                        value = childName,
                        onValueChange = { childName = it },
                        label = { Text("Child's Name (Hero)") },
                        modifier = Modifier.fillMaxWidth(),
                        singleLine = true,
                        colors = OutlinedTextFieldDefaults.colors(
                            focusedBorderColor = SunsetOrange,
                            unfocusedBorderColor = MidnightSky.copy(alpha = 0.5f),
                            focusedLabelColor = SunsetOrange
                        )
                    )

                    Text("Select World Theme:", color = MidnightSky, fontSize = 14.sp, fontWeight = FontWeight.Bold)
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        themes.take(2).forEach { theme ->
                            FilterChip(
                                selected = selectedTheme == theme,
                                onClick = { selectedTheme = theme },
                                label = { Text(theme) },
                                colors = FilterChipDefaults.filterChipColors(
                                    selectedContainerColor = SoftPurple,
                                    selectedLabelColor = CreamPaper
                                )
                            )
                        }
                    }

                    OutlinedTextField(
                        value = customPrompt,
                        onValueChange = { customPrompt = it },
                        label = { Text("Special Details (e.g. loves elephants, bedtime lesson)") },
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(120.dp),
                        colors = OutlinedTextFieldDefaults.colors(
                            focusedBorderColor = SunsetOrange,
                            unfocusedBorderColor = MidnightSky.copy(alpha = 0.5f)
                        )
                    )
                }
            }

            // Generate Button Action
            Button(
                onClick = {
                    isGenerating = true

                    val generatedId = "ai_story_${System.currentTimeMillis()}"
                    val heroName = childName.ifBlank { "Little Hero" }

                    val newStory = SampleStory(
                        id = generatedId,
                        title = "$heroName and the $selectedTheme",
                        origin = "AI Personalized Tale",
                        category = "Parent Created",
                        genre = "Adventure", // Default for AI stories
                        minAge = 3,          // Default for AI stories
                        readTime = "3 min read",
                        summary = "A magical bedtime adventure featuring $heroName in the $selectedTheme.",
                        iconEmoji = "✨",
                        imageUrl = "https://images.unsplash.com/photo-1451187580459-43490279c0fa?q=80&w=400",
                        content = """
Once upon a time, deep inside the $selectedTheme, there lived a brave explorer named $heroName. 

$heroName loved exploring new places and making friends with all the magical creatures. ${if (customPrompt.isNotBlank()) "During this adventure: $customPrompt." else ""}

As the evening stars began to shimmer in the sky, $heroName curled up under the warm moonlight, feeling peaceful and ready for sweet dreams. The end.
                        """.trimIndent(),
                        moralLesson = "Adventure is better when shared with friends and ends with a good rest.",
                        isUserCreated = true // Marks story as eligible for deletion
                    )

                    FolkloreLibrary.addStory(newStory)
                    onStoryGenerated(generatedId)
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(56.dp),
                shape = RoundedCornerShape(28.dp),
                colors = ButtonDefaults.buttonColors(containerColor = SoftPurple, contentColor = CreamPaper)
            ) {
                if (isGenerating) {
                    CircularProgressIndicator(color = CreamPaper, modifier = Modifier.size(24.dp))
                } else {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Icon(Icons.Default.AutoAwesome, contentDescription = null)
                        Spacer(modifier = Modifier.width(8.dp))
                        Text("Write & Magic Generate", fontSize = 16.sp, fontWeight = FontWeight.Bold)
                    }
                }
            }
        }
    }
}
