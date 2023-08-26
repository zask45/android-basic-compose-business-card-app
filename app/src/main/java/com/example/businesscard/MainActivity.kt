package com.example.businesscard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Email
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.businesscard.ui.theme.BusinessCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BusinessCardTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    BusinessCardApp()
                }
            }
        }
    }
}

@Composable
fun Profile(fullName: String, title: String, modifier: Modifier = Modifier) {
    Column (
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.profile_account),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            alignment = Alignment.CenterEnd,
            modifier = modifier
                .size(240.dp)
                .clip(CircleShape)
        )
        Text(
            text = fullName,
            fontWeight = FontWeight.Bold,
            fontSize = 36.sp,
            modifier = modifier.padding(top = 16.dp, bottom = 4.dp)
        )
        Text(
            text = title,
            fontSize = 20.sp
        )
    }
}

@Composable
fun ContactInfo(icon: ImageVector, contactInfo: String, modifier: Modifier = Modifier) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier.padding(vertical = 10.dp)
    ) {
        Icon(
            icon,
            contentDescription = null,
            modifier = modifier
                .padding(end = 32.dp)
                .size(20.dp)
        )
        Text(
            text = contactInfo,
            fontSize = 20.sp,
            fontWeight = FontWeight.Light,
        )
    }
}

@Composable
fun Contact(modifier: Modifier = Modifier) {
    val linkedInIcon = ImageVector.vectorResource(id = R.drawable.linkedin_square_icon)
    Column(
        horizontalAlignment = Alignment.Start,
        modifier = modifier.padding(vertical = 56.dp)
    ) {
        ContactInfo(Icons.Filled.Call, "+00 (00) 111 111")
        ContactInfo(Icons.Filled.Email, "janedoe@domail.com")
        ContactInfo(linkedInIcon, "linkedin.com/jane")




    }
}

@Composable
fun BusinessCardApp() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Profile("Jane Doe", "Android Developer")
        Contact()
    }
}

@Preview(
    showBackground = true,
    showSystemUi = true
)
@Composable
fun GreetingPreview() {
    BusinessCardTheme {
        BusinessCardApp()
    }
}