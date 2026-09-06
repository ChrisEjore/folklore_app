package com.example.bedtimestories.ui.reader

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Mic
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.bedtimestories.data.local.FolkloreLibrary
import com.example.bedtimestories.data.local.SampleStory
import com.example.bedtimestories.ui.theme.*

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun StoryLibraryScreen(
    onStoryClick: (SampleStory) -> Unit,
    onNavigateToCreate: () -> Unit,
    onNavigateToRecord: () -> Unit
) {
    var maxAge by remember { mutableStateOf(18) }
    var showAgePicker by remember { mutableStateOf(false) }

    val filteredStories = FolkloreLibrary.stories.filter { it.minAge <= maxAge }
    val genres = listOf("Fables", "Myths", "Action", "Adventure", "Thriller", "Horror", "Romance")

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Bedtime Stories", color = WarmAmber, fontWeight = FontWeight.Bold) },
                actions = {
                    IconButton(onClick = { showAgePicker = true }) {
                        Icon(Icons.Default.Settings, contentDescription = "Parental Controls", tint = CreamPaper)
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(containerColor = MidnightSky)
            )
        },
        floatingActionButton = {
            Column(horizontalAlignment = Alignment.End) {
                FloatingActionButton(
                    onClick = onNavigateToRecord,
                    containerColor = SunsetOrange,
                    contentColor = MidnightSky,
                    modifier = Modifier.padding(bottom = 16.dp)
                ) {
                    Icon(Icons.Default.Mic, contentDescription = "Record Voice")
                }
                FloatingActionButton(
                    onClick = onNavigateToCreate,
                    containerColor = SavannahGreen,
                    contentColor = MidnightSky
                ) {
                    Icon(Icons.Default.Add, contentDescription = "Create Story")
                }
            }
        },
        containerColor = MidnightSky
    ) { innerPadding ->
        if (showAgePicker) {
            AlertDialog(
                onDismissRequest = { showAgePicker = false },
                title = { Text("Parental Controls", color = MidnightSky) },
                text = {
                    Column {
                        Text("Show stories for age up to: $maxAge", color = MidnightSky)
                        Slider(
                            value = maxAge.toFloat(),
                            onValueChange = { maxAge = it.toInt() },
                            valueRange = 3f..18f
                        )
                    }
                },
                confirmButton = {
                    TextButton(onClick = { showAgePicker = false }) {
                        Text("Done")
                    }
                }
            )
        }

        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            verticalArrangement = Arrangement.spacedBy(24.dp),
            contentPadding = PaddingValues(vertical = 16.dp)
        ) {
            // User Stories Section (Recorded & Written)
            val userStories = filteredStories.filter { it.isUserCreated }
            if (userStories.isNotEmpty()) {
                item {
                    SectionHeader("Your Recordings & Creations")
                    LazyRow(
                        modifier = Modifier.fillMaxWidth(),
                        contentPadding = PaddingValues(horizontal = 16.dp),
                        horizontalArrangement = Arrangement.spacedBy(12.dp)
                    ) {
                        items(userStories, key = { it.id }) { story ->
                            StoryThumbnail(
                                story = story, 
                                onClick = { onStoryClick(story) },
                                onDeleteClick = { FolkloreLibrary.deleteStory(story.id) }
                            )
                        }
                    }
                }
            }

            // Genre Sections
            genres.forEach { genre ->
                val genreStories = filteredStories.filter { it.genre == genre }
                if (genreStories.isNotEmpty()) {
                    item {
                        SectionHeader(genre)
                        LazyRow(
                            modifier = Modifier.fillMaxWidth(),
                            contentPadding = PaddingValues(horizontal = 16.dp),
                            horizontalArrangement = Arrangement.spacedBy(12.dp)
                        ) {
                            items(genreStories, key = { it.id }) { story ->
                                StoryThumbnail(story = story, onClick = { onStoryClick(story) })
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun SectionHeader(title: String) {
    Text(
        text = title,
        color = CreamPaper,
        fontSize = 20.sp,
        fontWeight = FontWeight.ExtraBold,
        modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp)
    )
}

@Composable
fun StoryThumbnail(
    story: SampleStory, 
    onClick: () -> Unit,
    onDeleteClick: (() -> Unit)? = null
) {
    Card(
        modifier = Modifier
            .width(160.dp)
            .height(220.dp)
            .clickable(onClick = onClick),
        colors = CardDefaults.cardColors(containerColor = CardNavy),
        shape = RoundedCornerShape(12.dp)
    ) {
        Column {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(140.dp)
            ) {
                AsyncImage(
                    model = story.imageUrl,
                    contentDescription = null,
                    modifier = Modifier.fillMaxSize(),
                    contentScale = ContentScale.Crop
                )
                
                // Genre badge
                Surface(
                    modifier = Modifier.padding(8.dp).align(Alignment.TopEnd),
                    color = MidnightSky.copy(alpha = 0.7f),
                    shape = RoundedCornerShape(4.dp)
                ) {
                    Text(
                        text = story.genre,
                        color = WarmAmber,
                        fontSize = 10.sp,
                        modifier = Modifier.padding(horizontal = 4.dp, vertical = 2.dp)
                    )
                }

                if (onDeleteClick != null) {
                    IconButton(
                        onClick = onDeleteClick,
                        modifier = Modifier.align(Alignment.TopStart).size(32.dp).background(MidnightSky.copy(alpha = 0.5f), RoundedCornerShape(bottomEnd = 8.dp))
                    ) {
                        Icon(Icons.Default.Delete, contentDescription = "Delete", tint = RecordRed, modifier = Modifier.size(16.dp))
                    }
                }
            }
            
            Column(modifier = Modifier.padding(8.dp)) {
                Text(
                    text = story.title,
                    color = CreamPaper,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold,
                    maxLines = 2
                )
                Spacer(modifier = Modifier.weight(1f))
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text(story.iconEmoji, fontSize = 12.sp)
                    Spacer(modifier = Modifier.width(4.dp))
                    Text(
                        text = "Age ${story.minAge}+",
                        color = SavannahGreen,
                        fontSize = 10.sp
                    )
                }
            }
        }
    }
}
