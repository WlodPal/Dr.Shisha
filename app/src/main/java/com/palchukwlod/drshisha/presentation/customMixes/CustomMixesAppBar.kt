package com.palchukwlod.drshisha.presentation.customMixes

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.shishamixcompouse.presentation.ui.theme.TEXT_SIZE_LARGE
import com.palchukwlod.drshisha.presentation.theme.fontFamily

@Composable
fun MixAppBar(

) {

}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomMixesAppBar(

) {
    TopAppBar(
        modifier = Modifier.fillMaxWidth(),
        title = {
            Text(
                text = "Dr. Shisha",
                fontSize = TEXT_SIZE_LARGE,
                fontFamily = fontFamily
            )
        },
        actions = {

        }
    )
}

@Composable
fun CustomMixesAppBarActions() {

}
