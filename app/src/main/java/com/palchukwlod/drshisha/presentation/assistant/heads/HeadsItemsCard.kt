package com.palchukwlod.drshisha.presentation.assistant.heads

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.shishamixcompouse.presentation.ui.theme.LARGE
import com.palchukwlod.drshisha.data.entity.assistant.HeadsItems

@Composable
fun HeadsItemsCard(
    headsItems: HeadsItems
) {

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(LARGE),
        onClick = {

        }
    ) {

        Row(modifier = Modifier.fillMaxWidth()) {
            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(LARGE)
            ) {
                Text(
                    text = stringResource(id =headsItems.headName),
                    fontSize = 20.sp
                )

                Spacer(modifier = Modifier.height(10.dp))

                Text(
                    text = stringResource(id = headsItems.strongAndWeekSides),
                    fontSize = 15.sp
                )


            }

            AsyncImage(
                modifier = Modifier
                    .size(150.dp),
                model = headsItems.image,
                contentDescription = null,
                contentScale = ContentScale.Crop,
            )
        }

        Spacer(modifier = Modifier.height(15.dp))

        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(LARGE),
            text = stringResource(id =headsItems.description),
            fontSize = 15.sp,

            )

        Button(
            modifier = Modifier.fillMaxWidth(),
            onClick = { /*TODO*/ }
        ) {
            Text(text = "Press for top heads from ${stringResource(id =headsItems.headName)}")
        }

    }

}