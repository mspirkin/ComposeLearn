package com.avtocontrol.composelearn1

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.avtocontrol.composelearn1.data.Message
import com.avtocontrol.composelearn1.data.SampleData
import com.avtocontrol.composelearn1.ui.theme.ComposeLearn1Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeLearn1Theme() {
                Conversation(messages = SampleData.conversationSample)
            }

        }
    }
    //Определение составной функции MessageCard
    @Composable
    fun MessageCard(msg: Message) {
        Row(modifier = Modifier.padding(all = 8.dp)) {
            Image(
                painter = painterResource(id = R.drawable.ic_baseline_airplay_24),
                contentDescription = "Contact profile picture",
                modifier = Modifier
                    //Изменение размера картинки
                    .size(40.dp)
                    //Обрезать изображение по форме круга
                    .clip(CircleShape)
                    .border(1.5.dp, MaterialTheme.colors.secondary, shape = CircleShape)



            )
            //Горизонтальный отступ между изображением и текстом
            Spacer(modifier = Modifier.width(8.dp))

            var isExpanded by remember { mutableStateOf(false)}
            val surfaceColor: Color by animateColorAsState(if (isExpanded) MaterialTheme.colors.primary else MaterialTheme.colors.surface)


            Column(modifier = Modifier.clickable { isExpanded = !isExpanded }) {

                Text(text = msg.author,
                    color = MaterialTheme.colors.secondaryVariant,
                    style = MaterialTheme.typography.subtitle2)
                //Вертикальный отступ между author и body
                Spacer(modifier = Modifier.height(4.dp))
                androidx.compose.material.Surface(shape = MaterialTheme.shapes.medium,
                    elevation = 1.dp,
                    color = surfaceColor,
                    modifier = Modifier.animateContentSize().padding(1.dp)) {
                    Text(text = msg.body,
                        modifier = Modifier.padding(all= 4.dp),
                        maxLines = if (isExpanded) Int.MAX_VALUE else 1,
                        style = MaterialTheme.typography.body2)
                }

            }
        }


    }
    @Composable
    fun Conversation(messages: List<Message>) {
       LazyColumn {
           items(messages) {message ->
               MessageCard(message)
           }
       }
    }
    //Предварительный просмотр составной функции MessageCard
    @Preview(name = "Light Mode")
    @Preview(
        uiMode = Configuration.UI_MODE_NIGHT_YES,
        showBackground = true,
        name = "Dark Mode"
    )
    @Composable
    fun PreviewMessageCard() {
        ComposeLearn1Theme() {
            Conversation(SampleData.conversationSample)
        }
    }
}

