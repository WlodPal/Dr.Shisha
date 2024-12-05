package com.palchukwlod.drshisha.presentation.customMixes.listOfMixes

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.rememberLottieComposition
import com.palchukwlod.drshisha.presentation.theme.fontFamily
import com.palchukwlod.drshisha.R


@Composable
fun EmptyContent(
    onAddMixClicked: () -> Unit
) {

    val emptyAnim by rememberLottieComposition(
        LottieCompositionSpec.RawRes(R.raw.empty_animation)
    )


    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Transparent),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly,
    ) {

        Text(
            modifier = Modifier.padding(start = 15.dp, end = 15.dp),
            textAlign = TextAlign.Center,
            text = "Get Creative: Craft Your Own Unique Mix!",
            fontSize = 25.sp,
            fontFamily = fontFamily
        )

        LottieAnimation(
            modifier = Modifier.size(300.dp),
            composition = emptyAnim,
            iterations = LottieConstants.IterateForever

        )


        Text(
            modifier = Modifier.padding(start = 15.dp, end = 15.dp),
            textAlign = TextAlign.Center,
            text = "\"Welcome to the mix creation zone! It looks like there are no mixes yet, but don't worry — you're in control.\"",
            fontSize = 17.sp,
            fontFamily = fontFamily
        )

        Button(
            onClick = { onAddMixClicked() },
            modifier = Modifier.fillMaxWidth().padding(start = 15.dp, end = 15.dp, bottom = 72.dp)) {
            Text(text = "Press to create your first mix.")
        }



    }

}