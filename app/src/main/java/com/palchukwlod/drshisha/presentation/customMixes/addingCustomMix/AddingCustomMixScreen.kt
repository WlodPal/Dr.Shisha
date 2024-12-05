@file:OptIn(ExperimentalMaterial3Api::class)

package com.palchukwlod.drshisha.presentation.customMixes.addingCustomMix

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.shishamixcompouse.presentation.ui.theme.BOTTOM_PADDING
import com.example.shishamixcompouse.presentation.ui.theme.BUTTON_PADDING_FROM_END
import com.example.shishamixcompouse.presentation.ui.theme.FAB_PADDING
import com.example.shishamixcompouse.presentation.ui.theme.LARGE
import com.example.shishamixcompouse.presentation.ui.theme.MEDIUM
import com.palchukwlod.drshisha.R
import com.palchukwlod.drshisha.components.LevelOfStrongDropDown
import com.palchukwlod.drshisha.data.entity.customMix.LevelOfStrong
import com.palchukwlod.drshisha.presentation.customMixes.partOfCustomMix.PartOfMixCard
import com.palchukwlod.drshisha.presentation.theme.fontFamily


@Composable
fun AddShishaMixContent(
    mixName: String,
    onMixNameChange: (String) -> Unit,
    description: String,
    onDescriptionChange: (String) -> Unit,
    levelOfStrong: LevelOfStrong,
    onLevelOfStrongSelected: (LevelOfStrong) -> Unit,
    onBackPressed: () -> Unit,
    onSavedClicked: () -> Unit,
    onChooseLevelOfStrong: (LevelOfStrong) -> Unit,
    onAddPartOfMixClicked: () -> Unit,
    addingCustomMixViewModel: AddingCustomMixViewModel
) {

    Scaffold(
        topBar = {
            TopAppBar(
                modifier = Modifier
                    .fillMaxWidth(),
                title = {

                    Text(
                        text = "Add Your Mix",
                        fontFamily = fontFamily
                    )
                },
                navigationIcon = {
                    IconButton(
                        onClick = { onBackPressed() }
                    ) {
                        Icon(
                            imageVector = Icons.Outlined.ArrowBack,
                            contentDescription = "Back",
                        )
                    }
                },
                actions = {

                    LevelOfStrongDropDown(
                        levelOfStrong = levelOfStrong,
                        onLevelOfStrongSelected = onChooseLevelOfStrong
                    )

                },

            )
        },
        floatingActionButton = {
            FloatingActionButton(
                modifier = Modifier.padding(bottom = FAB_PADDING),
                onClick = { onSavedClicked() }
            ) {
                Column(
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Icon(
                        modifier = Modifier.size(36.dp),
                        painter = painterResource(id = R.drawable.outline_save),
                        contentDescription = "Add"
                    )
                }

            }
        }

    ) {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(it)
        ) {

            OutlinedTextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(LARGE),
                value = mixName,
                onValueChange = { onMixNameChange(it) },
                label = {
                    Text(
                        text = "Enter Mix Name",
                        fontFamily = fontFamily,
                    )
                }
            )


            Spacer(modifier = Modifier.height(MEDIUM))

            OutlinedTextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(LARGE),
                value = description,
                onValueChange = { onDescriptionChange(it) },
                label = {
                    Text(
                        text = "Enter description",
                        fontFamily = fontFamily
                    )
                }
            )

            Spacer(modifier = Modifier.height(MEDIUM))

            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {

                Button(
                    modifier = Modifier
                        .padding(end = BUTTON_PADDING_FROM_END),

                    onClick = {  },

                    ) {
                    Text(
                        modifier = Modifier
                            .padding(
                                start = MEDIUM,
                                end = MEDIUM
                            ),
                        text = "Choose flavors Tags",
                        fontFamily = fontFamily
                    )
                }

                Button(
                    modifier = Modifier
                        .padding(end = BUTTON_PADDING_FROM_END),

                    onClick = { onAddPartOfMixClicked() },

                    ) {
                    Text(
                        modifier = Modifier
                            .padding(
                                start = MEDIUM,
                                end = MEDIUM
                            ),
                        text = "Add Flavour",
                        fontFamily = fontFamily
                    )
                }
            }

            val partOfMixes by addingCustomMixViewModel.allPartOfMix.collectAsState()


            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(bottom = BOTTOM_PADDING),

                ) {
                items(items = partOfMixes, key = { it.partOfMixId}) { partOfMix->
                    PartOfMixCard(partOfMix = partOfMix)
                }
            }
        }
    }
}

