package com.example.bedtimestories.ui.reader

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.FormatSize
import androidx.compose.material.icons.filled.Pause
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.RecordVoiceOver
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.bedtimestories.data.local.SampleStory
import com.example.bedtimestories.ui.theme.*

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun StoryDetailScreen(
    story: SampleStory,
    onBackClick: () -> Unit,
    onRecordOwnVoice: () -> Unit
) {
    var isPlayingNarration by remember { mutableStateOf(false) }
    var fontSizeSp by remember { mutableStateOf(18) }
    var showFontSlider by remember { mutableStateOf(false) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(story.title, color = WarmAmber, fontSize = 18.sp, fontWeight = FontWeight.Bold) },
                navigationIcon = {
                    IconButton(onClick = onBackClick) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Back", tint = CreamPaper)
                    }
                },
                actions = {
                    // Text Size Toggle Button
                    IconButton(onClick = { showFontSlider = !showFontSlider }) {
                        Icon(Icons.Default.FormatSize, contentDescription = "Adjust Font Size", tint = CreamPaper)
                    }
                    // Record Custom Voice Button
                    IconButton(onClick = onRecordOwnVoice) {
                        Icon(Icons.Default.RecordVoiceOver, contentDescription = "Record Voice", tint = SunsetOrange)
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(containerColor = MidnightSky)
            )
        },
        bottomBar = {
            // Audio Narration Control Bar
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
                            if (isPlayingNarration) "Playing narration..." else "Tap play to listen to bedtime audio",
                            color = CreamPaper.copy(alpha = 0.7f),
                            fontSize = 12.sp
                        )
                    }

                    IconButton(
                        onClick = { isPlayingNarration = !isPlayingNarration },
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
        containerColor = MidnightSky
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(horizontal = 20.dp)
        ) {
            // Font Size Adjustment Control (Collapsible)
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

            // Reader Document Content
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .verticalScroll(rememberScrollState())
                    .padding(vertical = 16.dp)
            ) {
                Text(
                    text = "${story.iconEmoji} ${story.origin}",
                    color = SavannahGreen,
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Bold
                )

                Spacer(modifier = Modifier.height(8.dp))

                Text(
                    text = story.content,
                    color = CreamPaper,
                    fontSize = fontSizeSp.sp,
                    lineHeight = (fontSizeSp * 1.5).sp,
                    fontWeight = FontWeight.Normal
                )

                Spacer(modifier = Modifier.height(40.dp))
            }
        }
    }
}