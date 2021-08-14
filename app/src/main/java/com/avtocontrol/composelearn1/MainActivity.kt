package com.avtocontrol.composelearn1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MessageCard(name = "Android")
        }
    }
    //Определение составной функции MessageCard
    @Composable
    fun MessageCard(name: String) {
        Text(text = "Hello $name!")
    }
    //Предварительный просмотр составной функции MessageCard
    @Preview
    @Composable
    fun PreviewMessageCard() {
        MessageCard(name = "Android")
    }
}

