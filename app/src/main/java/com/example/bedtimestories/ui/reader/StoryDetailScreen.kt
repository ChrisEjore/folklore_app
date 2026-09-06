package com.example.bedtimestories.ui.reader

import android.speech.tts.TextToSpeech
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.FormatSize
import androidx.compose.material.icons.filled.Pause
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.RecordVoiceOver
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.bedtimestories.data.local.FolkloreLibrary
import com.example.bedtimestories.data.local.SampleStory
import com.example.bedtimestories.ui.theme.*
import java.util.Locale

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun StoryDetailScreen(
    story: SampleStory,
    onBackClick: () -> Unit,
    onRecordOwnVoice: () -> Unit
) {
    val context = LocalContext.current
    var isPlayingNarration by remember { mutableStateOf(false) }
    var fontSizeSp by remember { mutableStateOf(18) }
    var showFontSlider by remember { mutableStateOf(false) }
    var showDeleteDialog by remember { mutableStateOf(false) }
    var ttsEngine by remember { mutableStateOf<TextToSpeech?>(null) }

    DisposableEffect(context) {
        val tts = TextToSpeech(context) { status ->
            if (status == TextToSpeech.SUCCESS) {
                // Try to find a natural female voice (like 'Zara')
                val femaleVoice = ttsEngine?.voices?.find { 
                    it.name.lowercase().contains("female") || it.name.lowercase().contains("en-us-x-sfg") 
                }
                if (femaleVoice != null) {
                    ttsEngine?.voice = femaleVoice
                } else {
                    ttsEngine?.language = Locale.US
                }
                ttsEngine?.setPitch(story.pitch)
                ttsEngine?.setSpeechRate(story.speechRate)
            }
        }
        ttsEngine = tts

        onDispose {
            tts.stop()
            tts.shutdown()
        }
    }

    // Delete Confirmation Dialog
    if (showDeleteDialog) {
        AlertDialog(
            onDismissRequest = { showDeleteDialog = false },
            title = { Text("Delete Story?", color = WarmAmber, fontWeight = FontWeight.Bold) },
            text = { Text("Are you sure you want to delete this custom story? This action cannot be undone.", color = CreamPaper) },
            confirmButton = {
                TextButton(
                    onClick = {
                        ttsEngine?.stop()
                        FolkloreLibrary.deleteStory(story.id)
                        showDeleteDialog = false
                        onBackClick()
                    }
                ) {
                    Text("Delete", color = RecordRed, fontWeight = FontWeight.Bold)
                }
            },
            dismissButton = {
                TextButton(onClick = { showDeleteDialog = false }) {
                    Text("Cancel", color = CreamPaper)
                }
            },
            containerColor = CardNavy
        )
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(story.title, color = WarmAmber, fontSize = 18.sp, fontWeight = FontWeight.Bold) },
                navigationIcon = {
                    IconButton(onClick = {
                        ttsEngine?.stop()
                        onBackClick()
                    }) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Back", tint = CreamPaper)
                    }
                },
                actions = {
                    IconButton(onClick = { showFontSlider = !showFontSlider }) {
                        Icon(Icons.Default.FormatSize, contentDescription = "Adjust Font Size", tint = CreamPaper)
                    }
                    IconButton(onClick = onRecordOwnVoice) {
                        Icon(Icons.Default.RecordVoiceOver, contentDescription = "Record Voice", tint = SunsetOrange)
                    }
                    // Display Delete button only for self-created stories
                    if (story.isUserCreated) {
                        IconButton(onClick = { showDeleteDialog = true }) {
                            Icon(Icons.Default.Delete, contentDescription = "Delete Story", tint = RecordRed)
                        }
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(containerColor = MidnightSky)
            )
        },
        bottomBar = {
            Surface(
                modifier = Modifier.fillMaxWidth(),
                color = CardNavy,
                shadowElevation = 8.dp
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Column(modifier = Modifier.weight(1f)) {
                        Text("Audio Narrator", color = WarmAmber, fontSize = 14.sp, fontWeight = FontWeight.Bold)
                        Text(
                            if (isPlayingNarration) "Narrating story aloud..." else "Tap play to hear the narrator",
                            color = CreamPaper.copy(alpha = 0.7f),
                            fontSize = 12.sp
                        )
                    }

                    IconButton(
                        onClick = {
                            if (isPlayingNarration) {
                                ttsEngine?.stop()
                                isPlayingNarration = false
                            } else {
                                // Strip image tags for TTS
                                val cleanContent = story.content.replace(Regex("\\[img:.*?\\]"), "")
                                ttsEngine?.setPitch(story.pitch)
                                ttsEngine?.setSpeechRate(story.speechRate)
                                ttsEngine?.speak(cleanContent, TextToSpeech.QUEUE_FLUSH, null, "StoryTTS")
                                isPlayingNarration = true
                            }
                        },
                        modifier = Modifier
                            .size(48.dp)
                            .clip(CircleShape)
                            .background(if (isPlayingNarration) SunsetOrange else SavannahGreen)
                    ) {
                        Icon(
                            imageVector = if (isPlayingNarration) Icons.Default.Pause else Icons.Default.PlayArrow,
                            contentDescription = if (isPlayingNarration) "Pause" else "Play",
                            tint = MidnightSky
                        )
                    }
                }
            }
        },
        containerColor = Color.Transparent
    ) { innerPadding ->
        val bgColor = when (story.genre) {
            "Fables" -> SavannahGreen.copy(alpha = 0.15f)
            "Myths" -> SoftPurple.copy(alpha = 0.15f)
            "Action" -> RecordRed.copy(alpha = 0.1f)
            "Romance" -> SunsetOrange.copy(alpha = 0.15f)
            "Horror" -> Color.Black
            "Thriller" -> CardNavy
            else -> MidnightSky
        }

        Box(modifier = Modifier.fillMaxSize().background(
            androidx.compose.ui.graphics.Brush.verticalGradient(
                colors = listOf(MidnightSky, bgColor, MidnightSky)
            )
        )) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding)
                    .padding(horizontal = 20.dp)
            ) {
            AnimatedVisibility(visible = showFontSlider) {
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 8.dp),
                    colors = CardDefaults.cardColors(containerColor = CardNavy),
                    shape = RoundedCornerShape(12.dp)
                ) {
                    Row(
                        modifier = Modifier.padding(12.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text("Text Size", color = CreamPaper, fontSize = 14.sp, modifier = Modifier.padding(end = 12.dp))
                        Slider(
                            value = fontSizeSp.toFloat(),
                            onValueChange = { fontSizeSp = it.toInt() },
                            valueRange = 14f..32f,
                            modifier = Modifier.weight(1f)
                        )
                        Text("${fontSizeSp}sp", color = WarmAmber, fontSize = 14.sp, modifier = Modifier.padding(start = 12.dp))
                    }
                }
            }

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .verticalScroll(rememberScrollState())
                    .padding(vertical = 16.dp)
            ) {
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(200.dp),
                    shape = RoundedCornerShape(16.dp)
                ) {
                    AsyncImage(
                        model = story.imageUrl,
                        contentDescription = null,
                        modifier = Modifier.fillMaxSize(),
                        contentScale = ContentScale.Crop
                    )
                }

                Spacer(modifier = Modifier.height(16.dp))

                Text(
                    text = "${story.iconEmoji} ${story.origin} • ${story.genre} • Age ${story.minAge}+",
                    color = SavannahGreen,
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Bold
                )

                Spacer(modifier = Modifier.height(16.dp))

                // Parse content for images
                val parts = remember(story.content) {
                    val regex = Regex("\\[img:(.*?)\\]")
                    val matches = regex.findAll(story.content)
                    val result = mutableListOf<Pair<String, String?>>()
                    var lastIndex = 0
                    for (match in matches) {
                        result.add(story.content.substring(lastIndex, match.range.first) to null)
                        result.add("" to match.groupValues[1])
                        lastIndex = match.range.last + 1
                    }
                    if (lastIndex < story.content.length) {
                        result.add(story.content.substring(lastIndex) to null)
                    }
                    result
                }

                parts.forEach { (text, imageUrl) ->
                    if (imageUrl != null) {
                        Card(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(180.dp)
                                .padding(vertical = 12.dp),
                            shape = RoundedCornerShape(12.dp),
                            elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
                        ) {
                            AsyncImage(
                                model = imageUrl,
                                contentDescription = "Story Illustration",
                                modifier = Modifier.fillMaxSize(),
                                contentScale = ContentScale.Crop
                            )
                        }
                    } else if (text.isNotBlank()) {
                        Text(
                            text = text.trim(),
                            color = CreamPaper,
                            fontSize = fontSizeSp.sp,
                            lineHeight = (fontSizeSp * 1.5).sp,
                            fontWeight = FontWeight.Normal
                        )
                        Spacer(modifier = Modifier.height(12.dp))
                    }
                }

                story.moralLesson?.let { lesson ->
                    Spacer(modifier = Modifier.height(24.dp))
                    Card(
                        modifier = Modifier.fillMaxWidth(),
                        colors = CardDefaults.cardColors(containerColor = SunsetOrange.copy(alpha = 0.1f)),
                        border = androidx.compose.foundation.BorderStroke(1.dp, SunsetOrange),
                        shape = RoundedCornerShape(12.dp)
                    ) {
                        Column(modifier = Modifier.padding(16.dp)) {
                            Text(
                                text = "Moral Lesson",
                                color = SunsetOrange,
                                fontSize = 14.sp,
                                fontWeight = FontWeight.Bold
                            )
                            Spacer(modifier = Modifier.height(4.dp))
                            Text(
                                text = lesson,
                                color = CreamPaper,
                                fontSize = (fontSizeSp - 2).sp,
                                fontWeight = FontWeight.Medium
                            )
                        }
                    }
                }

                Spacer(modifier = Modifier.height(40.dp))
            }
        }
    }
}
}
