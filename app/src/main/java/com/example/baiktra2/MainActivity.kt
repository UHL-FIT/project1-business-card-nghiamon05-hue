package com.example.baiktra2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.baiktra2.ui.theme.Baiktra2Theme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Baiktra2Theme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color(0xFFF5F5F5)
                ) {
                    BusinessCard()
                }
            }
        }
    }
}

@Composable
fun BusinessCard() {
    Card(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
        shape = RoundedCornerShape(20.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 6.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            AvatarImage()
            Spacer(modifier = Modifier.height(20.dp))
            NameAndTitle()
            Spacer(modifier = Modifier.height(30.dp))
            ContactInfoList()
        }
    }
}

@Composable
fun AvatarImage() {
    Box(
        modifier = Modifier
            .size(130.dp)
            .background(
                Brush.radialGradient(
                    colors = listOf(Color(0xFF6200EE), Color(0xFFBB86FC))
                ),
                CircleShape
            ),
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_launcher_foreground),
            contentDescription = "Avatar",
            modifier = Modifier
                .size(110.dp)
                .clip(CircleShape)
                .border(3.dp, Color.White, CircleShape)
        )
    }
}

@Composable
fun NameAndTitle() {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text(
            text = "TRẦN ĐAI NGHĨA",
            fontSize = 26.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF1A1A1A)
        )
        Spacer(modifier = Modifier.height(8.dp))
        Surface(
            shape = RoundedCornerShape(20.dp),
            color = Color(0xFF6200EE).copy(alpha = 0.1f)
        ) {
            Text(
                text = "Android Developer",
                fontSize = 16.sp,
                fontWeight = FontWeight.Medium,
                color = Color(0xFF6200EE),
                modifier = Modifier.padding(horizontal = 16.dp, vertical = 6.dp)
            )
        }
    }
}

@Composable
fun ContactInfoList() {
    Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        ContactItem(
            imageId = R.drawable.imgphone,
            title = "Điện thoại",
            content = "+84 356410965"
        )
        ContactItem(
            imageId = R.drawable.imgmail,
            title = "Email",
            content = "nghiamon05@.com"
        )
        ContactItem(
            imageId = R.drawable.imgshare,
            title = "Twitter",
            content = "@trandainghia"
        )
    }
}

@Composable
fun ContactItem(
    imageId: Int,
    title: String,
    content: String
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color(0xFFF8F9FA), RoundedCornerShape(12.dp))
            .padding(12.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = Modifier
                .size(45.dp)
                .background(Color(0xFF6200EE).copy(alpha = 0.1f), CircleShape),
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = painterResource(id = imageId),
                contentDescription = title,
                modifier = Modifier.size(24.dp)
            )
        }
        Spacer(modifier = Modifier.width(12.dp))
        Column {
            Text(
                text = title,
                fontSize = 12.sp,
                color = Color(0xFF888888)
            )
            Text(
                text = content,
                fontSize = 15.sp,
                fontWeight = FontWeight.Medium,
                color = Color(0xFF1A1A1A)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun BusinessCardPreview() {
    Baiktra2Theme {
        BusinessCard()
    }
}