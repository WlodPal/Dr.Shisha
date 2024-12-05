package com.palchukwlod.drshisha.components

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import com.example.shishamixcompouse.presentation.ui.theme.LEVEL_OF_STRONG_SIZE
import com.example.shishamixcompouse.presentation.ui.theme.MEDIUM
import com.example.shishamixcompouse.presentation.ui.theme.PRIORITY_DROP_DOWN_HEIGHT
import com.palchukwlod.drshisha.R
import com.palchukwlod.drshisha.data.entity.customMix.LevelOfStrong
import com.palchukwlod.drshisha.presentation.theme.fontFamily

@Composable
fun LevelOfStrongDropDown(
    levelOfStrong: LevelOfStrong,
    onLevelOfStrongSelected: (LevelOfStrong) -> Unit,
) {

    var expanded by remember { mutableStateOf(false) }

    val angle: Float by animateFloatAsState(
        targetValue = if (expanded) 180f else 0f
    )

    IconButton(onClick = { expanded = true }) {
        Row(
            modifier = Modifier

                .height(PRIORITY_DROP_DOWN_HEIGHT)
                .clickable { expanded = true },
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Spacer(modifier = Modifier.width(MEDIUM))

            Icon(
                modifier = Modifier.size(LEVEL_OF_STRONG_SIZE),
                painter = painterResource(id = R.drawable.ic_whatshot),
                contentDescription = stringResource(R.string.content_icon_level),
                tint = levelOfStrong.color
            )

            Spacer(modifier = Modifier.width(MEDIUM))

            Text(
                modifier = Modifier.weight(8f),
                text = levelOfStrong.name,
                fontFamily = fontFamily
            )

            IconButton(
                modifier = Modifier
                    .rotate(angle)
                    .weight(1.5f),
                onClick = { expanded = true },
            ) {
                Icon(
                    imageVector = Icons.Filled.ArrowDropDown,
                    contentDescription = stringResource(id = R.string.dropdown_arrow_icon),
                )
            }

            DropdownMenu(
                modifier = Modifier.fillMaxWidth(0.35f),
                expanded = expanded,
                onDismissRequest = { expanded = false }
            ) {
                DropdownMenuItem(
                    text = { LevelOfStrongItem(LevelOfStrong.LIGHT) },
                    onClick = {
                        expanded = false
                        onLevelOfStrongSelected(LevelOfStrong.LIGHT)
                    }
                )
                DropdownMenuItem(
                    text = { LevelOfStrongItem(LevelOfStrong.MEDIUM) },
                    onClick = {
                        expanded = false
                        onLevelOfStrongSelected(LevelOfStrong.MEDIUM)
                    }
                )
                DropdownMenuItem(
                    text = { LevelOfStrongItem(LevelOfStrong.STRONG) },
                    onClick = {
                        expanded = false
                        onLevelOfStrongSelected(LevelOfStrong.STRONG)
                    }
                )
            }

            Spacer(modifier = Modifier.width(MEDIUM))
        }
    }
}

