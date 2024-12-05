package com.palchukwlod.drshisha.presentation.assistant

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.shishamixcompouse.presentation.ui.theme.LARGE
import com.example.shishamixcompouse.presentation.ui.theme.TEXT_SIZE_LARGE
import com.palchukwlod.drshisha.R
import com.palchukwlod.drshisha.data.entity.assistant.AssistantItems
import com.palchukwlod.drshisha.presentation.theme.fontFamily

@Composable
fun AssistantCard(
    assistantItems: AssistantItems,
    onAssistantItemClicked:() -> Unit
) {

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(LARGE),
        onClick = {
            onAssistantItemClicked()
        }
    ) {

        AsyncImage(modifier = Modifier
            .fillMaxWidth()
            .height(250.dp),
            model = assistantItems.picture,
            contentDescription = null,
            contentScale = ContentScale.Crop
        )


        Row{
            Text(
                modifier = Modifier
                    .padding(LARGE)
                    .weight(1f),
                text = stringResource(id = assistantItems.listName),
                fontFamily = fontFamily,
                fontSize = TEXT_SIZE_LARGE
            )
            Icon(
                modifier = Modifier.align(Alignment.CenterVertically).padding(10.dp),
                painter = painterResource(id = R.drawable.keyboard_arrow_right),
                contentDescription = "Arrow"
            )
        }

    }

}