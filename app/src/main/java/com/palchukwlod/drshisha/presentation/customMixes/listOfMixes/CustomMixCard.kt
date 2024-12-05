package com.palchukwlod.drshisha.presentation.customMixes.listOfMixes

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.shishamixcompouse.presentation.ui.theme.DESCRIPTION_SIZE
import com.example.shishamixcompouse.presentation.ui.theme.FLAVOUR_TYPE_SIZE
import com.example.shishamixcompouse.presentation.ui.theme.LARGE
import com.example.shishamixcompouse.presentation.ui.theme.MEDIUM
import com.example.shishamixcompouse.presentation.ui.theme.MIX_NAME_SIZE
import com.example.shishamixcompouse.presentation.ui.theme.SMALL
import com.palchukwlod.drshisha.R.drawable
import com.palchukwlod.drshisha.R.string
import com.palchukwlod.drshisha.data.entity.customMix.CustomMix
import com.palchukwlod.drshisha.data.entity.customMix.FlavorType
import com.palchukwlod.drshisha.data.entity.customMix.LevelOfStrong
import com.palchukwlod.drshisha.presentation.theme.DrShishaTheme
import com.palchukwlod.drshisha.presentation.theme.fontFamily


@Composable
fun CustomMixCard(
    customMix: CustomMix,
    onShishaMixClicked: (CustomMix) -> Unit
) {

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(SMALL),
        onClick = { onShishaMixClicked(customMix) }
    ) {

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(LARGE)
        ) {

            Row(
                modifier = Modifier
                    .background(Color.Transparent)
            ) {
                Text(
                    modifier = Modifier.weight(8f),
                    text = customMix.mixName,
                    fontSize = MIX_NAME_SIZE,
                    fontFamily = fontFamily,
                    fontWeight = FontWeight.Bold
                )
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Color.Transparent)
                        .weight(1f),
                    contentAlignment = Alignment.TopEnd
                ) {
                    Icon(
                        painter = painterResource(id = drawable.ic_whatshot),
                        contentDescription = stringResource(string.content_icon_level),
                        tint = customMix.levelOfStrong.color
                    )
                }
            }

            Text(
                text = customMix.description,
                fontSize = DESCRIPTION_SIZE,
                fontFamily = fontFamily
            )

            Spacer(modifier = Modifier.height(MEDIUM))

            // Flavour Icons
            Row(
                horizontalArrangement = Arrangement.spacedBy(MEDIUM),
                modifier = Modifier.fillMaxWidth()
            ) {
                // Check for each flavor type and display icon if the mix has it
                FlavorType.values().forEach { flavorType ->
                    if (customMix.flavorType.contains(flavorType)) {
//
                        Image(
                            modifier = Modifier.size(FLAVOUR_TYPE_SIZE),
                            painter = painterResource(id = flavorType.iconResId),
                            contentDescription = flavorType.name
                        )
                    }
                }

            }

        }
    }
}

@Composable
@Preview
fun Prewiev() {
    DrShishaTheme {
        CustomMixCard(
            CustomMix(
                1,
                "Dark Side Mix",
                "Strong and smooth",
                LevelOfStrong.STRONG,
                percentage = 56,
                flavorType = listOf(FlavorType.ALCOHOL, FlavorType.CHOCOLATE, FlavorType.COFFEE)
            ),
            onShishaMixClicked = {}
        )
    }

}