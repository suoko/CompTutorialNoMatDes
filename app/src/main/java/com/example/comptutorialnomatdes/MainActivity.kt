package com.example.comptutorialnomatdes

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.comptutorialnomatdes.ui.theme.CompTutorialNoMatDesTheme
import androidx.compose.foundation.lazy.items


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CompTutorialNoMatDesTheme() {
                MessageCard(Message("Second Line", "First Line"))
                //Conversation(SampleData.conversationSample)

            }
        }
    }
}

data class Message(val author: String, val body: String)


@Composable
fun MessageCard(msg: Message) {
    // Add padding around our message
    Row(modifier = Modifier.padding(all = 10.dp)) {
        Image(painter = painterResource(R.drawable.confluence),
            contentDescription = "Contact profile picture",
            modifier = Modifier
                // Set image size to 40 dp
                .size(40.dp)
                // Clip image to be shaped as a circle
                .clip(CircleShape)
                .border(1.5.dp, MaterialTheme.colors.secondary)
        )


        // Add a horizontal space between the image and the column
        Spacer(modifier = Modifier.width(15.dp))

        Column {
            Text(
                text = msg.author,
                color = MaterialTheme.colors.primary
            )
            // Add a vertical space between the author and message texts
            Spacer(modifier = Modifier.height(4.dp))

            Surface(shape = MaterialTheme.shapes.medium, elevation = 1.dp) {

                Text(
                    text = msg.body,
                    style = MaterialTheme.typography.subtitle2,
                    modifier = Modifier.padding(all = 4.dp),
                    color = MaterialTheme.colors.secondary

                )
            }
            Spacer(modifier = Modifier.height(4.dp))

        }
    }
}

@Preview(name = "Light Mode")
@Preview(
    uiMode = Configuration.UI_MODE_NIGHT_YES,
    showBackground = true,
    name = "Dark Mode"
)


@Composable
fun PreviewMessageCard() {
    CompTutorialNoMatDesTheme() {
        MessageCard(Message("Colleague", "Take a look at Jetpack Compose, it's great!"))
    }
}



@Composable
fun Conversation(messages: List<Message>) {
    LazyColumn {
        items(messages) { message ->
            MessageCard(message)
        }
    }
}

@Preview
@Composable
fun PreviewConversation() {
    CompTutorialNoMatDesTheme() {
        Conversation(SampleData.conversationSample)
    }
}
