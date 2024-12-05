package com.palchukwlod.drshisha.presentation.assistant.heads

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.shishamixcompouse.presentation.ui.theme.BOTTOM_PADDING
import com.example.shishamixcompouse.presentation.ui.theme.MEDIUM
import com.palchukwlod.drshisha.R
import com.palchukwlod.drshisha.data.entity.assistant.HeadsItems
import com.palchukwlod.drshisha.presentation.theme.fontFamily

@Composable
fun HeadsContent() {

    Scaffold {


        val list = listOf(
            HeadsItems.CLAY_BOWLS, HeadsItems.CERAMIC_BOWLS, HeadsItems.FAIENCE_BOWLS,
            HeadsItems.SILICONE_BOWLS, HeadsItems.STONE_BOWLS, HeadsItems.FRUIT_BOWLS
        )


        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(it)
                .padding(bottom = BOTTOM_PADDING)
        ) {

            item {
                Text(
                    modifier = Modifier
                        .fillMaxWidth().padding(MEDIUM),
                    text = stringResource(R.string.materials_and_types_of_hookah_bow),
                    fontFamily = fontFamily,
                    fontSize = 32.sp,
                    textAlign = TextAlign.Center
                )
                Spacer(modifier = Modifier.height(15.dp))
            }



            item {
                Text(
                    modifier = Modifier.fillMaxWidth().padding(MEDIUM),
                    text = stringResource(R.string.the_materials_of_the_bowl),
                    fontFamily = fontFamily,
                    fontSize = 22.sp,
                    textAlign = TextAlign.Center
                )
            }

            items(list, key = { it.headName }) {

                HeadsItemsCard(it)
            }
        }
    }

}