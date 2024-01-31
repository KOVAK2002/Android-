package com.example.lab15

import android.os.Bundle
import android.text.style.BackgroundColorSpan
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.lab15.ui.theme.Lab15Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

        }
    }
}
@Preview
@Composable
fun MyScreanPreview(){
    MyScrean()
}


@Composable
fun MyScrean(){
    Surface(modifier = Modifier
        .padding(16.dp)
        .background(Color(255, 255, 255))
    ){

        Column() {
            Row {
                Box(
                    modifier = Modifier
                        .size(30.dp) // Promenite veličinu prema potrebi
                        .background(Color.Gray,shape = CircleShape) // Promenite boju okvira prema potrebi
                )
                Column {
                    Text(text = "Text", modifier = Modifier.clickable {})
                    Text(text = "Text", modifier = Modifier.clickable {})
                }
            }
            Surface(modifier = Modifier.size(100.dp,10.dp).clickable {})
            {
            }
            Row {
                Icon(imageVector = Icons.Default.Share, contentDescription = null, Modifier.size(10.dp,10.dp))
                Text(text = "TExt" , modifier = Modifier.clickable {})
                Spacer(modifier = Modifier.width(16.dp))
                Text(text = "Text" , modifier = Modifier.clickable {})
                Spacer(modifier = Modifier.width(16.dp) )
                Text(text = "Text", modifier = Modifier.clickable {})
            }
        }
    }


}

