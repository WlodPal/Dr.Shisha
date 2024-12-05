package com.palchukwlod.drshisha.presentation.customMixes.partOfCustomMix

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import com.example.shishamixcompouse.presentation.ui.theme.LARGE
import com.example.shishamixcompouse.presentation.ui.theme.MEDIUM
import com.example.shishamixcompouse.presentation.ui.theme.SMALL
import com.example.shishamixcompouse.presentation.ui.theme.TEXT_SIZE_LARGE
import com.example.shishamixcompouse.presentation.ui.theme.TEXT_SIZE_MEDIUM
import com.palchukwlod.drshisha.data.entity.customMix.PartOfCustomMix
import com.palchukwlod.drshisha.presentation.theme.fontFamily

@Composable
fun PartOfMixCard(
    partOfMix: PartOfCustomMix,
    modifier: Modifier = Modifier,
    backgroundColor: Color = Color.Transparent,
    textColor: Color = Color.LightGray

) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(SMALL),
        shape = RoundedCornerShape(SMALL),


    ) {
        Row(
            modifier = modifier
                .fillMaxWidth()
                .padding(LARGE)
        ) {

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(6f)
            ) {

                Text(
                    modifier = modifier
                        .fillMaxWidth()
                        .padding(MEDIUM),
                    text = partOfMix.brandName,
                    color = textColor,
                    fontFamily = fontFamily,
                    textAlign = TextAlign.Center,
                    fontSize = TEXT_SIZE_LARGE
                )

                Text(
                    modifier = modifier
                        .fillMaxWidth()
                        .padding(MEDIUM),
                    text = partOfMix.flavour,
                    color = textColor,
                    fontFamily = fontFamily,
                    textAlign = TextAlign.Center,
                    fontSize = TEXT_SIZE_LARGE
                )
            }

            Text(
                modifier = modifier
                    .fillMaxWidth()
                    .weight(2f)
                    .align(Alignment.CenterVertically)
                    .padding(MEDIUM),
                text = "${partOfMix.percentage} %",
                color = textColor,
                fontFamily = fontFamily,
                textAlign = TextAlign.Center,
                fontSize = TEXT_SIZE_MEDIUM
            )


        }
    }
}