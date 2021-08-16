package com.avtocontrol.composelearn1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.avtocontrol.composelearn1.data.Message

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MessageCard(Message("Android", "Jetpack Compose"))
        }
    }
    //Определение составной функции MessageCard
    @Composable
    fun MessageCard(msg: Message) {
        Row(modifier = Modifier.padding(all = 8.dp)) {
            Image(
                painter = painterResource(id = R.drawable.ic_baseline_airplay_24),
                contentDescription = "Contacct profile picture",
                modifier = Modifier
                    //Изменение размера картинки
                    .size(40.dp)
                    //Обрезать изображение по форме круга
                    .clip(CircleShape)

            )
            //Горизонтальный отступ между изображением и текстом
            Spacer(modifier = Modifier.width(8.dp))


            Column {
                Text(text = msg.author)
                //Вертикальный отступ между author и body
                Spacer(modifier = Modifier.height(4.dp))
                Text(text = msg.body)
            }
        }


    }
    //Предварительный просмотр составной функции MessageCard
    @Preview
    @Composable
    fun PreviewMessageCard() {
        MessageCard(Message("Android", "Jetpack Compose"))
    }
}

