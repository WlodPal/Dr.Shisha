package com.palchukwlod.drshisha.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import com.example.shishamixcompouse.presentation.ui.theme.LARGE
import com.example.shishamixcompouse.presentation.ui.theme.LEVEL_OF_STRONG_SIZE
import com.palchukwlod.drshisha.R
import com.palchukwlod.drshisha.data.entity.customMix.LevelOfStrong
import com.palchukwlod.drshisha.presentation.theme.fontFamily

@Composable
fun LevelOfStrongItem(levelOfStrong: LevelOfStrong) {
    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            modifier = Modifier.size(LEVEL_OF_STRONG_SIZE),
            painter = painterResource(id = R.drawable.ic_whatshot),
            contentDescription = stringResource(R.string.content_icon_level),
            tint = levelOfStrong.color
        )
        Text(
            modifier = Modifier
                .padding(start = LARGE),
            text = levelOfStrong.name,
            fontFamily = fontFamily
        )
    }
}