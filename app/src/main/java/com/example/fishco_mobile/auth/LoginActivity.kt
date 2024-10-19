package com.example.fishco_mobile.auth

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import com.example.fishco_mobile.R

class LoginActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LoginScreen()
        }
    }
}

@Composable
fun LoginScreen() {
    Box(modifier = Modifier.fillMaxSize()) {
        // Left Blob - Adjusted for more top-left alignment
        Image(
            painter = painterResource(id = R.drawable.blob_login1),
            contentDescription = "Left Blob",
            modifier = Modifier
                .size(250.dp)  // Increase size
                .align(Alignment.TopStart)
                .offset(x = (-100).dp, y = (-50).dp),  // Offset to push towards corner
            contentScale = ContentScale.Fit
        )

        // Right Blob - Adjusted for more top-right alignment
        Image(
            painter = painterResource(id = R.drawable.blob_login2),
            contentDescription = "Right Blob",
            modifier = Modifier
                .size(250.dp)  // Increase size
                .align(Alignment.TopEnd)
                .offset(x = 50.dp, y = (-50).dp),  // Offset to push towards corner
            contentScale = ContentScale.Fit
        )

        // Your content (text fields, login button, etc.)
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Masuk ke Fishco",
                fontSize = 56,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = "Belum punya akun Fishco? Daftar",
                color = Color.Blue,
                fontSize = 14
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Email or Phone Field
            var emailOrPhone by remember { mutableStateOf("") }
            BasicTextField(
                value = emailOrPhone,
                onValueChange = { emailOrPhone = it },
                textStyle = TextStyle(color = Color.Black, fontSize = 16.sp),
                modifier = Modifier
                    .fillMaxWidth()
                    .border(1.dp, Color.Gray, RoundedCornerShape(8.dp))
                    .padding(16.dp),
                decorationBox = { innerTextField ->
                    if (emailOrPhone.isEmpty()) {
                        Text("Nomor HP atau Email", color = Color.Gray, fontSize = 16)
                    }
                    innerTextField()
                }
            )

            Spacer(modifier = Modifier.height(8.dp))

            // Password Field
            var password by remember { mutableStateOf("") }
            var passwordVisible by remember { mutableStateOf(false) }
            BasicTextField(
                value = password,
                onValueChange = { password = it },
                textStyle = TextStyle(color = Color.Black, fontSize = 16.sp),
                visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
                modifier = Modifier
                    .fillMaxWidth()
                    .border(1.dp, Color.Gray, RoundedCornerShape(8.dp))
                    .padding(16.dp),
                decorationBox = { innerTextField ->
                    if (password.isEmpty()) {
                        Text("Password", color = Color.Gray, fontSize = 16)
                    }
                    innerTextField()
                }
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Login Button
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp)
                    .background(Color(0xFF45B1F9), RoundedCornerShape(8.dp))
                    .padding(vertical = 12.dp),
                contentAlignment = Alignment.Center
            ) {
                Text(text = "Masuk", color = Color.White, fontSize = 16)
            }

            Spacer(modifier = Modifier.height(8.dp))

            Row(modifier = Modifier.fillMaxWidth() , horizontalArrangement = Arrangement.Center) {
                Text(
                    text = "Lupa password?",
                    color = Color.Blue,
                    fontSize = 14
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Social Media Buttons
            Column(modifier = Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth() // Ensures the button takes up the full width
                        .border(1.dp, Color.Gray, RoundedCornerShape(8.dp))
                        .padding(12.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Image(
                            painter = painterResource(id = R.drawable.ic_google_logo),
                            contentDescription = "Google Logo",
                            modifier = Modifier.size(24.dp)
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                        Text(text = "Masuk dengan Google", color = Color.Black, fontSize = 14)
                    }
                }

                Spacer(modifier = Modifier.height(10.dp)) // Space between the two buttons

                Box(
                    modifier = Modifier
                        .fillMaxWidth() // Ensures the button takes up the full width
                        .border(1.dp, Color.Gray, RoundedCornerShape(8.dp))
                        .padding(12.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Image(
                            painter = painterResource(id = R.drawable.ic_facebook_logo),
                            contentDescription = "Facebook Logo",
                            modifier = Modifier.size(24.dp)
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                        Text(text = "Masuk dengan Facebook", color = Color.Black, fontSize = 14)
                    }
                }
            }
        }
    }
}

@Composable
fun Text(text: String, fontSize: Int, color: Color = Color.Black, fontWeight: FontWeight = FontWeight.Normal) {
    androidx.compose.foundation.text.BasicText(
        text = text,
        style = TextStyle(fontSize = fontSize.sp, color = color, fontWeight = fontWeight)
    )
}

@Preview(showBackground = true)
@Composable
fun PreviewLoginScreen() {
    LoginScreen()
}
