package com.itachi.ai

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            ItachiApp()
        }
    }
}

@Composable
fun ItachiApp() {
    var message by remember { mutableStateOf("") }
    var conversation by remember {
        mutableStateOf("ITACHI: System online. How can I help you?")
    }

    val background = Color(0xFF080808)
    val red = Color(0xFFFF3030)

    MaterialTheme {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(background)
                .padding(20.dp)
        ) {
            Text(
                "ITACHI AI",
                color = red,
                fontSize = 30.sp
            )

            Text(
                "FUTURE EDITION",
                color = Color.Gray,
                fontSize = 12.sp
            )

            Spacer(modifier = Modifier.height(35.dp))

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
                    .background(
                        Color(0xFF171717),
                        RoundedCornerShape(18.dp)
                    )
                    .padding(18.dp),
                contentAlignment = Alignment.TopStart
            ) {
                Text(
                    conversation,
                    color = Color.White,
                    fontSize = 16.sp
                )
            }

            Spacer(modifier = Modifier.height(15.dp))

            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                OutlinedTextField(
                    value = message,
                    onValueChange = { message = it },
                    modifier = Modifier.weight(1f),
                    placeholder = {
                        Text("Ask ITACHI...")
                    },
                    singleLine = true,
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedTextColor = Color.White,
                        unfocusedTextColor = Color.White,
                        focusedBorderColor = red,
                        unfocusedBorderColor = Color.Gray
                    )
                )

                Spacer(modifier = Modifier.width(8.dp))

                Button(
                    onClick = {
                        if (message.isNotBlank()) {
                            conversation =
                                "YOU: $message\n\n" +
                                "ITACHI: Gemini connection is not configured yet."
                            message = ""
                        }
                    },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = red
                    )
                ) {
                    Text("SEND")
                }
            }
        }
    }
}
