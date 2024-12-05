package com.palchukwlod.drshisha.presentation.assistant

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.shishamixcompouse.presentation.ui.theme.BOTTOM_PADDING
import com.palchukwlod.drshisha.data.entity.assistant.AssistantItems
import com.palchukwlod.drshisha.presentation.theme.fontFamily

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ListOfAssistantContent(
    onAssistantItemClicked: (AssistantItems) -> Unit
) {


    Scaffold(
        modifier = Modifier
        .fillMaxSize(),
        topBar = {
            TopAppBar(
                modifier = Modifier.fillMaxWidth(),
                title = {
                    Text(
                        text = "Dr. Shisha",
                        fontFamily = fontFamily
                    )
                },
                actions = {
                    SettingsAction {

                    }
                }

            )
        }
    ) {
        val list = listOf(
            AssistantItems.SHISHA, AssistantItems.BRANDS_WITH_FLAVOURS, AssistantItems.HEADS,
            AssistantItems.CHARCOAL, AssistantItems.ACCESSORIES
        )

        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(it)
                .padding(bottom = BOTTOM_PADDING)
        ) {

            items(list, key = {it.listName}) {

                AssistantCard(
                    assistantItems = it
                ){
                    onAssistantItemClicked(it)
                }
            }
        }
    }
}


@Composable
fun SettingsAction(
    onSettingsClicked: () -> Unit
) {

    IconButton(
        onClick = {
            onSettingsClicked()
        }
    ) {
        Icon(
            imageVector = Icons.Filled.Settings,
            contentDescription = null,
        )

    }
}



