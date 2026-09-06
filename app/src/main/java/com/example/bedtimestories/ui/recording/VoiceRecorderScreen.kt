package com.example.bedtimestories.ui.recording

import android.Manifest
import android.content.pm.PackageManager
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.animation.core.*
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.GraphicEq
import androidx.compose.material.icons.filled.Mic
import androidx.compose.material.icons.filled.Stop
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import android.media.MediaRecorder
import androidx.core.content.ContextCompat
import com.example.bedtimestories.data.local.FolkloreLibrary
import com.example.bedtimestories.data.local.SampleStory
import com.example.bedtimestories.ui.theme.*
import java.io.File
import java.util.Locale

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun VoiceRecorderScreen(
    storyId: String? = null,
    onBackClick: () -> Unit,
    onRecordingFinished: () -> Unit
) {
    val context = LocalContext.current
    var isRecording by remember { mutableStateOf(false) }
    var elapsedSeconds by remember { mutableStateOf(0L) }
    var hasRecordedFile by remember { mutableStateOf(false) }
    var recorder by remember { mutableStateOf<MediaRecorder?>(null) }
    var audioFile by remember { mutableStateOf<File?>(null) }

    val baseStory = remember(storyId) {
        FolkloreLibrary.stories.find { it.id == storyId }
    }

    var hasPermission by remember {
        mutableStateOf(
            ContextCompat.checkSelfPermission(
                context,
                Manifest.permission.RECORD_AUDIO
            ) == PackageManager.PERMISSION_GRANTED
        )
    }

    val permissionLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.RequestPermission()
    ) { isGranted -> hasPermission = isGranted }

    // Timer logic
    LaunchedEffect(isRecording) {
        if (isRecording) {
            while (true) {
                kotlinx.coroutines.delay(1000)
                elapsedSeconds++
            }
        }
    }

    // Reel spinning animation
    val infiniteTransition = rememberInfiniteTransition(label = "tapeReels")
    val rotation by infiniteTransition.animateFloat(
        initialValue = 0f,
        targetValue = 360f,
        animationSpec = infiniteRepeatable(
            animation = tween(2000, easing = LinearEasing),
            repeatMode = RepeatMode.Restart
        ),
        label = "rotation"
    )

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Parent Voice Studio", color = WarmAmber, fontWeight = FontWeight.Bold) },
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
                .padding(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text("Record Bedtime Story", color = SoftPurple, fontSize = 20.sp, fontWeight = FontWeight.Bold)
                Spacer(modifier = Modifier.height(4.dp))
                Text("Your voice will play along with bedtime background music", color = CreamPaper.copy(alpha = 0.7f), fontSize = 13.sp)
            }

            // Vintage Reel-to-Reel Tape Deck Graphic
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp),
                shape = RoundedCornerShape(24.dp),
                colors = CardDefaults.cardColors(containerColor = CardNavy)
            ) {
                Row(
                    modifier = Modifier.fillMaxSize().padding(16.dp),
                    horizontalArrangement = Arrangement.SpaceAround,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    // Left Reel
                    Box(
                        modifier = Modifier
                            .size(100.dp)
                            .rotate(if (isRecording) rotation else 0f)
                            .background(MidnightSky, CircleShape)
                            .border(3.dp, WarmAmber, CircleShape),
                        contentAlignment = Alignment.Center
                    ) {
                        Box(modifier = Modifier.size(24.dp).background(SunsetOrange, CircleShape))
                    }

                    Icon(Icons.Default.GraphicEq, contentDescription = null, tint = if (isRecording) SunsetOrange else StarlightSilver, modifier = Modifier.size(36.dp))

                    // Right Reel
                    Box(
                        modifier = Modifier
                            .size(100.dp)
                            .rotate(if (isRecording) rotation else 0f)
                            .background(MidnightSky, CircleShape)
                            .border(3.dp, WarmAmber, CircleShape),
                        contentAlignment = Alignment.Center
                    ) {
                        Box(modifier = Modifier.size(24.dp).background(SunsetOrange, CircleShape))
                    }
                }
            }

            // Digital Timer Readout
            val mins = elapsedSeconds / 60
            val secs = elapsedSeconds % 60
            Text(
                text = String.format(Locale.US, "%02d:%02d", mins, secs),
                color = WarmAmber,
                fontSize = 44.sp,
                fontWeight = FontWeight.Bold
            )

            // Record / Stop Control Button
            IconButton(
                onClick = {
                    if (hasPermission) {
                        if (isRecording) {
                            try {
                                recorder?.stop()
                                recorder?.release()
                                recorder = null
                                isRecording = false
                                hasRecordedFile = true
                            } catch (e: Exception) {
                                e.printStackTrace()
                            }
                        } else {
                            try {
                                val file = File(context.cacheDir, "recording_${System.currentTimeMillis()}.mp3")
                                audioFile = file
                                recorder = if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.S) {
                                    MediaRecorder(context)
                                } else {
                                    MediaRecorder()
                                }.apply {
                                    setAudioSource(MediaRecorder.AudioSource.MIC)
                                    setOutputFormat(MediaRecorder.OutputFormat.MPEG_4)
                                    setAudioEncoder(MediaRecorder.AudioEncoder.AAC)
                                    setOutputFile(file.absolutePath)
                                    prepare()
                                    start()
                                }
                                elapsedSeconds = 0L
                                isRecording = true
                            } catch (e: Exception) {
                                e.printStackTrace()
                            }
                        }
                    } else {
                        permissionLauncher.launch(Manifest.permission.RECORD_AUDIO)
                    }
                },
                modifier = Modifier
                    .size(96.dp)
                    .clip(CircleShape)
                    .background(if (isRecording) RecordRed else SunsetOrange)
            ) {
                Icon(
                    imageVector = if (isRecording) Icons.Default.Stop else Icons.Default.Mic,
                    contentDescription = "Record",
                    tint = MidnightSky,
                    modifier = Modifier.size(48.dp)
                )
            }

            // Save Recording Action Button
            if (hasRecordedFile && !isRecording) {
                Button(
                    onClick = {
                        val newId = "recorded_${System.currentTimeMillis()}"
                        val newStory = SampleStory(
                            id = newId,
                            title = if (baseStory != null) "Narration: ${baseStory.title}" else "My Voice Story",
                            origin = "Parent's Voice",
                            category = "Recorded Stories",
                            genre = baseStory?.genre ?: "Adventure",
                            minAge = baseStory?.minAge ?: 3,
                            readTime = String.format(Locale.US, "%d min", (elapsedSeconds / 60) + 1),
                            summary = if (baseStory != null) "A personal narration of ${baseStory.title}." else "A custom voice recorded bedtime story.",
                            iconEmoji = if (baseStory != null) baseStory.iconEmoji else "🎙️",
                            imageUrl = if (baseStory != null) baseStory.imageUrl else "https://images.unsplash.com/photo-1478737270239-2f02b77fc618?q=80&w=400",
                            content = baseStory?.content ?: "This is a voice recording without written content.",
                            moralLesson = baseStory?.moralLesson ?: "Listening to your parents' voice brings comfort and safety.",
                            speechRate = baseStory?.speechRate ?: 1.0f,
                            pitch = baseStory?.pitch ?: 1.0f,
                            audioPath = audioFile?.absolutePath,
                            isUserCreated = true
                        )
                        FolkloreLibrary.addStory(newStory)
                        onRecordingFinished()
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(56.dp),
                    shape = RoundedCornerShape(28.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = SavannahGreen, contentColor = MidnightSky)
                ) {
                    Icon(Icons.Default.Check, contentDescription = null)
                    Spacer(modifier = Modifier.width(8.dp))
                    Text("Save Narration to Story", fontSize = 16.sp, fontWeight = FontWeight.Bold)
                }
            } else {
                Text(
                    text = if (isRecording) "Recording in progress..." else "Tap microphone to record",
                    color = CreamPaper.copy(alpha = 0.5f),
                    fontSize = 14.sp
                )
            }
        }
    }
}
