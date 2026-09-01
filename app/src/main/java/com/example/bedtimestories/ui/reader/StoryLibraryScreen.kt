package com.example.bedtimestories.ui.reader

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AutoAwesome
import androidx.compose.material.icons.filled.Mic
import androidx.compose.material.icons.filled.MenuBook
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.bedtimestories.data.local.FolkloreLibrary
import com.example.bedtimestories.data.local.SampleStory
import com.example.bedtimestories.ui.theme.*

@Composable
fun StoryLibraryScreen(
    onStoryClick: (SampleStory) -> Unit,
    onNavigateToCreate: () -> Unit,
    onNavigateToRecord: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MidnightSky)
            .padding(16.dp)
    ) {
        // App Header & Branding
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 12.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column {
                Text(
                    text = "🌙 Tales of Africa",
                    color = WarmAmber,
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = "Folklore & Parent Bedtime Narrations",
                    color = CreamPaper.copy(alpha = 0.7f),
                    fontSize = 13.sp
                )
            }

            // Quick Parent Record Shortcut Button
            IconButton(
                onClick = onNavigateToRecord,
                modifier = Modifier
                    .clip(RoundedCornerShape(16.dp))
                    .background(SunsetOrange)
            ) {
                Icon(Icons.Default.Mic, contentDescription = "Record Narration", tint = MidnightSky)
            }
        }

        Spacer(modifier = Modifier.height(12.dp))

        // AI Generation Launcher Banner
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .clickable { onNavigateToCreate() },
            shape = RoundedCornerShape(20.dp),
            colors = CardDefaults.cardColors(containerColor = SoftPurple)
        ) {
            Row(
                modifier = Modifier.padding(16.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                Icon(Icons.Default.AutoAwesome, contentDescription = null, tint = CreamPaper, modifier = Modifier.size(32.dp))
                Column(modifier = Modifier.weight(1f)) {
                    Text("AI Story Studio", color = CreamPaper, fontWeight = FontWeight.Bold, fontSize = 16.sp)
                    Text("Generate a unique story starring your child", color = CreamPaper.copy(0.8f), fontSize = 12.sp)
                }
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "Classic Folklore Stories",
            color = WarmAmber,
            fontSize = 18.sp,
            fontWeight = FontWeight.SemiBold,
            modifier = Modifier.padding(bottom = 8.dp)
        )

        // Folklore Cards Feed
        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            items(FolkloreLibrary.stories) { story ->
                StoryCard(story = story, onClick = { onStoryClick(story) })
            }
        }
    }
}

@Composable
fun StoryCard(story: SampleStory, onClick: () -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onClick() },
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = CardNavy)
    ) {
        Row(
            modifier = Modifier.padding(16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Text(text = story.iconEmoji, fontSize = 36.sp)

            Column(modifier = Modifier.weight(1f)) {
                Text(text = story.origin.uppercase(), color = SavannahGreen, fontSize = 10.sp, fontWeight = FontWeight.Bold)
                Text(text = story.title, color = CreamPaper, fontSize = 16.sp, fontWeight = FontWeight.Bold)
                Text(text = story.summary, color = CreamPaper.copy(alpha = 0.7f), fontSize = 12.sp, maxLines = 2)
            }

            Icon(Icons.AutoMirrored.Filled.MenuBook, contentDescription = "Read", tint = WarmAmber)
        }
    }
}