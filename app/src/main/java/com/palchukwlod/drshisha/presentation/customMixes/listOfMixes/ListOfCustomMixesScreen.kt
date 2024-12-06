@file:OptIn(ExperimentalMaterial3Api::class)

package com.palchukwlod.drshisha.presentation.customMixes.listOfMixes

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.example.shishamixcompouse.util.AppBarState
import com.example.shishamixcompouse.util.RequestState
import com.palchukwlod.drshisha.data.entity.customMix.CustomMix
import com.palchukwlod.drshisha.navigation.NavigationState
import com.palchukwlod.drshisha.navigation.Screen


@Composable
fun ListOfMixesScreenContent(
    customMixes: RequestState<List<CustomMix>>,
    listOfMixesViewModel: ListOfMixesViewModel,
    appBarState: AppBarState,
    searchTextState: String,
    navigationState: NavigationState,
    onShishaMixClicked: (CustomMix) -> Unit,

    ) {


    Scaffold(
        modifier = Modifier
            .fillMaxSize(),

        topBar = {
            CustomMixAppBar(
                appBarState = appBarState,
                searchTextState = searchTextState,
                listOfMixesViewModel = listOfMixesViewModel,
            )

        },
        floatingActionButton = {
            Icon(Icons.Filled.Add, contentDescription = null, tint = Color.Green)
        }

    ) {
        if (customMixes is RequestState.Success) {
            if (customMixes.data.isEmpty()) {
                EmptyContent(
                    onAddMixClicked = {
                        navigationState.navigateToWithBackStack(Screen.AddingMixes.route)
                    }
                )
            } else {
                DisplayShishaMixes(
                    customMixes = customMixes.data,
                    listOfMixesViewModel = listOfMixesViewModel,
                    paddingValues = it
                ) {
                    onShishaMixClicked(it)
                }
            }
        }
    }
}


@Composable
fun DisplayShishaMixes(
    paddingValues: PaddingValues,
    customMixes: List<CustomMix>,
    listOfMixesViewModel: ListOfMixesViewModel,
    onShishaMixClicked: (CustomMix) -> Unit
) {

    LazyColumn(
        modifier = Modifier
            .background(Color.Transparent),
//            .padding(bottom = 72.dp, top = 48.dp),
        contentPadding = paddingValues,
    ) {

        items(items = customMixes, key = { it.customMixId }) { customMix ->

            CardItem(
                modifier = Modifier,
                customMix = customMix,
                onShishaMixClicked = {onShishaMixClicked(customMix)},
                onDelete = {listOfMixesViewModel.deleteCustomMix(customMix)},
                onEdit = {}
            )

        }
    }
}
